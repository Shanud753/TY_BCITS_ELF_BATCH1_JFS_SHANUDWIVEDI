package com.bcits.jpawithhibernatealloperations.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bcits.jpawithhibernatealloperations.bean.EmployeePrimaryInfo;


public class ReAttachedEmployee {
public static void main(String[] args) {
		
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("employeePrimaryInfo");
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			EmployeePrimaryInfo info = entityManager.find(EmployeePrimaryInfo.class, 10);
			System.out.println(entityManager.contains(info));
			entityManager.detach(info);
			System.out.println(entityManager.contains(info));
			EmployeePrimaryInfo reattached = entityManager.merge(info);//merge() helps us to attach detach object
			reattached.setDesignation("HR");
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
