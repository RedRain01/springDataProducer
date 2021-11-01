/*
package com.example.springgateway;

import org.junit.Test;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class Demo {


    @Test
    public void getss(){
        StepVerifier.create(
                        Flux.just("flux,ww,ee,rr")
                                .map(it ->{
                                     String s = it + ",77";
                                    int i = 0 / 89;
                                    int wi = 0 / 89;
                                    int r =98/0;
                                     String SS=null;
                                     SS.split("");
                                    return s;
                                })
                               */
/* .onErrorResume(e -> {
                                    System.out.println("--------------"+e.getMessage());
                                    return  Mono.just("==============="+e.getMessage());
                                })*//*

                                .map(it ->{
                                    it.equals("333");
                                    return "44";
                                })
                                .onErrorResume(t ->Mono.just("ceshi"))
                                .onErrorReturn("\"------------------eeee---------\"")
                                .onErrorMap(e ->new Exception("----------------"+e.getMessage()))
                                // 将每个字符串拆分为包含一个字符串的字节流
                                .flatMap(s -> Flux.fromArray(s.split(","))
                                        //对每个元素延迟1000ms
                                        .delayElements(Duration.ofMillis(1000)))
                                // 对每个元素进行打印 doOnNext不会消费数据流
                                .doOnNext(System.out::print))
                //验证是否发出了8个元素

                .expectNextCount(1)

               .verifyComplete();
    }


*/
/*
    @Test
    public  void dd(){
        Map<String,String> map=new HashMap<>();
        map.put("name","瓜田李下");
        map.put("age","20");
        StepVerifier.create(
     Flux.just(map).flatMap(m -> {
            String name=m.get("name");
            Integer age=Integer.parseInt(m.get("age"));
            Person person=new Person();
            person.setName(name);
            person.setAge(age);

            return Flux.just(person);
        }).subscribe(System.out::println));

    }
*//*


    class Person{

        private String name;
        private Integer age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

}}
*/
