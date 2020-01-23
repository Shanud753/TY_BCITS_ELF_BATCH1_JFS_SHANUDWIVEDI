package com.bcits.springcoreannotations.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import lombok.Data;

@Data
public class MessageBean implements InitializingBean, DisposableBean {

	private String message;

	public MessageBean() {
		System.out.println("Its Instantiation Phase!");
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Its Initialization Phase!");		
		
	}
	
	@Override
	public void destroy() throws Exception {
	System.out.println("Its Destroy Phase!");	
	}

	
	
	
}//End of Class
