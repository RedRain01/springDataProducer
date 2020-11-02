package com.example.springregistered;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringregisteredApplication {


    public static void main(String[] args) {
        SpringApplication.run(SpringregisteredApplication.class, args);
    }

}
