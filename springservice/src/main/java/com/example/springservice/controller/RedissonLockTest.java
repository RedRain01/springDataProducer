package com.example.springservice.controller;

/**
 * @author ：why
 * @description：TODO
 * @date ：2020/3/24 22:43
 */


import com.example.springservice.util.LockUtil;
import com.example.springservice.util.RedisUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@RestController
public class RedissonLockTest {

    static final String KEY = "LOCK_KEY";

    @Autowired
    private RedisUtil redisUtil;

    @GetMapping("/test")
    public Object test(){
        redisUtil.set("test2",1000);
        //加锁
        int num=0;
        ThreadFactory threadFactory = new ThreadFactoryBuilder()
                .setNameFormat("addOrder_pool-%d")
                .build();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 7, 0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(10000),
                threadFactory,
                new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 998; i++) {
            UUID uuid = UUID.randomUUID();
            String uuidStr = uuid.toString();
            threadPoolExecutor.execute(() ->
                    this.test(num)
            );
        }

        return "SUCCESS";
    }
    private  void test( int num){
        LockUtil.lock(KEY);
        try {
            Object test2 = redisUtil.get("test2");
            String s = test2.toString();
            System.out.println("======================"+s);
            redisUtil.decr("test2",1);
            //TODO 处理业务
        } catch (Exception e) {
            System.out.println("======================"+e.getMessage());
            //异常处理
        }finally{
            //释放锁
            LockUtil.unlock(KEY);
        }

    }

}