package com.practice.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Immutable;

@Entity
@Table(name = "Employee")
@Immutable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY, region = "employee")
public class Employee {

	@Id
	@Column(unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private double salary;
	private int age;
	private String gender;

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
	 * @return the gender
	 */
	public final String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public final void setGender(final String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Id : " + this.id + " Name : " + this.name;
	}
}
