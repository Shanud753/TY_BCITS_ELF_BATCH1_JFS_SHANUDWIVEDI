package com.bcits.discomusecase.servlets;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bcits.discomusecase.beans.EmployeeMaster;



public class EmployeeLogin  {
  public static void main(String[] args) {
	  EntityTransaction transaction = null;  
		EntityManager manager = null;
		EmployeeMaster employeeMaster = new EmployeeMaster();
		
		employeeMaster.setEmpId(1);
		employeeMaster.setDesignation("Manager");
		employeeMaster.setEmpName("Nagesh S");
		employeeMaster.setRegion("Bangalore South");
		

		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("discomPersistenceUnit");
			manager = entityManagerFactory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(employeeMaster);
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
