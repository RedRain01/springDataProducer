package com.example.springevent.service;

import com.alibaba.fastjson.JSON;
import com.example.springevent.entity.Student;
import com.example.springevent.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class StudentService {


	private final StudentRepository studentRepository;

	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public Flux<Student> findAll() {
		return studentRepository.findAll();
	}

	public Mono<Student> findStudentByCode(String code) {
		return studentRepository.findByCodeAndActiveTrue(code)
			.switchIfEmpty(Mono.error(new IllegalArgumentException("invalid student code: " + code)));
	}

	public Mono<Student> updateStudentProfile(Student student, String address, String remark) {
		if (!StringUtils.isEmpty(address) || !StringUtils.isEmpty(remark)) {
			if (!StringUtils.isEmpty(address)) {
				student.setAddress(address);
			}

			if (!StringUtils.isEmpty(remark)) {
				student.setRemark(remark);
			}
			student.setName("99999");
			Mono<Student> save = studentRepository.save(student);
			System.out.println("======================"+JSON.toJSON(save));
			return save;
		} else {
			return Mono.error(new IllegalArgumentException("invalid parameters student update profile"));
		}
	}

}
