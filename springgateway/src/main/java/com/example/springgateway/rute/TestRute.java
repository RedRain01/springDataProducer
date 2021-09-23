package com.example.springgateway.rute;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class TestRute {
        WebClient client = WebClient.create("http://localhost:8080");

         Mono<ClientResponse> result = client.get()
                .uri("/hello")
                .accept(MediaType.TEXT_PLAIN)
                .exchange();
}
