package com.example.springgateway.controller.event;


import com.example.springpublic.entity.event.EventUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.WebSession;
import reactor.core.publisher.Mono;

import java.util.Date;

@Slf4j
@RestController
@SessionAttributes("stu")
public class Test {


    @ResponseBody
    @RequestMapping("/test12")
    @ModelAttribute("stu")
    public String addOrderDetil(WebSession session,Model model){
        Stu stu = new Stu("jack","123456","3333");
        session.getAttributes().put("ids",stu);
        model.addAttribute("webSession",session);
        return "model";
    }


    @RequestMapping("/demo")
    @ResponseBody
    public String demo(WebSession session){
        Stu stu = session.getAttribute("ids");
        return stu.getId();
    }

    @PostMapping("/sss")
    public String setAttribute(@ModelAttribute SessionAttributeForm sessionAttributeForm, WebSession session) {
        session.getAttributes().put(sessionAttributeForm.getAttributeName(), sessionAttributeForm.getAttributeValue());
        return "redirect:/";
    }
    @GetMapping("/")
    public String index(Model model, WebSession webSession) {
        model.addAttribute("webSession", webSession);
        return "home";
    }

    @ResponseBody
    @RequestMapping("/test771")
    public String addOrderDetil1(){
        return "999";
    }


    @ResponseBody
    @RequestMapping("/yy")
    public Mono ss(@ModelAttribute Stu stu){
        String id = stu.getId();
        stu.setId("0909");
        return null;
    }

    @RequestMapping("/caaa")
    public String parameter(@ModelAttribute("user") User user) {
        return "index";
    }
}
