package com.bcits.springmvc.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
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
	
	/*
	 * @PersistenceContext private EntityManager manager;
	 */
	
	@Override
	public boolean addEmployee(EmployeeInfoBean bean) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
//		EmployeeInfoBean employeeInfoBean = new EmployeeInfoBean();
		boolean isAdded = false;
		try {
			transaction.begin();
			manager.persist(bean);
			transaction.commit();
			isAdded = true;
			return isAdded;
		}catch(Exception e) {
			e.printStackTrace();
			return isAdded;
		}
		
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
	EntityManager manager = factory.createEntityManager();
	EntityTransaction transaction = manager.getTransaction();
	
	Integer empId = bean.getEmpId();
	String name = bean.getEname();
	Long number = bean.getMobileNo();
	String mail= bean.getOfficialMailid();
	Date dob = bean.getDob();
	Date doj = bean.getDoj();
	String designation = bean.getDesignation();
	String bldGrp = bean.getBldGrp();
	Double salary = bean.getSalary();
	Integer dptId = bean.getDepId();
	Integer mgrId = bean.getMrgId();
	String password = bean.getPassword();
	
	EmployeeInfoBean infoBean = manager.find(EmployeeInfoBean.class, empId);
	Boolean isUpdate = false;
	if(infoBean != null) {
		transaction.begin();
		if(name != null && !name.isEmpty()) {
			infoBean.setEname(name);
		}
		if(number != null) {
			infoBean.setMobileNo(number);
		}
		if(mail != null && !mail.isEmpty()) {
			infoBean.setOfficialMailid(mail);
		}
		if(dob != null) {
			infoBean.setDob(dob);
		}
		if(doj != null) {
			infoBean.setDoj(doj);
		}
		if(designation != null && !designation.isEmpty()) {
			infoBean.setDesignation(designation);
		}
		if(bldGrp != null && !bldGrp.isEmpty()) {
			infoBean.setBldGrp(bldGrp);
		}
        if(salary != null && salary>1) {
        	infoBean.setSalary(salary);
        }
        if(mgrId != null && mgrId>1) {
        	infoBean.setMrgId(mgrId);
        }
        if(password != null && !password.isEmpty()) {
        	 infoBean.setPassword(password);
        }
       
		transaction.commit();
		isUpdate = true;
	}
	    manager.close();
		return isUpdate;
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
