package com.practice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Employee emp = context.getBean("emp", Employee.class);
		System.out.println(emp.getId());
		
		Gym gym = context.getBean("gym", Gym.class);
		System.out.println(gym.getInstrument().getName());
		System.out.println(gym.getInstrument().getType());
		
		Course course = context.getBean("course", Course.class);
		System.out.println(course.getSubjects().get(0).getName());
		System.out.println(course.getSubjects().get(1).getName());
	}

}
