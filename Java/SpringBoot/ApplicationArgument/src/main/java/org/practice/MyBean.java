package org.practice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

@Component
public class MyBean {

	@Autowired
	public MyBean(ApplicationArguments args) {
		boolean debug = args.containsOption("debug");
		System.out.println("MyBean debug enabled: " + debug);

		List<String> files = args.getNonOptionArgs();
		System.out.println("Files : " + files);
	}

}
