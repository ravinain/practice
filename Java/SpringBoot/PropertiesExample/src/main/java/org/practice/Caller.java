package org.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Caller {

	@Autowired
	public Caller(MyBean myBean) {
		System.out.println("Name : " + myBean.getName());
	}
}
