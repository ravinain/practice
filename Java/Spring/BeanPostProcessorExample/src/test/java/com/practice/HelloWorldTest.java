package com.practice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/spring.xml"})
public class HelloWorldTest {
	
	@Autowired
	AbstractApplicationContext appCtxt;
	
	@Test
	public void helloNotNull() {
		HelloWorld hello = appCtxt.getBean("hello", HelloWorld.class);
		assertNotNull(hello);
		assertNotNull(hello.getType());
		assertEquals("init", hello.getType());
		
		appCtxt.close();
	}
	

}
