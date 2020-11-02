package com.example.springservice.controller;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.example.springpublic.entity.OderAddParam;
import com.example.springpublic.entity.Order;
import com.example.springpublic.entity.Orderdetail;
import com.example.springservice.service.OrderService;
import com.example.springservice.service.OrderdetailService;
import com.example.springservice.service.UserService;
import com.example.springservice.util.Kafkautils;
import com.example.springservice.util.LockUtil;
import com.example.springservice.util.Myutil;
import com.example.springservice.util.RedisUtil;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.UUID;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author ：why
 * @description：TODO
 * @date ：2020/10/4 12:51
 */

@Slf4j
@RestController
public class OrderFlinkController {

    @Autowired
    private UserService userService;

    @Value("${server.port}")
    String port;


    @Autowired
    private OrderdetailService orderdetailService;

    @Autowired
    private OrderService orderService;


    @Autowired
    private RedisUtil redisUtil;

    private Integer orderFileNm=0;

    private Integer orderId =6099;

    static final String KEY = "LOCK_KEY";
    /*
商品名称，商品价格，商品数量
*/

    @RequestMapping("/test")
    public String test(@RequestParam(value = "name", defaultValue = "forezp") String name) {
        return "hi " + name + " ,i am ------- port:"+port ;
    }

    @ResponseBody
    @RequestMapping("/addOrderFlink")
    public String addOrderFlink(@RequestBody OderAddParam oderAddParam) {
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
                int [] a1={0,1,2,3,7};
                int [] a2={5,6,4,8,9};
//                UUID uuid = UUID.randomUUID();
//                String uuidStr = uuid.toString();
                Order order=new Order();
                //测试数据延迟代码
//                if ("1".equals(oderAddParam.getPartitionNum())) {
//                    order.setId(String.valueOf(a1[i]));
//                }else {
//                    order.setId(String.valueOf(a2[i]));
//                }
                order.setId(String.valueOf(orderId));
                order.setCommodityId(oderAddParam.getCargoNum());
                order.setOrderNum(1);
                order.setUsercode(oderAddParam.getUserCode());
                order.setStatus("00");
                order.setAddr(Myutil.getPartition(oderAddParam.getPartitionNum()));
                order.setAmount(oderAddParam.getPrice());
                order.setPhoneNum("15580275047");
                order.setCreateTime(new Date());
                order.setOrderFlag(port);
                orderId++;
                threadPoolExecutor.execute(() ->
                        this.check(order)
                );
            }
        } catch (Exception e) {
            log.error("新增订单异常",e);
            return "新增订单异常"+e.getMessage();
        }
        return "正在新增,可点击（查询消费）刷新数据<<<<<<<<<<<";
    }
    private void check(Order order) {
        //上锁
        LockUtil.lock(KEY);
        try {
            int i = orderService.create(order);
            if (i == 1) {
                Kafkautils.sendMessage("order-213", JSON.toJSONString(order));
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
            log.error("新增订单异常，订单信息"+JSON.toJSON(order),e);
            //异常处理
        } finally {
            //释放锁
            LockUtil.unlock(KEY);
        }

    }
}
