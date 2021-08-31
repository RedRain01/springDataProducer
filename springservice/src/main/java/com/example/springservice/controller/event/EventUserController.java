package com.example.springservice.controller.event;

import com.example.springpublic.entity.event.Event;
import com.example.springservice.service.EventService;
import com.example.springservice.service.EventUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：why
 * @description：TODO
 * @date ：2020/10/4 12:51
 */

@Slf4j
@RestController
public class EventUserController {


    @Autowired
    private EventService eventService;

    @Autowired
    private EventUserService eventUserService;




    @ResponseBody
    @RequestMapping("/addEven22t")
    public Map<String,String> addOrderFlink(@RequestBody Event event) {
        Map<String,String> map=new HashMap<>();
        try {
            int i = eventService.create(event);
            if (i >0) {
                map.put("status","success");
                map.put("msg","新增事件成功");
            }else {
                map.put("status","error");
                map.put("msg","新增事件失败");
            }
        } catch (Exception e) {
            map.put("status","error");
            map.put("msg","新增事件异常"+e.getMessage());
            log.error("新增事件异常",e);
        }
        return  map;
    }

}
