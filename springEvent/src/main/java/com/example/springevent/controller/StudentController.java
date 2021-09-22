package com.example.springevent.controller;

import com.example.springevent.entity.Student;
import com.example.springevent.service.StudentService;
import com.example.springpublic.entity.event.ResultBase;
import lombok.Data;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Validated
@RestController
@RequestMapping("/api/students")
public class StudentController {

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

    @Data
    static class ModifyReq {
        private String address;
        private String remark;
    }

    @GetMapping("/code")
    public Mono<ResultBase> code(

    ) {
       String code="S0001";
        return studentService.findStudentByCode(code)
                .zipWhen(student -> studentService.updateStudentProfile(student, "req.address", "888"),
                        (student, studentSaved) -> studentSaved
                )
                .map(student -> ResultBase.OK())
                ;
    }

    @RequestMapping("/code")
    public Mono<ResultBase> tee
            (
    ) {
        String code="S0001";
        return studentService.findStudentByCode(code)
                .zipWhen(student -> studentService.updateStudentProfile(student, "req.address", "888"),
                        (student, studentSaved) -> studentSaved
                )
                .map(student -> ResultBase.OK())
                ;
    }

}
