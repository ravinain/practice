package org.school.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Staff extends Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private double salary;
	
	@OneToMany(mappedBy = "staff", fetch=FetchType.EAGER)
	@Cascade({ CascadeType.DELETE, CascadeType.SAVE_UPDATE })
	private Set<Role> roles = new HashSet<Role>();

	@ManyToMany(mappedBy = "staffs", fetch=FetchType.EAGER)
	@Cascade({CascadeType.DELETE, CascadeType.SAVE_UPDATE})
	private Set<Subject> subjects = new HashSet<Subject>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Set<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}
	
	@Override
	public String toString() {
		return "Staff ID : "+id;
	}
}
