package com.example.springgateway.controller;

import com.alibaba.fastjson.JSON;
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
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
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
    @RequestMapping("/ddd")
    public  String ddd() {
        return eventUserService.ddd("9999");
    }

    /**
     * 登录接口
     * @return
     */
    @PostMapping("/tee")
    public  Mono<BaseOut> tee() {
        log.info("-------------45----------------------------");
        return Mono.just("")
                .flatMap(eventUserService::code)
               /* .onErrorMap(e ->new RuntimeException("change error type"))
                .doOnNext(i ->log.info("------------6666---------------------",i))*/
           /*     .onErrorResume(e ->{
                    log.info("-------------3----------------",e.getMessage());
                    return Mono.just(new ResultBase("erorr","123456789"));
                })*/
                //  .onErrorResume(e ->Mono.just(new ResultBase("erorr","123456789")))
               /* .filter(it ->{
                    log.info("=======55=========",it);
                })
                .filter(it ->"".equals(it))*/
                .map(it ->{
                    if (it == null) {
                        log.info("=======55=========");
                    }else {
                        log.info("================",it.getMessage());
                    }
                    return  it;
                })
                .map(it ->new BaseOut("success","登录成功"))
                .onErrorMap(e ->new RuntimeException("change error type"+e.getMessage()))
                .switchIfEmpty(Mono.just(new BaseOut("error","登录失败")));
    }


    /**
     * 登录接口
     * @return
     */
    @PostMapping("/ee")
    public  Publisher<ClientResponse> ee() {
        WebClient client = WebClient.create("http://localhost:8003");
        Mono<ClientResponse> exchange = client.get()
                .uri("/ee")
                .accept(MediaType.TEXT_PLAIN)
                .exchange();
        return  exchange;
    }

}
