package com.example.springgateway.service;

import com.example.springpublic.entity.event.Event;
import com.example.springpublic.entity.event.EventUser;
import com.example.springpublic.entity.event.ResultBase;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
@FeignClient(name = "springEvenService")
public interface EventUserService {


    @RequestMapping(value = "/queryByEventUser",method = RequestMethod.GET)
    public Mono<EventUser> queryByEventUser(@RequestBody EventUser eventUser);

    @RequestMapping(value = "/code",method = RequestMethod.POST)
    public Mono<ResultBase> code(@RequestBody String eventUser);

    @RequestMapping(value = "/ee",method = RequestMethod.POST)
    public Mono<ResultBase> ee();

    @RequestMapping(value = "/eee",method = RequestMethod.POST)
    public String eee();

    @RequestMapping(value = "/ddd",method = RequestMethod.POST)
    public String ddd(@RequestBody String eventUser);

}

