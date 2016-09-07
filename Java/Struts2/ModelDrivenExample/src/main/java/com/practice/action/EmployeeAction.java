/**
 * 
 */
package com.practice.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.practice.bo.Employee;

/**
 * @author cdacr
 *
 */
public class EmployeeAction extends ActionSupport implements
		ModelDriven<Employee> {
	private static final long serialVersionUID = 9030410716227844929L;

	Employee emp = new Employee();

	public Employee getModel() {
		return emp;
	}

	public String fetch() {
		return SUCCESS;
	}
}
