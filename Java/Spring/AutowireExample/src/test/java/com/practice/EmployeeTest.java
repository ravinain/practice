package com.practice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/by-name-config.xml"})
public class EmployeeTest {

	

	@Test
	public void testAutoWireByName() {
		ApplicationContext context = new ClassPathXmlApplicationContext("by-name-config.xml");
		Employee emp = context.getBean("empByName", Employee.class);
		assertNotNull(emp);
		assertNotNull(emp.getAddress());
		assertEquals("India", emp.getAddress().getCountry());
	}
	
	@Test
	public void testAutoWireByType() {
		ApplicationContext context = new ClassPathXmlApplicationContext("by-type-config.xml");
		Employee emp = context.getBean("empByType", Employee.class);
		assertNotNull(emp);
		assertNotNull(emp.getAddress());
		assertEquals("Australia", emp.getAddress().getCountry());
	}
	
	@Test
	public void testAutoWireByConstructor() {
		ApplicationContext context = new ClassPathXmlApplicationContext("constructor-config.xml");
		Employee emp = context.getBean("empCons", Employee.class);
		assertNotNull(emp);
		assertNotNull(emp.getAddress());
		assertEquals("USA", emp.getAddress().getCountry());
	}
}
