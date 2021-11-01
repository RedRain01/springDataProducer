package com.example.springservice.controller.event;

import com.netflix.discovery.EurekaClient;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Validated
@RestController
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




    @RequestMapping("/eee")
    public String eee () {
        return "S0001";
    }

    @GetMapping("/tete")
    public Mono<String> tete() {
        return Mono.just(String.format("Hello with param from '%s'!"));
    }
}
