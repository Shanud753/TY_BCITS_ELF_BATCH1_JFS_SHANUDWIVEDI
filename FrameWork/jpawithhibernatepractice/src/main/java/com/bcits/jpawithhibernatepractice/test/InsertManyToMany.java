package com.bcits.jpawithhibernatepractice.test;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bcits.jpawithhibernatepractice.bean.EmployeePrimaryInfo;
import com.bcits.jpawithhibernatepractice.manytomany.ProjectInfo;

public class InsertManyToMany {
	public static void main(String[] args) {
		
	
	EntityTransaction transaction = null;  
	EntityManager manager = null;
	
	ProjectInfo projectInfo1 = new ProjectInfo();
	projectInfo1.setPid(2);
	projectInfo1.setProjectName("HM");
	projectInfo1.setTechnology("python");
	projectInfo1.setStartDate(java.sql.Date.valueOf("2019-08-12"));
	projectInfo1.setEndDate(java.sql.Date.valueOf("2020-01-22"));
	projectInfo1.setLocation("mumbai");
	
	ProjectInfo projectInfo2 = new ProjectInfo();
	projectInfo2.setPid(3);
	projectInfo2.setProjectName("Banking");
	projectInfo2.setTechnology("C#");
	projectInfo2.setStartDate(java.sql.Date.valueOf("2017-08-12"));
	projectInfo2.setEndDate(java.sql.Date.valueOf("2019-01-22"));
	projectInfo2.setLocation("bangalore");
	
	ProjectInfo projectInfo = new ProjectInfo();
	projectInfo.setPid(4);
	projectInfo.setProjectName("ems");
	projectInfo.setTechnology("java");
	projectInfo.setStartDate(java.sql.Date.valueOf("2018-08-12"));
	projectInfo.setEndDate(java.sql.Date.valueOf("2020-01-22"));
	projectInfo.setLocation("pune");
	
	
	
	
	EmployeePrimaryInfo demo = new EmployeePrimaryInfo();
	demo.setEid(20);
	demo.setEname("saveena");
	demo.setMobile_no(9086543251l);
	demo.setOfficialMailid("saveena@gmail.com");
	demo.setDob(java.sql.Date.valueOf("1993-11-12"));
	demo.setDoj(java.sql.Date.valueOf("2015-09-22"));
	demo.setDesignation("Tester");
	demo.setBldGrp("B+");
	demo.setSalary(90000.0);
	demo.setDepId(20);
	demo.setMrgId(106);
	
//	EmployeePrimaryInfo demo2 = new EmployeePrimaryInfo();
//	demo2.setEid(19);
//	demo2.setEname("Bhanu");
//	demo2.setMobile_no(9876543251l);
//	demo2.setOfficialMailid("bhanu@gmail.com");
//	demo2.setDob(java.sql.Date.valueOf("1995-12-02"));
//	demo2.setDoj(java.sql.Date.valueOf("2014-08-13"));
//	demo2.setDesignation("Software Developer");
//	demo2.setBldGrp("b+");
//	demo2.setSalary(90000.0);
//	demo2.setDepId(20);
//	demo2.setMrgId(107);
//	
	ArrayList<ProjectInfo> al =new ArrayList<ProjectInfo>();
	al.add(projectInfo);
	al.add(projectInfo1);
	al.add(projectInfo2);
//	demo.set(al);

	
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
