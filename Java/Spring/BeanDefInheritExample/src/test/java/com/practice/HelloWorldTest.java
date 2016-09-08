package com.practice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/spring.xml"})
public class HelloWorldTest {
	
	@Autowired
	ApplicationContext appCtxt;
	
	@Test
	public void helloNotNull() {
		HelloWorld helloWorld = appCtxt.getBean("helloWorld", HelloWorld.class);
		
		assertNotNull(helloWorld);
		assertNotNull(helloWorld.getMessage1());
		assertNotNull(helloWorld.getMessage2());
		
		assertEquals("Hello World", helloWorld.getMessage1());
		assertEquals("Hello Second World", helloWorld.getMessage2());
		
		assertNull(helloWorld.getMessage3());
		
		HelloWorld helloIndia = appCtxt.getBean("helloIndia", HelloWorld.class);
		
		assertNotNull(helloIndia);
		assertNotNull(helloIndia.getMessage1());
		assertNotNull(helloIndia.getMessage2());
		assertNotNull(helloIndia.getMessage3());
		
		
		assertEquals("Hello India", helloIndia.getMessage1());
		assertEquals("Hello Second World", helloIndia.getMessage2());
		assertEquals("Namaste India", helloIndia.getMessage3());
	}
	

}
