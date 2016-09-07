package com.practice.bo;

public class Employee {

	private int id;
	private String name;
	private int age;
	private double salary;

	/**
	 * @return the id
	 */
	public final int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public final void setId(final int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public final String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public final void setName(final String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public final int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public final void setAge(final int age) {
		this.age = age;
	}

	/**
	 * @return the salary
	 */
	public final double getSalary() {
		return salary;
	}

	/**
	 * @param salary the salary to set
	 */
	public final void setSalary(final double salary) {
		this.salary = salary;
	}

}
