package org.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(Person.class)
public class MyConfiguration {

	@Autowired
	public MyConfiguration(Person person) {
		System.out.println(person);
	}
	
}
