package com.example.springgateway.controller.event;

import com.example.springgateway.service.EventService;
import com.example.springpublic.entity.event.Event;
import com.example.springpublic.entity.event.EventUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @author ：why
 * @description：TODO
 * @date ：2020/10/4 12:43
 */

@RestController
@SessionAttributes("eventUser")
public class EventController {


    @Autowired
    EventService eventService;

    @ResponseBody
    @RequestMapping("/addEvent")
    public String addEvent(Model model){
        EventUser eventUser = new EventUser();
        model.addAttribute("eventUser",eventUser);
        eventUser.setUserCode("333");
        eventUser.setPhone("3900909");
    /*    event.setUserCode(eventUser.getUserCode());
        event.setUserName(eventUser.getUserName());
        event.setParentId(0);
        event.setStatus("00");*/
/*
        String addEvent = eventService.addEvent(event);
*/
        return "addEvent";
    }

    @ResponseBody
    @RequestMapping(value = "/teee",method = RequestMethod.GET)
    public String teee(@SessionAttribute("eventUser") EventUser eventUser){
        return eventUser.getPhone();
    }


    @ResponseBody
    @RequestMapping(value = "/cc",method = RequestMethod.GET)
    public String cc(){
        return "eventUser.getPhone()";
    }
}
