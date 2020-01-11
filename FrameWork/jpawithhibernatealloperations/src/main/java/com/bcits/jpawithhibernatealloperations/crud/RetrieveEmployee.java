package com.bcits.jpawithhibernatealloperations.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bcits.jpawithhibernatealloperations.bean.EmployeePrimaryInfo;


public class RetrieveEmployee {
public static void main(String[] args) {
      
		
		
		EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("employeePrimaryInfo");
		EntityManager manager = managerFactory.createEntityManager();
		EmployeePrimaryInfo  info	= manager.find(EmployeePrimaryInfo.class, 7);
	    System.out.println(info.getEid());
	    System.out.println(info.getDepId());
	    System.out.println(info.getEname());
	    System.out.println(info.getMobile_no());
	    System.out.println(info.getBld_grp());
	    System.out.println(info.getDesignation());
	    System.out.println(info.getMrgId());
	    System.out.println(info.getOfficial_mailid());
	    System.out.println(info.getSalary());
	    System.out.println(info.getDob());
	    System.out.println(info.getDoj());
		
		
		manager.close();
}
}