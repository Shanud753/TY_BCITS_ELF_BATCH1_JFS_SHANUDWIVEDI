package com.bcits.springmvc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import com.bcits.springmvc.beans.EmployeeInfoBean;

import net.bytebuddy.asm.Advice.ArgumentHandler.Factory;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDao {

	@PersistenceUnit
	private EntityManagerFactory factory ;
	
	@Override
	public boolean addEmployee(EmployeeInfoBean bean) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		EmployeeInfoBean employeeInfoBean = new EmployeeInfoBean();
		boolean isAdded = false;
		try {
			transaction.begin();
			manager.persist(employeeInfoBean);
			transaction.commit();
			isAdded = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return isAdded;
	}

	@Override
	public boolean deleteEmployee(int empId) {
		boolean isDeleted = false;
		
		EntityManager manager = factory.createEntityManager();
		EmployeeInfoBean infoBean = manager.find(EmployeeInfoBean.class, empId);
		if(infoBean != null) {
				EntityTransaction transaction = manager.getTransaction();
				transaction.begin();
				manager.remove(infoBean);
				transaction.commit();
				isDeleted = true;
		}
		manager.close();
		
		return isDeleted;
	}

	@Override
	public EmployeeInfoBean getEmployee(int empId) {
		EntityManager manager = factory.createEntityManager();
		EmployeeInfoBean infoBean = manager.find(EmployeeInfoBean.class, empId);
		return infoBean;
	}

	@Override
	public List<EmployeeInfoBean> getAllEmployees() {
		
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createQuery(" from EmployeeInfoBean ");
		List<EmployeeInfoBean> info = query.getResultList();
		return info;
	}

	@Override
	public boolean updateEmployee(EmployeeInfoBean bean) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public EmployeeInfoBean authenticate(int empId, String password) {
		EntityManager manager = factory.createEntityManager();
		EmployeeInfoBean employeeInfoBean = manager.find(EmployeeInfoBean.class, empId);
		if(employeeInfoBean != null && employeeInfoBean.getPassword().equals(password)) {
			return employeeInfoBean;
		}else {
			return null;
		}
		
	}//End of authenticate()

	
}//End of class
