package com.example.springreactorgateway.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Slf4j
@RestController
@SessionAttributes("stu")
public class Test {


    @Autowired
    private EventUserService eventUserService;



    @Autowired
    private GreetingReactiveWOtherName reactiveFeignClientOther;



    @ResponseBody
    @RequestMapping("/eee")
    public String eew() {
      return   eventUserService.eee();
    }



    @ResponseBody
    @RequestMapping("/test")
    public String eeew() {
        return   "3333333333";
    }

    @GetMapping("/greetingReactiveOther")
    public Mono<String> greetingReactiveOther() {
        return reactiveFeignClientOther.greeting().map(s -> "reactive feign other! : " + s);
    }


    @GetMapping("/rrr")
    public Mono<String> rrr() {
        Mono<String> map;
        map = Mono.just("flux,ww,ee,rr")
                .map(s -> {
                    System.out.println("===============" + s);
                    return s;
                });

        return  map;
    }


}
