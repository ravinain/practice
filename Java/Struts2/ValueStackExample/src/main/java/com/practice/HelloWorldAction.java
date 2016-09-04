package com.practice;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class HelloWorldAction extends ActionSupport implements RequestAware,
		SessionAware {
	private static final long serialVersionUID = 5686515424078842754L;
	private Map<String, Object> request;
	private Map<String, Object> session;
	private String name;

	@Override
	public String execute() throws Exception {
		final ValueStack stack = ActionContext.getContext().getValueStack();
		final Map<String, Object> context = new HashMap<String, Object>();

		context.put("key1", "This is key1");
		context.put("key2", "This is key2");
		stack.push(context);

		System.out.println("Size of the valueStack: " + stack.size());

		request.put("key3", "This is key3");

		session.put("key4", "This is key4");

		return "success";
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public void setSession(final Map<String, Object> session) {
		this.session = session;
	}

	public void setRequest(final Map<String, Object> request) {
		this.request = request;
	}
}
