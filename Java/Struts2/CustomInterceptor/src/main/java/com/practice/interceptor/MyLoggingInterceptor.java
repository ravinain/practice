package com.practice.interceptor;

import java.util.logging.Logger;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.opensymphony.xwork2.util.ValueStack;

public class MyLoggingInterceptor implements Interceptor {

	private static final long serialVersionUID = 6253572701555940194L;
	Logger logger = Logger.getLogger(getClass().getName());

	public void destroy() {
		logger.info("Destroying " + getClass().getName() + " interceptor!");
	}

	public void init() {
		logger.info("Initializing " + getClass().getName() + " interceptor!");
	}

	public String intercept(final ActionInvocation arg0) throws Exception {
		final ValueStack vs = arg0.getInvocationContext().getValueStack();
		logger.info("Name :" + vs.findString("user.name"));

		return arg0.invoke();
	}

}
