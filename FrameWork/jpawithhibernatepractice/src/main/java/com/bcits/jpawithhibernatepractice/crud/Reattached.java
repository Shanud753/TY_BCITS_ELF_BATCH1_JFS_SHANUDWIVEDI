package com.bcits.jpawithhibernatepractice.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bcits.jpawithhibernatepractice.bean.EmployeePrimaryInfo;

public class Reattached {
	public static void main(String[] args) {
		
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("demo");
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			EmployeePrimaryInfo info = entityManager.find(EmployeePrimaryInfo.class, 9);
			System.out.println(entityManager.contains(info));
			entityManager.detach(info);
			System.out.println(entityManager.contains(info));
			EmployeePrimaryInfo reattached = entityManager.merge(info);//merge() helps us to attach detach object
			reattached.setDesignation("Software Developer");
			System.out.println("executed");
			transaction.commit();
			System.out.println("record updated");
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			entityManager.close();
		}
	}
}
