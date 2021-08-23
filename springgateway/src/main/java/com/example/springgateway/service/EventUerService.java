package com.example.springgateway.service;

import com.example.springpublic.entity.event.Event;
import com.example.springpublic.entity.event.EventUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
@FeignClient(name = "springService")
public interface EventUerService {

    @RequestMapping(value = "/addEvent",method = RequestMethod.GET)
    public String addEvent(@RequestBody EventUser eventUser);

}

