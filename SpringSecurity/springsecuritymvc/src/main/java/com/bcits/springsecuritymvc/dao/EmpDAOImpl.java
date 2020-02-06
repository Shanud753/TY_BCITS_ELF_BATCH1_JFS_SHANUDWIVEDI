package com.bcits.springsecuritymvc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.bcits.springsecuritymvc.beans.EmpInfoBean;

@Repository
public class EmpDAOImpl implements EmpDAO {

	@PersistenceUnit
	private EntityManagerFactory factory;
	
	@Override
	public boolean register(EmpInfoBean empInfoBean) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		boolean isRegistered = false;
		try {
			transaction.begin();
			manager.persist(empInfoBean);
			transaction.commit();
			isRegistered = true;
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			manager.close();
		}
 		return isRegistered;
	}//End of register()

	@Override
	public EmpInfoBean getEmployee(int empId) {
	EntityManager manager = factory.createEntityManager();
	 EmpInfoBean infoBean = manager.find(EmpInfoBean.class, empId);
	 manager.close();
 		return infoBean;
	}//End of getEmployee()

	@Override
	public List<EmpInfoBean> getAllEmployee() {
	EntityManager manager = factory.createEntityManager();
	String jpql = "from EmpInfoBean";
	Query query = manager.createQuery(jpql);
	List<EmpInfoBean> empList = query.getResultList();
	manager.close();
 		return empList;
	}//End of getAllEmployee()

}
