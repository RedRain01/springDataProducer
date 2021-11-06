package com.example.springevent.controller;


import com.example.springevent.service.StudentService;
import com.example.springpublic.entity.event.ResultBase;
import com.netflix.discovery.EurekaClient;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cglib.proxy.Mixin;
import org.springframework.context.annotation.Lazy;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import reactor.core.publisher.Mono;

@Validated
@RestController
public class StudentController {

    @Autowired
    @Lazy
    private EurekaClient eurekaClient;

    @Value("${spring.application.name}")
    private String appName;

    @Autowired
    private StudentService studentService;

/*

    // Spring recommend final and passed in constructor
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // can be visited by /api/students or /api/students/
    // @GetMapping("/") can only be visited via /api/students/
    @GetMapping("")
    public Flux<Student> index() {
        return studentService.findAll();
    }
*/

    @Data
    static class ModifyReq {
        private String address;
        private String remark;
    }

/*    @ResponseBody
    @RequestMapping("/code")
    public Mono<ResultBase> code(@RequestBody String eventUser) {
       String code="S0001";
        return studentService.findStudentByCode(code)
                .zipWhen(student -> studentService.updateStudentProfile(student, "req.address", "888"),
                        (student, studentSaved) -> studentSaved
                )
                .map(student -> ResultBase.OK())
                ;
    }*/
    @ResponseBody
    @RequestMapping("/ddd")
    public String ddd(@RequestBody String eventUser) {
        String idInEureka = eurekaClient.getApplication(appName).getInstances().get(0).getId();
        String code="S0001----------"+idInEureka;
        return code;
    }

   @RequestMapping("/tee")
    public Mono<ResultBase> tee () {
        String code="S0001";
        return studentService.findStudentByCode(code)
                .zipWhen(student -> studentService.updateStudentProfile(student, "req.address", "888"),
                        (student, studentSaved) -> studentSaved
                )
                .map(student -> ResultBase.OK())
                ;
    }


/*    @RequestMapping("/ee")
    public Mono<ResultBase> ee () {
        String code="S0001";
        return studentService.findStudentByCode(code)
                .zipWhen(student -> studentService.updateStudentProfile(student, "req.address", "888"),
                        (student, studentSaved) -> studentSaved
                )
                .map(student -> ResultBase.OK())
                ;
    }*/

    @RequestMapping("/eee")
    public String eee () {
        return "S0001";
    }
    @GetMapping("/greetingWithParam")
    public Mono<String> greetingWithParam(@RequestParam(value = "id") Long id) {
        String idInEureka = eurekaClient.getApplication(appName).getInstances().get(0).getId();
        return Mono.just(String.format("Hello with param from '%s'!", idInEureka));
    }

    @GetMapping("/greeting")
    public Mono<String> greeting() {
        String idInEureka = eurekaClient.getApplication(appName).getInstances().get(0).getId();
        return Mono.just(String.format("Hello from '%s'!", idInEureka));
    }


    @GetMapping("/tete")
    public Mono<String> tete() {
        return Mono.just(String.format("Hello with param from '%s'!"));
    }
}
