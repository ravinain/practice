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
	HelloWorld hello;
	
	@Autowired
	ApplicationContext appCtxt;
	
	@Test
	public void helloNotNull() {
		assertNotNull(hello);
	}
	
	@Test
	public void getMessageTest() {
		hello.setMessage("Hello World!");
		assertEquals("Hello World!", hello.getMessage());
	}
	
	@Test
	public void testHelloPrototype() {
		HelloWorld hello1 = appCtxt.getBean("helloP", HelloWorld.class);
		assertNotNull(hello1);
		hello1.setMessage("Hello World!");
		
		assertEquals("Hello World!", hello1.getMessage());
		
		HelloWorld hello2 = appCtxt.getBean("helloP", HelloWorld.class);
		assertNotNull(hello2);
		assertNull(hello2.getMessage());
	}
}
