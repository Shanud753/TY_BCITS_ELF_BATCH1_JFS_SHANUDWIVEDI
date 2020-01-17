package com.bcits.jpawithhibernatepractice.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bcits.jpawithhibernatepractice.bean.EmployeePrimaryInfo;
import com.bcits.jpawithhibernatepractice.onetoone.EmployeeBankInfo;

public class InsertOneToOneBank {
	public static void main(String[] args) {

		EntityTransaction transaction = null;  
		EntityManager manager = null;
		EmployeePrimaryInfo priInfo = new EmployeePrimaryInfo();
		EmployeeBankInfo bank = new EmployeeBankInfo();
		
		priInfo.setEid(21);
		priInfo.setEname("Manish");
		priInfo.setMobile_no(9876543251l);
		priInfo.setOfficialMailid("manish1@gmail.com");
		priInfo.setDob(java.sql.Date.valueOf("1996-12-14"));
		priInfo.setDoj(java.sql.Date.valueOf("2017-10-24"));
		priInfo.setDesignation("manager");
		priInfo.setBldGrp("b+");
		priInfo.setSalary(50000.0);
		priInfo.setDepId(40);
		priInfo.setMrgId(103);
		
		bank.setAccountNo(67543218l);
		bank.setBankName("ICICI");
		bank.setBranchName("Vidya Ranaya pura");
		bank.setIfscCode("ICICI8765");
		bank.setPrimaryInfo(priInfo);
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("demo");
			manager = entityManagerFactory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
         	manager.persist(bank);
			System.out.println("Record Saved");
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}finally {
			manager.close();
		}
		
	}//End of Main
}//End of Class
