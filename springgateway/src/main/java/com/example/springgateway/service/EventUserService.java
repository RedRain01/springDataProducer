package com.example.springgateway.service;

import com.example.springpublic.entity.event.Event;
import com.example.springpublic.entity.event.EventUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Component
@FeignClient(name = "springService")
public interface EventUserService {

    @RequestMapping(value = "/queryByEventUser",method = RequestMethod.GET)
    public List<EventUser> queryByEventUser(@RequestBody EventUser eventUser);

}

