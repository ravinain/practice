package com.practice.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.practice.bo.Employee;
import com.practice.dao.EmployeeDao;

public class EmployeeDaoImpl implements EmployeeDao {

	public List<Employee> getEmployees() {
		final Session session = sessionFactory.openSession();
		final List<Employee> employees = session.createCriteria(Employee.class)
				.list();
		session.close();
		return employees;
	}

	public Employee getEmployee(final int id) {
		final Session session = sessionFactory.openSession();
		final Employee employee = (Employee) session.get(Employee.class, id);
		session.close();
		return employee;
	}

	public Employee updateEmployee(final Employee employee) {
		final Session session = sessionFactory.openSession();
		final Transaction tx = session.beginTransaction();
		try {
			session.update(employee);
			tx.commit();
		} catch (final Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
		return employee;
	}

	public Employee insertEmployee(final Employee employee) {
		final Session session = sessionFactory.openSession();
		final Transaction tx = session.beginTransaction();
		try {
			session.save(employee);
			tx.commit();
		} catch (final Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
		return employee;
	}

	public boolean deleteEmployee(final int id) {
		final Session session = sessionFactory.openSession();
		final Transaction tx = session.beginTransaction();
		boolean isDeleted = false;
		try {
			final Employee employee = getEmployee(id);
			session.delete(employee);
			tx.commit();
			isDeleted = true;
		} catch (final Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}

		return isDeleted;
	}
}
