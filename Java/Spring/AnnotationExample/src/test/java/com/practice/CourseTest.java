package com.practice;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/beans.xml"})
public class CourseTest {

	@Autowired
	ApplicationContext context;
	
	@Test
	public void testContext() {
		assertNotNull(context);
	}
	
	@Test
	public void testCollectionResource() {
		Course course = context.getBean("course", Course.class);
		assertNotNull(course);
		assertNotNull(course.getSubjects());
		assertTrue(course.getSubjects().size() == 2);
	}

}
