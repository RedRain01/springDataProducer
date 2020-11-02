package com.example.springservice.util;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * @author ：why
 * @description：TODO
 * @date ：2020/3/30 22:59
 */

@Slf4j
@Service
public class Kafkautils {
    private static Logger LOG = LoggerFactory.getLogger(Kafkautils.class);

    private  static KafkaTemplate<Integer, String> kafkaTemplate;

    @Autowired
    public  Kafkautils(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    public static  void sendMessage(String topic, String data) {
        try {
            LOG.info("kafka sendMessage start");
            ListenableFuture<SendResult<Integer, String>> future = kafkaTemplate.send(topic, data);
            future.addCallback(new ListenableFutureCallback<SendResult<Integer, String>>() {
                public void onFailure(Throwable ex) {
                    LOG.error("kafka sendMessage error, ex = {}, topic = {}, data = {}", ex, topic, data);
                }
                public void onSuccess(SendResult<Integer, String> result) {
                    LOG.info("kafka sendMessage success topic = {}, data = {}",topic, data);
                }
            });
            LOG.info("kafka sendMessage end");
        } catch (Exception e) {
            LOG.info("================================",e);
            e.printStackTrace();
        }
    }
}
