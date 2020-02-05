package com.bcits.discomusecase.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import com.bcits.discomusecase.beans.EmployeeMaster;
@Repository
public class AdminDaoImpl implements AdminDao{
	
	@PersistenceUnit
	private EntityManagerFactory factory ;
	
	@Override
	public boolean registerEmployee(int empId) {
		
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		EmployeeMaster employee = new EmployeeMaster();
		employee.setEmpId(121);
		employee.setDesignation("Manager");
		employee.setEmpName("Mr Rajesh S");
		employee.setRegion("Bangalore North");
		employee.setPassword("north");
		
		EmployeeMaster employee1 = new EmployeeMaster();
		employee1.setEmpId(122);
		employee1.setDesignation("Manager");
		employee1.setEmpName("Mr Nagesh S");
		employee1.setRegion("Bangalore South");
		employee1.setPassword("south");
		
		List<EmployeeMaster> employeeList = new ArrayList<>();
		employeeList.add(employee);
		employeeList.add(employee1);
		boolean isAdded = true;
		try {
			transaction.begin();
			manager.persist(employeeList);
			transaction.commit();
			isAdded = true;
			return isAdded;
		}catch(Exception e) {
			e.printStackTrace();
			transaction.rollback();	
		}
		
		return false;
	}

}
