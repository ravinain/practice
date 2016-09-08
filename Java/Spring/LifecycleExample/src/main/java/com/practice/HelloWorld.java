package com.practice;

public class HelloWorld {

	private String message;
	private String type;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public void init() {
		this.type = "default";
		System.out.println("Initializing HelloWorld!");
	}
	
	public void destroy() {
		this.type = null;
		System.out.println("Destroying HelloWorld!");
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
