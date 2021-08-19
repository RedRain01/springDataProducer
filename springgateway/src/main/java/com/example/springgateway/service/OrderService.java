package com.example.springgateway.service;

import com.example.springpublic.entity.OderAddParam;
import com.example.springpublic.entity.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Component
@FeignClient(name = "springService")
public interface OrderService {

    @RequestMapping(value = "/test",method = RequestMethod.POST)
    public Student test(@RequestBody Student student);


    @RequestMapping(value = "/addOrderDetil",method = RequestMethod.POST)
    public String addOrderDetil(@RequestBody OderAddParam oderAddParam);

    @RequestMapping(value = "/findRedis",method = RequestMethod.POST)
    public String findRedis();

    @RequestMapping(value = "/countTop",method = RequestMethod.POST)
    public String countTop();

    @RequestMapping(value = "/cleanRedis",method = RequestMethod.POST)
    public String cleanRedis();

}

