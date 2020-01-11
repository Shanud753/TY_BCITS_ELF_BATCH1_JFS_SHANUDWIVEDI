package com.bcits.jpawithhibernatealloperations.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bcits.jpawithhibernatealloperations.bean.EmployeePrimaryInfo;

public class InsertEmployee {
	public static void main(String[] args) {
     
		EmployeePrimaryInfo employeePrimaryInfo = new EmployeePrimaryInfo();
		EntityTransaction transaction = null;  
		EntityManager entityManager = null;
		employeePrimaryInfo.setEid(13);
		employeePrimaryInfo.setEname("Manisha");
		employeePrimaryInfo.setMobile_no(9876543231l);
		employeePrimaryInfo.setOfficial_mailid("manishaa1@gmail.com");
		employeePrimaryInfo.setDob(java.sql.Date.valueOf("1997-12-14"));
		employeePrimaryInfo.setDoj(java.sql.Date.valueOf("2018-10-24"));
		employeePrimaryInfo.setDesignation("tester");
		employeePrimaryInfo.setBld_grp("o+");
		employeePrimaryInfo.setSalary(40000.0);
		employeePrimaryInfo.setDepId(30);
		employeePrimaryInfo.setMrgId(105);
		
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("employeePrimaryInfo");
			entityManager = entityManagerFactory.createEntityManager();
		    transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(employeePrimaryInfo);
			System.out.println("Record Saved");                                               
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		finally {
			entityManager.close();	
		}	
	}
}
