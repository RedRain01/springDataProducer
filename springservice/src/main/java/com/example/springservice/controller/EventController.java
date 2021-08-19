package com.example.springservice.controller;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.example.springpublic.entity.Event;
import com.example.springpublic.entity.OderAddParam;
import com.example.springpublic.entity.Order;
import com.example.springservice.service.EventService;
import com.example.springservice.service.OrderService;
import com.example.springservice.service.UserService;
import com.example.springservice.util.Myutil;
import com.example.springservice.util.RedisUtil;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
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
public class EventController {


    @Autowired
    private EventService eventService;




    @ResponseBody
    @RequestMapping("/addEvent")
    public Map<String,String> addOrderFlink(@RequestBody Event event) {
        Map<String,String> map=new HashMap<>();
        try {
            int i = eventService.create(event);
            if (i >0) {
                map.put("status","success");
                map.put("msg","新增事件成功");
            }else {
                map.put("status","error");
                map.put("msg","新增事件失败");
            }
        } catch (Exception e) {
            map.put("status","error");
            map.put("msg","新增事件异常"+e.getMessage());
            log.error("新增事件异常",e);
        }
        return  map;
    }

}
