package com.example.testdemo.controller;


import org.springframework.boot.autoconfigure.security.servlet.SecurityFilterAutoConfiguration;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.support.HttpRequestHandlerServlet;


@Controller
public class StudentController {


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


    @ResponseBody
    @RequestMapping("/oo")
    public String oo () {
        return "111";
    }

    @ResponseBody
    @RequestMapping("/ii")
    public String ii () {
        return "222";
    }

    @ResponseBody
    @RequestMapping("/yy")
    public String yy () {
        return "333";
    }
    @ResponseBody
    @RequestMapping("/uu")
    public String uu () {
        return "444";
    }


}
