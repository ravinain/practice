/**
 * 
 */
package com.practice;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Required;

/**
 * @author cdacr
 *
 */
public class Employee {

	private String id;
	private String name;
	private int age;
	private double salary;
	private Address address;

	public Employee() {}
	
	public Employee(Address address) {
		this.address = address;
	}
	
	public String getId() {
		return id;
	}
	
	@Required
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Address getAddress() {
		return address;
	}
	
	@Required
	public void setAddress(Address address) {
		this.address = address;
	}

	@PostConstruct
	public void init() {
		System.out.println("Init");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("Destroy");
	}
}
