package com.bcits.discomusecase.config;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

@Configuration
public class EntityManagerFactoryConfig {
	
	  @Bean public LocalEntityManagerFactoryBean getEntityManagerFactoryBean() {
		  LocalEntityManagerFactoryBean factoryBean = new LocalEntityManagerFactoryBean();
		  factoryBean.setPersistenceUnitName("discomPersistenceUnit");
		  
		  return factoryBean; 
		  }//End of getEntityManagerFactoryBean()
    
 
}

