package com.practice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorldMain {

	private static ApplicationContext context;

	public static void main(String[] args) {
		
		context = new ClassPathXmlApplicationContext("spring.xml");
		
		HelloWorld helloWorld = context.getBean("helloWorld", HelloWorld.class);
		
		System.out.println(helloWorld.getMessage1()+" \t "+helloWorld.getMessage2()+" \t "+helloWorld.getMessage3());
		
		HelloWorld helloIndia = context.getBean("helloIndia", HelloWorld.class);
		
		System.out.println(helloIndia.getMessage1()+" \t "+helloIndia.getMessage2()+" \t "+helloIndia.getMessage3());
		
	}

}
