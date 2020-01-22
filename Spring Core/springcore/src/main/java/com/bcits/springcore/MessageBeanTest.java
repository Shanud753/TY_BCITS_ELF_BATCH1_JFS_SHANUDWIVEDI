package com.bcits.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bcits.springcore.beans.MessageBean;

public class MessageBeanTest {
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		((ConfigurableApplicationContext)context).registerShutdownHook();
		
		MessageBean messageBean = (MessageBean) context.getBean("message");
		System.out.println(messageBean.getMessage());
		
		//For Closing the Container
	//	((AbstractApplicationContext)context).close();
		
		MessageBean messageBean2 = (MessageBean) context.getBean("message");
		System.out.println(messageBean2.getMessage());
	}//End of Main()
}//End of Class
