package com.jpawithhibernatepractice.jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class UpdateEmployee {
	public static void main(String[] args) {

		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("demo");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			String jpql = " update Demo set designation = 'Software Developer' where eid = 3 ";
			Query qry = manager.createQuery(jpql);
			int count = qry.executeUpdate();
			System.out.println("No of Rows Effecetd  " + count);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}

		manager.close();
	}//End of Main
}//End of Class
