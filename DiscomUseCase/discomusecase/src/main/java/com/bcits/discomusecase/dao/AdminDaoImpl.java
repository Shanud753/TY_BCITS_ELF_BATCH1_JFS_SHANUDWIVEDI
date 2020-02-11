package com.bcits.discomusecase.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import com.bcits.discomusecase.beans.AdminInfo;
import com.bcits.discomusecase.beans.EmployeeMaster;
@Repository
public class AdminDaoImpl implements AdminDao{
	
	@PersistenceUnit
	private EntityManagerFactory factory ;
	


	@Override
	public AdminInfo authenticate(String username, String password) {
		EntityManager manager = factory.createEntityManager();
		AdminInfo adminInfo = manager.find(AdminInfo.class, username);
		if(adminInfo != null && adminInfo.getPassword().equals(password)) {
			return adminInfo;
		}
		manager.close();
			return null;
		}
	

	@Override
	public boolean addEMployee(EmployeeMaster empInfo) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(empInfo);
			transaction.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
		}
	return false;
	}
}
