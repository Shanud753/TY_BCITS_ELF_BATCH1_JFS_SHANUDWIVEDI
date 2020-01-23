package com.bcits.springcoreannotations.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.bcits.springcoreannotations.beans.EmployeeBean;

@Configuration
public class EmployeeConfig {

	/*
	 * @Bean public EmployeeBean getEmployeeBean() {
	 * 
	 * EmployeeBean employeeBean = new EmployeeBean();
	 * employeeBean.setName("Shanu"); employeeBean.setAge(21);
	 * 
	 * return employeeBean; }//End of getEmployeeBean()
	 */	
	
	
	//for passing the values at runtime
	/*
	 * @Bean
	 * 
	 * @Scope("prototype") //to change the scope from singleton to prototype public
	 * EmployeeBean getEmployeeBean() {
	 * 
	 * return new EmployeeBean();
	 * 
	 * }
	 *///End of getEmployeeBean()
	@Bean
	public EmployeeBean getEmployeeBean() {
		
	  return new EmployeeBean();
		
	}
}//End of Class
