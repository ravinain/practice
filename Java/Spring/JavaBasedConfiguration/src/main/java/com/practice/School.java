package com.practice;

public class School {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void init() {
		System.out.println("init");
	}
	
	public void cleanUp() {
		System.out.println("cleanup");
	}
}
