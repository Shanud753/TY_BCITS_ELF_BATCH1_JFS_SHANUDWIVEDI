package com.bcits.springcore.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class MessageBean implements InitializingBean,DisposableBean {

	
	private String message;
	
	public MessageBean() {
		System.out.println("Its Instantiation Phase!!!");
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Inside Init Method...");
		
	}
	@Override
	public void destroy() throws Exception {
		System.out.println("Destroying...");
		
	}
	
//	//init & destroy Phase
//	public void init() {
//		System.out.println("It's Initialization Phase");
//	}
//	public void destroy() {
//		System.out.println("Its Destruction Phase!!");
//	}
}
