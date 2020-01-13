package com.bcits.jpawithhibernatepractice.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bcits.jpawithhibernatepractice.bean.EmployeePrimaryInfo;
import com.bcits.jpawithhibernatepractice.onetoone.EmployeeSecondaryInfo;

public class InsertOneToOne {
	public static void main( String[] args )
	{
		EntityTransaction transaction = null;  
		EntityManager manager = null;
		EmployeePrimaryInfo demo = new EmployeePrimaryInfo();
//		demo.setEid(11);
//		demo.setEname("Manish");
//		demo.setMobile_no(9876543251l);
//		demo.setOfficialMailid("manish1@gmail.com");
//		demo.setDob(java.sql.Date.valueOf("1996-12-14"));
//		demo.setDoj(java.sql.Date.valueOf("2017-10-24"));
//		demo.setDesignation("manager");
//		demo.setBldGrp("b+");
//		demo.setSalary(50000.0);
//		demo.setDepId(40);
//		demo.setMrgId(103);
		
		EmployeeSecondaryInfo demo1 = new EmployeeSecondaryInfo();
		
		demo1.setPersonalMailId("manish12@gmail.com");
		demo1.setGender("Male");
		demo1.setAge(26);
		demo1.setNationality("Indian");
		demo1.setIsMarried("No");
		demo1.setGovtId("Pan Card");
		demo1.setGurdianName("Mamta");
		demo1.setGurdianContactNo(9876543234l);
		demo1.setJobLocation("Mumbai");
		demo1.setPrimaryInfo(demo);
//		demo.setSecondaryInfo(demo1);

		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("demo");
			manager = entityManagerFactory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
//			manager.persist(demo);
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