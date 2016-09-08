package com.practice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.practice.service.EmployeeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/bean.xml"})
public class EmployeeServiceTest {

	@Autowired
	EmployeeService empSer;
	
	@Test
	public void testEmployeeConsDI() {
		assertNotNull(empSer);
		assertNotNull(empSer.getEmpList());
		assertNotNull(empSer.getEmpSet());
		assertNotNull(empSer.getEmpMap());
		assertNotNull(empSer.getEmpProp());
		
		assertTrue(empSer.getEmpList().size() == 3);
		assertTrue(empSer.getEmpSet().size() == 3);
		assertTrue(empSer.getEmpProp().size() == 3);
		assertTrue(empSer.getEmpMap().size() == 3);
		
		assertEquals("A", empSer.getEmpList().get(0).getName());
		assertEquals("B", empSer.getEmpMap().get(2).getName());
		assertEquals("C", empSer.getEmpProp().get("3"));
	}
}
