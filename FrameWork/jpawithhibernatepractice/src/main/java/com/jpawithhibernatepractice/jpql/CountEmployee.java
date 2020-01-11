package com.jpawithhibernatepractice.jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class CountEmployee {
	public static void main(String[] args) {


		EntityManagerFactory factory = Persistence.createEntityManagerFactory("demo");
		EntityManager manager = factory.createEntityManager();
		String jpql = " select count(ename) from Demo";
		Query qry = manager.createQuery(jpql);
		Object count = qry.getSingleResult();
		System.out.println(count);
		System.out.println("**************************");
	}
}
                                   