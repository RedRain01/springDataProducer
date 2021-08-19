package com.example.springservice.controller;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.example.springpublic.entity.OderAddParam;
import com.example.springpublic.entity.Order;
import com.example.springservice.service.OrderService;
import com.example.springservice.service.OrderdetailService;
import com.example.springservice.service.UserService;
import com.example.springservice.util.LockUtil;
import com.example.springservice.util.Myutil;
import com.example.springservice.util.RedisUtil;
import com.example.springservice.util.RedissonLocker;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import rx.internal.schedulers.CachedThreadScheduler;

import java.util.Date;
import java.util.concurrent.*;

import static javafx.scene.input.KeyCode.R;

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
    private OrderService orderService;


    @Autowired
    private RedisUtil redisUtil;


    private Integer orderId =552247;

    static final String KEY = "LOCK_KEY";
    /**
     *  商品名称，商品价格，商品数量
    */

    @RequestMapping("/test")
    public String test(@RequestParam(value = "name", defaultValue = "forezp") String name) {
        return "hi " + name + " ,i am ------- port:"+port ;
    }

    @ResponseBody
    @RequestMapping("/addOrderFlink")
    public String addOrderFlink(@RequestBody OderAddParam oderAddParam) {
        try {
            log.info("进入新增订单《《《《《《《《《《");
            if (StringUtils.isEmpty(oderAddParam.getUserCode()) || oderAddParam.getPrice() < 1 || oderAddParam.getQuantity() < 1) {
                log.info("新增参数有误，请查证：" + JSON.toJSONString(oderAddParam));
                return "新增参数有误，请查证：" + JSON.toJSONString(oderAddParam);
            }
            //线程池创建
            ThreadFactory threadFactory = new ThreadFactoryBuilder()
                    .setNameFormat("addOrder_pool-%d")
                    .build();
            //线程池参数设置
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                    3,
                    7,
                    0L,
                    TimeUnit.MILLISECONDS,
                    new LinkedBlockingQueue<>(10000),
                    threadFactory,
                    new ThreadPoolExecutor.AbortPolicy());

            //获取redis中单个端口订单数
            Object portNum = redisUtil.get(port+"port");
            if (null == portNum) {
                redisUtil.set(port+"port", 1);
            }
            //获取redis中所有端口订单数
            Object allObj = redisUtil.get("allport");
            if (null == allObj) {
                redisUtil.set("allport", oderAddParam.getQuantity());
            } else {
                redisUtil.incr("allport", oderAddParam.getQuantity());
            }
            //获取redis中存储的订单id
            Object idNumObj = redisUtil.get("idNum");
            if (idNumObj == null) {
                redisUtil.set("idNum",orderService.maxId()+1);
            }

            for (int i = 0; i < oderAddParam.getQuantity(); i++) {
                Order order=new Order();
                order.setCommodityId(Myutil.getCommodity(oderAddParam.getCargoNum()));
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
        try {
            long idNum1 = redisUtil.incr("idNum", 1);
            order.setId(String.valueOf(idNum1));
            int i = orderService.create(order);
            if (i == 1) {
                redisUtil.incr(port+"port", 1);
            } else {
                //在redis记录失败数
                redisUtil.incr(port + "file", 1);
            }
        } catch (Exception e) {
            redisUtil.incr(port + "file", 1);
            log.error("新增订单异常，订单信息"+JSON.toJSON(order),e);
            //异常处理
        }
    }
}
