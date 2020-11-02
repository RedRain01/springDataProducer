package com.example.springservice.controller;


import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.example.springpublic.entity.OderAddParam;
import com.example.springpublic.entity.Orderdetail;
import com.example.springservice.model.UserDomain;
import com.example.springservice.service.OrderdetailService;
import com.example.springservice.service.UserService;
import com.example.springservice.util.Kafkautils;
import com.example.springservice.util.LockUtil;
import com.example.springservice.util.RedisUtil;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.UUID;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/8/16.
 */
@Slf4j
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Value("${server.port}")
    String port;


    @Autowired
    private OrderdetailService orderdetailService;


    @Autowired
    private RedisUtil redisUtil;

    private Integer orderFileNm=0;

    @ResponseBody
    @PostMapping("/add")
    public int addUser(UserDomain user) {
        return userService.addUser(user);
    }

    static final String KEY = "LOCK_KEY";

    /*   @ResponseBody
       @RequestMapping("/testRedis")
       public Student test(@RequestBody Student student){
           redisUtil.set("test","这只是一个测试");
           Object test = redisUtil.get("test");
           if (null != test) {
               return test.toString();
           }
           return null;
           student.setNaem("22222222-----------"+port);
           return null;
       }
   */
    @ResponseBody
    @RequestMapping("/findRedis")
    public String findRedis() {
        log.info("进入redis查询");
        if (orderFileNm!=0){
            log.error("新增订单异常");
            return "新增订单异常, 失败数据："+orderFileNm;
        }
        try {
            String allNum = "0";
            String portNum = "0";
            String fileNum = "0";
            Object allPort = redisUtil.get("allport");
            Object portStr = redisUtil.get(port);
            Object filePort = redisUtil.get(port + "file");
            if (allPort != null) {
                allNum = allPort.toString();
            }
            if (portStr != null) {
                portNum = portStr.toString();
            }
            if (filePort != null) {
                fileNum = filePort.toString();
            }
            log.info("redis查询结束");
            return "总订单量：" + allNum + ",端口" + port + "订单量：" + portNum + ",失败订单：" + fileNum;
        } catch (Exception e) {
            log.error("redis查询异常", e);
            return "获取redis异常" + e.getMessage();
        }
    }

    @ResponseBody
    @RequestMapping("/cleanRedis")
    public String cleanRedis() {
        log.info("开始clean");
        try {
            redisUtil.set(port, 0);
            redisUtil.set("allport", 0);
            redisUtil.set(port + "file", 0);
            log.info("结束clean");
            return "成功";
        } catch (Exception e) {
            log.info("clean异常", e);
            return "clean失败" + e.getMessage();
        }

    }


    @ResponseBody
    @GetMapping("/addOrder")
    public Object addOrder() {
        try {
            for (int i = 0; i < 5; i++) {
                UUID uuid = UUID.randomUUID();
                String uuidStr = uuid.toString();
                Orderdetail orderdetail = new Orderdetail();
                orderdetail.setOrderid(uuidStr);
                orderdetail.setOrderTime(new Date());
                int ss = orderdetailService.create(orderdetail);
                if (ss != 1) {
                    System.out.printf("======eeeeeee=====" + ss);
                }
            }
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "erroy";
        }
    }


    /*
   商品名称，商品价格，商品数量
    */
    @ResponseBody
    @RequestMapping("/addOrderDetil")
    public String addOrderDetil(@RequestBody OderAddParam oderAddParam) {
        try {
            orderFileNm=0;
            log.info("进入新增订单《《《《《《《《《《");
            if (StringUtils.isEmpty(oderAddParam.getCargoNum()) || StringUtils.isEmpty(oderAddParam.getUserCode()) || oderAddParam.getPrice() < 1 || oderAddParam.getQuantity() < 1) {
                log.info("新增参数有误，请查证：" + JSON.toJSONString(oderAddParam));
                return "新增参数有误，请查证：" + JSON.toJSONString(oderAddParam);
            }
            //线程池创建
            ThreadFactory threadFactory = new ThreadFactoryBuilder()
                    .setNameFormat("addOrder_pool-%d")
                    .build();
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 7, 0L,
                    TimeUnit.MILLISECONDS,
                    new LinkedBlockingQueue<>(10000),
                    threadFactory,
                    new ThreadPoolExecutor.AbortPolicy());
            //获取端口redis
            Object portNum = redisUtil.get(port);
            if (null == portNum) {
                redisUtil.set(port, oderAddParam.getQuantity());
            } else {
                redisUtil.incr(port, oderAddParam.getQuantity());
            }
            //获取allRedis
            Object allObj = redisUtil.get("allport");
            if (null == allObj) {
                redisUtil.set("allport", oderAddParam.getQuantity());
            } else {
                redisUtil.incr("allport", oderAddParam.getQuantity());
            }
            for (int i = 0; i < oderAddParam.getQuantity(); i++) {
                UUID uuid = UUID.randomUUID();
                String uuidStr = uuid.toString();
                Orderdetail orderdetail = new Orderdetail();
                orderdetail.setOrderid(uuidStr);
                orderdetail.setOrderTime(new Date());
                orderdetail.setCargoNum(oderAddParam.getCargoNum());
                orderdetail.setPort(port);
                orderdetail.setPrice(oderAddParam.getPrice());
                orderdetail.setUserCode(oderAddParam.getUserCode());
                threadPoolExecutor.execute(() ->
                        this.check(orderdetail)
                );
            }
        } catch (Exception e) {
            log.error("新增订单异常",e);
            return "新增订单异常"+e.getMessage();
        }
        return "正在新增,可点击（查询消费）刷新数据<<<<<<<<<<<";
    }

    private void check(Orderdetail orderdetail) {
        //上锁
        LockUtil.lock(KEY);
        try {
            int i = orderdetailService.create(orderdetail);
            if (i == 1) {
                Kafkautils.sendMessage("order-213", JSON.toJSONString(orderdetail));
                redisUtil.decr(port, 1);
            } else {
                //在redis记录失败数
                Object fileNum = redisUtil.get(port + "file");
                if (fileNum == null) {
                    redisUtil.set(port, 1);
                } else {
                    redisUtil.decr(port + "file", 1);
                }
            }
        } catch (Exception e) {
            orderFileNm++;
            log.error("新增订单异常，订单信息"+JSON.toJSON(orderdetail),e);
            //异常处理
        } finally {
            //释放锁
            LockUtil.unlock(KEY);
        }

    }


}
