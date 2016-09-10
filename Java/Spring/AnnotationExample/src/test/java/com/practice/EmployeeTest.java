package com.practice;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/beans.xml"})
public class EmployeeTest {

	@Autowired
	ApplicationContext context;

	@Test
	public void testContext() {
		assertNotNull(context);
	}
	
	@Test
	public void testAddressAutowire() {
		Employee emp = context.getBean("emp", Employee.class);
		assertNotNull(emp);
		assertNotNull(emp.getAddress());
	}
}
