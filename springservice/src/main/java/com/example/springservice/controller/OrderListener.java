package com.example.springservice.controller;

import com.alibaba.fastjson.JSON;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class OrderListener {

    /**
     * 批处理方式
     *
     * @param records'0 09 bv 0
     *            批数据
     */

    @KafkaListener(topics = {"order-213"})
    public void listen(List<ConsumerRecord<String, String>> records)
    {
        System.out.println("-------------------"+JSON.toJSONString(records));
        System.out.println("-------------------"+JSON.toJSONString(records));
    }


}
