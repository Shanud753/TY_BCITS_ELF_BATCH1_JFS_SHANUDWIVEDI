package com.bcits.jpawithhibernatepractice.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bcits.jpawithhibernatepractice.bean.Demo;

public class InsertEmployee 
{
	public static void main( String[] args )
	{
		EntityTransaction transaction = null;  
		EntityManager manager = null;
		Demo demo = new Demo();
		demo.setEid(12);
		demo.setEname("Manish");
		demo.setMobile_no(9876543251l);
		demo.setOfficial_mailid("manish1@gmail.com");
		demo.setDob(java.sql.Date.valueOf("1996-12-14"));
		demo.setDoj(java.sql.Date.valueOf("2017-10-24"));
		demo.setDesignation("manager");
		demo.setBld_grp("b+");
		demo.setSalary(50000.0);
		demo.setDepId(40);
		demo.setMrgId(103);

		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("demo");
			manager = entityManagerFactory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(demo);
			System.out.println("Record Saved");
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}finally {
			manager.close();
		}
	}
}