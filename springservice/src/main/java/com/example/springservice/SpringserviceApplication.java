package com.example.springservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;


@SpringBootApplication
@MapperScan("com.example.springservice.dao")
public class SpringserviceApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringserviceApplication.class, args);
    }

}
