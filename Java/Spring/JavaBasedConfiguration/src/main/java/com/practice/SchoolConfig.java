package com.practice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;

@Configuration
@Import(StudentConfig.class)
public class SchoolConfig {

	@Bean(initMethod="init", destroyMethod="cleanUp")
	@Scope("prototype")
	public School school() {
		School school = new School();
		school.setName("NMPS");
		return school;
	}
	
}
