package com.example.springgateway.service;

import com.example.springpublic.entity.Event;
import com.example.springpublic.entity.OderAddParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
@FeignClient(name = "springService")
public interface EventService {

    @RequestMapping(value = "/addEvent",method = RequestMethod.GET)
    public String addEvent(@RequestBody Event event);

}

