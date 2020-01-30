package com.bcits.discomusecase.factory;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerGetFactory {
    private static EntityManagerFactory emf = null;
    private EntityManagerGetFactory() {}
    
    public EntityManagerFactory getEntityManagerFactoryInstance() {
    	if(emf==null) {
    		emf = Persistence.createEntityManagerFactory("discomPersistenceUnit");
    		
    		return emf;
    	}
    	return emf;
    }
    
 
}

