package com.practice;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/bean.xml"})
public class EmployeeTest {

	@Autowired
	ApplicationContext appCtxt;
	
	@Test
	public void testEmployeeConsDI() {
		Employee emp = appCtxt.getBean("emp", Employee.class);
		assertNotNull(emp);
		assertNotNull(emp.getAddress());
	}
	
	@Test
	public void testEmployeeSetDI() {
		Employee emp = appCtxt.getBean("empSet", Employee.class);
		assertNotNull(emp);
		assertNotNull(emp.getAddress());
	}

}
