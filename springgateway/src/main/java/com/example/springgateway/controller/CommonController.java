package com.example.springgateway.controller;

import com.example.springgateway.controller.event.HttpResult;
import com.example.springgateway.service.EventService;
import com.example.springgateway.service.EventUserService;
import com.example.springgateway.service.MyUserDetailsRepository;
import com.example.springpublic.entity.base.BaseOut;
import com.example.springpublic.entity.event.Event;
import com.example.springpublic.entity.base.ResultCode;
import com.example.springpublic.entity.event.EventUser;
import com.example.springpublic.entity.event.ResultBase;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.WebSession;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

@Slf4j
@RestController
public class CommonController {

    @Autowired
    EventUserService eventUserService;

    @Autowired
    EventService eventService;

    MyUserDetailsRepository myUserRepository;




    @ResponseBody
    @RequestMapping("/login123")
    public Mono<Object>  addOrderDetil(){

return null;

    }

    /**
     * 登录接口
     * @return
     */
    @RequestMapping("/login")
    public  Mono<BaseOut> login(@RequestBody Map<String, Object> param, WebSession webSession) {
        log.info("-------------45----------------------------");
        return Mono.just(new EventUser("",""))
                .flatMap(eventUserService::queryByEventUser)
                .onErrorMap(e ->new RuntimeException("change error type"))
                .doOnNext(i ->log.info("------------6666---------------------",i.getPhone()))
                .onErrorResume(e ->Mono.just(new EventUser()))
                .filter(it ->param.get("").equals(it.getPassword()))
                .map(it ->new BaseOut("success","登录成功"))
                .onErrorMap(e ->new RuntimeException("change error type"+e.getMessage()))
                .switchIfEmpty(Mono.just(new BaseOut("error","登录失败")));
    }

    /**
     * 登录接口
     * @return
     */
    @GetMapping("/tee")
    public  Mono<BaseOut> tee(@RequestBody Map<String, Object> param, WebSession webSession) {
        log.info("-------------45----------------------------");
        return Mono.just("")
                .flatMap(eventUserService::code)
                .onErrorMap(e ->new RuntimeException("change error type"))
                .doOnNext(i ->log.info("------------6666---------------------",i))
                .onErrorResume(e ->Mono.just(new ResultBase("erorr","123456789")))
                .filter(it ->param.get("").equals(it))
                .map(it ->new BaseOut("success","登录成功"))
                .onErrorMap(e ->new RuntimeException("change error type"+e.getMessage()))
                .switchIfEmpty(Mono.just(new BaseOut("error","登录失败")));
    }

}
