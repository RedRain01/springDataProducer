package com.example.springgateway;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.Duration;
import java.util.function.Function;

@Slf4j
@SpringBootTest
class SpringgatewayApplicationTests {
    public static void main(String[] args) {
        StepVerifier.create(
                        Flux.just("flux,ww,ee,rr")
                                // 将每个字符串拆分为包含一个字符串的字节流
                                .flatMap(s -> Flux.fromArray(s.split(","))
                                        //对每个元素延迟1000ms
                                        .delayElements(Duration.ofMillis(1000)))
                                .map(it ->it.equals("ee"))
                                // 对每个元素进行打印 doOnNext不会消费数据流
                                .doOnNext(System.out::print))
                //验证是否发出了8个元素
                .expectNextCount(4)
                .verifyComplete();
    }


    @Test
    public void getss(){

    }
}
