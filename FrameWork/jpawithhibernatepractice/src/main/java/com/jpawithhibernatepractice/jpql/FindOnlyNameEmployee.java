package com.jpawithhibernatepractice.jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.bcits.jpawithhibernatepractice.bean.EmployeePrimaryInfo;

public class FindOnlyNameEmployee {
	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("demo");
		EntityManager manager = factory.createEntityManager();
		String jpql = " select ename from Demo";
		Query qry = manager.createQuery(jpql);
		List<String> list = qry.getResultList();
		for (String demo : list) {
		
			System.out.println(demo);
			System.out.println("************************************************");
		}

	}
}
