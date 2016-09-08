package com.practice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.practice.service.EmployeeService;

public class EmployeeTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
		EmployeeService empService = context.getBean("empService", EmployeeService.class);
		
		System.out.println(empService.getEmpList());
		System.out.println(empService.getEmpSet());
		System.out.println(empService.getEmpMap());
		System.out.println(empService.getEmpProp());
		
	}

}
