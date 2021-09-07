package com.example.springgateway.controller.event;

import com.example.springgateway.service.EventService;
import com.example.springpublic.entity.event.Event;
import com.example.springpublic.entity.event.EventUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
    @RequestMapping(value = "/addEvent",method = RequestMethod.POST)
    public String addEvent(@RequestBody Event event,HttpServletRequest request){
        HttpSession session = request.getSession();
        EventUser eventUser = (EventUser) session.getAttribute("eventUser");
        event.setUserCode(eventUser.getUserCode());
        event.setUserName(eventUser.getUserName());
        event.setParentId(0);
        event.setStatus("00");
        String addEvent = eventService.addEvent(event);
        return addEvent;
    }


}
