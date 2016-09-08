package com.practice;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class HelloWorldMain {

	public static void main(String[] args) {
		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("spring.xml"));
		HelloWorld hello = beanFactory.getBean("hello", HelloWorld.class);
		hello.setMessage("Hello World!");
		System.out.println(hello.getMessage());
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		HelloWorld hello2 = context.getBean("hello", HelloWorld.class);
		hello2.setMessage("Hello World");
		System.out.println(hello2.getMessage());
		
	}

}
