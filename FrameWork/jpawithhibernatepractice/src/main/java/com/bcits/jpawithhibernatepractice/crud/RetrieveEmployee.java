package com.bcits.jpawithhibernatepractice.crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.bcits.jpawithhibernatepractice.bean.EmployeePrimaryInfo;

public class RetrieveEmployee {
	public static void main(String[] args) {
      
		
		
		EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("demo");
		EntityManager manager = managerFactory.createEntityManager();
	    EmployeePrimaryInfo  info	= manager.find(EmployeePrimaryInfo.class, 3);
	    System.out.println(info.getEid());
	    System.out.println(info.getDepId());
	    System.out.println(info.getEname());
	    System.out.println(info.getMobile_no());
	    System.out.println(info.getBldGrp());
	    System.out.println(info.getDesignation());
	    System.out.println(info.getMrgId());
	    System.out.println(info.getOfficialMailid());
	    System.out.println(info.getSalary());
	    System.out.println(info.getDob());
	    System.out.println(info.getDoj());
		
		
		manager.close();
	}//End of Main
}//End of Class
