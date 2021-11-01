package com.example.testdemo.controller;

import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@Controller
public class StudentController {

    @Autowired
    @Lazy
    private EurekaClient eurekaClient;

    @Value("${spring.application.name}")
    private String appName;





    @ResponseBody
    @RequestMapping("/ddd")
    public String ddd(@RequestBody String eventUser) {
        String code="S0001";
        return code;
    }

    @ResponseBody
    @RequestMapping("/eee")
    public String eee () {
        return "S0001";
    }

}
