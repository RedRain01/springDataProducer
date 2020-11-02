package com.example.springgateway.controller;

import com.example.springgateway.service.OrderFlinkService;
import com.example.springpublic.entity.OderAddParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author ：why
 * @description：TODO
 * @date ：2020/10/4 12:43
 */

@RestController
public class OrderFlinkController {


    @Autowired
    OrderFlinkService orderFlinkService;

    @ResponseBody
    @RequestMapping("/addOrderDetil")
    public String addOrderDetil(@RequestBody OderAddParam oderAddParam){
        String addOrderDetil = orderFlinkService.addOrderFlink(oderAddParam);
        return addOrderDetil;
    }

    @GetMapping(value = "hi")
    public  String sayHi(){
        return orderFlinkService.demo();
    }


}
