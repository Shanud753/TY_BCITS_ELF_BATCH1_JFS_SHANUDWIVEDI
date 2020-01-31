package com.bcits.discomusecase.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import com.bcits.discomusecase.beans.ConsumersMaster;


@Repository
public class ConsumerDAOImplementation implements ConsumerDAO {

	@PersistenceUnit
	private EntityManagerFactory factory ;
	
	
	@Override
	public boolean addConsumer(ConsumersMaster consumersMaster) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		boolean isAdded = false;
		try {
			transaction.begin();
			manager.persist(consumersMaster);
			transaction.commit();
			isAdded = true;
			return isAdded;
		}catch(Exception e) {
			e.printStackTrace();
			transaction.rollback();	
		}
		return isAdded;
	}


	@Override
	public ConsumersMaster authenticate(int empId, String password) {
		// TODO Auto-generated method stub
		return null;
	}
}
