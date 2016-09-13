package com.practice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {

	@Bean
	public Student student() {
		Student student = new Student();
		student.setRollNumber(1);
		student.setName("A");
		return student;
	}
	
}
