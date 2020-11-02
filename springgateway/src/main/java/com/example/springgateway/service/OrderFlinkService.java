package com.example.springgateway.service;

import com.example.springpublic.entity.OderAddParam;
import com.example.springpublic.entity.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "springService")
public interface OrderFlinkService {

    @RequestMapping(value = "/addOrderFlink",method = RequestMethod.GET)
    public String addOrderFlink(@RequestBody OderAddParam oderAddParam);

    @RequestMapping(value = "/hiqq",method = RequestMethod.GET)
    String  demo();
}

