package com.practice.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.practice.bo.Employee;
import com.practice.util.HibernateUtil;

public interface EmployeeDao {

	SessionFactory sessionFactory = HibernateUtil.INSTANCE.getSessionFactory();

	List<Employee> getEmployees();

	Employee getEmployee(int id);

	Employee updateEmployee(Employee employee);

	Employee insertEmployee(Employee employee);

	boolean deleteEmployee(int id);

}
