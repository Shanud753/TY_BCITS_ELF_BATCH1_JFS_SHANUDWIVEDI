package com.bcits.springrest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

@Configuration
public class EntityManagerFactoryConfig {

	/*
	 * @Bean public LocalContainerEntityManagerFactoryBean getEntityManager() {
	 * LocalContainerEntityManagerFactoryBean factoryBean = new
	 * LocalContainerEntityManagerFactoryBean();
	 * factoryBean.setPersistenceUnitName("emsPersistenceUnit");
	 * 
	 * return factoryBean; }//End of getEntityManager()
	 */

	
	  @Bean public LocalEntityManagerFactoryBean getEntityManagerFactoryBean() {
	  LocalEntityManagerFactoryBean factoryBean = new
	  LocalEntityManagerFactoryBean();
	  factoryBean.setPersistenceUnitName("emsPersistenceUnit");
	  
	  return factoryBean; 
	  }//End of getEntityManagerFactoryBean()
	 
}// End of Class
