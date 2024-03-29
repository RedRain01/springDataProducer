package com.example.springgateway;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.RestController;
import reactivefeign.spring.config.EnableReactiveFeignClients;

import java.util.stream.Collectors;

@EnableDiscoveryClient
@SpringBootApplication
@EnableEurekaClient
@RestController
@EnableReactiveFeignClients
@EnableFeignClients

/*
@EnableReactiveFeignClients
*/
public class SpringgatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringgatewayApplication.class, args);
    }


    @Bean
    @ConditionalOnMissingBean
    public HttpMessageConverters messageConverters(ObjectProvider<HttpMessageConverter<?>> converters) {
        return new HttpMessageConverters(converters.orderedStream().collect(Collectors.toList()));
    }
}
