package com.example.springgateway.controller.event;

import feign.Headers;
import feign.RequestLine;
import org.springframework.cglib.proxy.Mixin;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Headers({ "Accept: application/json" })
public interface IcecreamServiceApi {

   @RequestLine("GET /tete")
    Mono<String> tete();

}
