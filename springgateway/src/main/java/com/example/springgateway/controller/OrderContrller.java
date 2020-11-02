package com.example.springgateway.controller;

import com.alibaba.fastjson.JSON;
import com.example.springgateway.service.OrderService;
import com.example.springpublic.entity.OderAddParam;
import com.example.springpublic.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderContrller {

    @Autowired
    OrderService orderService;



/*    @CrossOrigin(allowCredentials="true", allowedHeaders="*", methods=      {RequestMethod.GET,
            RequestMethod.POST, RequestMethod.DELETE,                                        RequestMethod.OPTIONS,
            RequestMethod.HEAD,
            RequestMethod.PUT,
            RequestMethod.PATCH},
            origins="*")
    @RequestMapping("/test")
    public Object test(@RequestBody Student student){
        return orderService.test(student);
    }*/
    @ResponseBody
    @RequestMapping("/test")
    public String test(@RequestBody Student student){
        Student stu=orderService.test(student);
        return JSON.toJSONString(stu);
    }

    @ResponseBody
    @RequestMapping("/addOrderDetil12er")
    public String addOrderDetil(@RequestBody OderAddParam oderAddParam){
        String addOrderDetil = orderService.addOrderDetil(oderAddParam);
        return addOrderDetil;
    }

    @ResponseBody
    @RequestMapping("/findRedis")
    public String findRedis(){
        String addOrderDetil = orderService.findRedis();
        return addOrderDetil;
    }

    @ResponseBody
    @RequestMapping("/cleanRedis")
    public String cleanRedis(){
        String addOrderDetil = orderService.cleanRedis();
        return addOrderDetil;
    }

    @RequestMapping(value = "/aaa")
    public Object test(@RequestParam("name") String str){
    Student student=new Student();
    student.setNaem("111");
    student.setId("2222");
        return orderService.test(student);
    }
}
