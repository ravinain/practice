package com.practice;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 
 * @author cdacr
 * Implement {@link ModelDriven} interface if you want to map UI field directly with user object. 
 * Without it you have to use user. prefix to get and set the value.
 */
public class UserAction extends ActionSupport {

	private static final long serialVersionUID = -7275092674632437203L;

	User user = new User();

	public User getUser() {
		return user;
	}

	public String fetch() {
		return SUCCESS;
	}

}
