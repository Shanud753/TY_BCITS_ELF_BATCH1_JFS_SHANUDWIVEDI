package com.bcits.jpawithhibernatepractice.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bcits.jpawithhibernatepractice.bean.Demo;

public class UpdateEmployee {
	public static void main(String[] args) {

		EntityManager manager = null;
		EntityTransaction transaction = null;

		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("demo");
			manager = entityManagerFactory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			Demo info = manager.find(Demo.class, 1);
			info.setSalary(900000);   //for updating the record
			transaction.commit();
			System.out.println("Record updated");
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		finally {
			manager.close();
		}
	}//End of Main
}//End of Class
