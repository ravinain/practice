package com.practice;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		//No need to register StudentConfig class as it has been imported in SchoolConfig class
		context.register(SchoolConfig.class);
		//Don't forget to refresh after registering new configuration class
		context.refresh();
		
		School school = context.getBean(School.class);
		
		System.out.println(school.getName());
		school.setName("B");
		
		Student student = context.getBean(Student.class);
		
		System.out.println(student.getName());
		
		//A new school object will return as scope is prototype
		School school2 = context.getBean(School.class);
		
		System.out.println(school2.getName());

		//to test destroy method, need to shut down the context.
		context.registerShutdownHook();
		
	}

}
