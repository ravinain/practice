package com.practice;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorldMain {

	private static AbstractApplicationContext context;

	public static void main(String[] args) {
		
		context = new ClassPathXmlApplicationContext("spring.xml");
		
		//Fetch hello object from beans configuration file.
		HelloWorld hello1 = context.getBean("hello", HelloWorld.class);
		
		context.destroy();
		
		System.out.println(hello1.getType());
		
	}

}
