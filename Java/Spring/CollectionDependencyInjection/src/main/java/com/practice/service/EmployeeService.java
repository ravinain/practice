package com.practice.service;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import com.practice.Employee;

public class EmployeeService {
	List<Employee> empList;
	Set<Employee> empSet;
	Map<Integer, Employee> empMap;
	Properties empProp;

	public List<Employee> getEmpList() {
		return empList;
	}
	public void setEmpList(List<Employee> empList) {
		this.empList = empList;
	}
	public Set<Employee> getEmpSet() {
		return empSet;
	}
	public void setEmpSet(Set<Employee> empSet) {
		this.empSet = empSet;
	}
	public Map<Integer, Employee> getEmpMap() {
		return empMap;
	}
	public void setEmpMap(Map<Integer, Employee> empMap) {
		this.empMap = empMap;
	}
	public Properties getEmpProp() {
		return empProp;
	}
	public void setEmpProp(Properties empProp) {
		this.empProp = empProp;
	}
}
