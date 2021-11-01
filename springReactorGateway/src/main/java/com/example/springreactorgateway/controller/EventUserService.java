package com.example.springreactorgateway.controller;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
@FeignClient(name = "springEvenService")
public interface EventUserService {

    @RequestMapping(value = "/eee",method = RequestMethod.GET)
    public String eee();
}

