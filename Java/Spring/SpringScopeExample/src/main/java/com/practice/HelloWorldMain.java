package com.practice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloWorldMain {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		
		//Fetch hello object from beans configuration file.
		HelloWorld hello1 = context.getBean("hello", HelloWorld.class);
		hello1.setMessage("Hello World");
		System.out.println("Hello 1 : "+hello1.getMessage());
		
		//Fetch again object from beans configuration file.
		//By default spring returns singleton object 
		//so below statement must return the same object and 
		//prints the value which was set before.
		HelloWorld hello2 = context.getBean("hello", HelloWorld.class);
		System.out.println("Hello 2 : "+ hello2.getMessage());
		
		//Fetch helloP object from beans configuration file and set the value
		HelloWorld hello3 = context.getBean("helloP", HelloWorld.class);
		hello3.setMessage("Hello India!");
		System.out.println("Hello 3 : "+hello3.getMessage());
		
		//Fetch helloP object again and call the getMessage() method it must return null.
		HelloWorld hello4 = context.getBean("helloP", HelloWorld.class);
		System.out.println("Hello 4 : "+hello4.getMessage());
	}

}
