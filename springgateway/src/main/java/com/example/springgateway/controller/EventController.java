package com.example.springgateway.controller;

import com.example.springgateway.service.EventService;
import com.example.springgateway.service.OrderFlinkService;
import com.example.springpublic.entity.Event;
import com.example.springpublic.entity.OderAddParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author ：why
 * @description：TODO
 * @date ：2020/10/4 12:43
 */

@RestController
public class EventController {


    @Autowired
    EventService eventService;

    @ResponseBody
    @RequestMapping("/addEvent")
    public String addOrderDetil(@RequestBody Event event){
        String addOrderDetil = eventService.addEvent(event);
        return addOrderDetil;
    }


}
