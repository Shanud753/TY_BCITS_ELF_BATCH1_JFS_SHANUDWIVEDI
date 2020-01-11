package com.bcits.jpawithhibernatepractice.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bcits.jpawithhibernatepractice.bean.EmployeePrimaryInfo;

public class FindEmployee {
	public static void main(String[] args) {
		    
			
			
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("demo");
			EntityManager manager = entityManagerFactory.createEntityManager();
			EmployeePrimaryInfo info = manager.getReference(EmployeePrimaryInfo.class, 6);
			//Demo info = manager.find(Demo.class, 6);
			System.out.println(info.getClass());
//		    System.out.println(info.getEid());
//		    System.out.println(info.getDepId());
//		    System.out.println(info.getEname());
//		    System.out.println(info.getMobile_no());
//		    System.out.println(info.getBld_grp());
//		    System.out.println(info.getDesignation());
//		    System.out.println(info.getMrgId());
//		    System.out.println(info.getOfficial_mailid());
//		    System.out.println(info.getSalary());
//		    System.out.println(info.getDob());
//		    System.out.println(info.getDoj());
		    System.out.println("**********************************");
		    manager.close();
		}
	}
