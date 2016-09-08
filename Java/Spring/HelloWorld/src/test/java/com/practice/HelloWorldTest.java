package com.practice;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/spring.xml"})
public class HelloWorldTest {

	@Autowired
	HelloWorld hello;
	
	@Test
	public void helloNotNull() {
		assertNotNull(hello);
	}
	
	@Test
	public void getMessageTest() {
		hello.setMessage("Hello World!");
		assertEquals("Hello World!", hello.getMessage());
	}

}
