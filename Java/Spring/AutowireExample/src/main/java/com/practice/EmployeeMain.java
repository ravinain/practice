package com.practice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("by-name-config.xml");
		
		Employee emp = context.getBean("empByName", Employee.class);
		System.out.println(emp.getAddress().getCountry());
		
		ApplicationContext context2 = new ClassPathXmlApplicationContext("by-type-config.xml");
		
		Employee emp2 = context2.getBean("empByType", Employee.class);
		System.out.println(emp2.getAddress().getCountry());
		
		ApplicationContext context3 = new ClassPathXmlApplicationContext("constructor-config.xml");
		
		Employee emp3 = context3.getBean("empCons", Employee.class);
		System.out.println(emp3.getAddress().getCountry());
	}

}
