package com.bcits.jpawithhibernatepractice.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bcits.jpawithhibernatepractice.bean.EmployeePrimaryInfo;
import com.bcits.jpawithhibernatepractice.manytoone.EmployeeAddressInfo;
import com.bcits.jpawithhibernatepractice.manytoone.EmployeeAddressPK;
import com.bcits.jpawithhibernatepractice.manytoone.EmployeeEducationInfo;
import com.bcits.jpawithhibernatepractice.manytoone.EmployeeEducationPK;

public class InsertOneToManyEducation  {
  public static void main(String[] args) {
	   
	   EntityTransaction transaction = null;  
		EntityManager manager = null;
		EmployeePrimaryInfo demo = new EmployeePrimaryInfo();
		demo.setEid(23);
		demo.setEname("Shehnaaz");
		demo.setMobile_no(9826543251l);
		demo.setOfficialMailid("shehnaaz1@gmail.com");
		demo.setDob(java.sql.Date.valueOf("1998-12-14"));
		demo.setDoj(java.sql.Date.valueOf("2018-10-24"));
		demo.setDesignation("HR");
		demo.setBldGrp("b+");
		demo.setSalary(60000.0);
		demo.setDepId(40);
		demo.setMrgId(102);
		
		EmployeeEducationPK educationPK = new EmployeeEducationPK();
		educationPK.setEid(23);
		educationPK.setEducationType("SSLC");
		
		EmployeeEducationInfo educationInfo = new EmployeeEducationInfo();
		educationInfo.setCollegeName("Acharya");
		educationInfo.setPercentage(98);
		educationInfo.setStream("ECE");
		educationInfo.setYop(java.sql.Date.valueOf("2015-12-01"));
        educationInfo.setUniversityName("VTU");
        educationInfo.setPrimaryInfo(demo);

		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("demo");
			manager = entityManagerFactory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(educationInfo);
			transaction.commit();
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
