package com.bcits.discomusecase.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bcits.discomusecase.beans.ConsumersMaster;
import com.bcits.discomusecase.beans.CurrentBill;
import com.bcits.discomusecase.beans.EmployeeMaster;
import com.bcits.discomusecase.beans.MonthlyConsumption;
import com.bcits.discomusecase.beans.MonthlyConsumptionPK;
import com.bcits.discomusecase.config.EntityManagerFactoryConfig;

@Repository
public class EmployeeDAOImplementation implements EmployeeDAO {
	
	@PersistenceUnit
	private EntityManagerFactory factory ;

	@Autowired
	private GenerateBill generateBill;
	
	@Override
	public EmployeeMaster authentication(Integer empId, String password) {
		EntityManager manager = factory.createEntityManager();
		EmployeeMaster empMasterInfo = manager.find(EmployeeMaster.class, empId);
		if((empMasterInfo != null && empMasterInfo.getEmpId()== empId)&&
				(empMasterInfo != null && empMasterInfo.getPassword().equals(password))) {
			return empMasterInfo;
		}
		return null;
	}//end of authentication()
		
	

	@Override
	public List<ConsumersMaster> getAllConsumer(String region) {
		EntityManager manager = factory.createEntityManager();
		String jpql = "from ConsumersMaster where region= :regionName";
		Query query = manager.createQuery(jpql);
		query.setParameter("regionName", region);
		List<ConsumersMaster> consumersMasterBean = (List<ConsumersMaster>)query.getResultList();
		if(consumersMasterBean != null) {
			return consumersMasterBean;
		}
		return null;
		 
	}//end of getAllConsumer()



	@Override
	public int noOfConsumers(String region) {
		EntityManager manager = factory.createEntityManager();
		String jpql = "from ConsumersMaster where region= :regionName";
		Query query = manager.createQuery(jpql);
		query.setParameter("regionName", region);
		List<ConsumersMaster> consumersMasterBean = (List<ConsumersMaster>)query.getResultList();
		int i=0;
		if(consumersMasterBean != null) {
			for (ConsumersMaster consumersMaster : consumersMasterBean) {
				i++;
			
			}
			return i;
		}
		return i;
	}



	@Override
	public Double getPreviousReading(int rrNumber) {
		EntityManager manager = factory.createEntityManager();
		String jpql = "select finalReading from CurrentBill where rrNumber=:rrNum order by finalReading DESC";
		Query query = manager.createQuery(jpql);
		query.setMaxResults(1);
		query.setParameter("rrNum", rrNumber);
		 Double  previousReading=null;
		 try {
	      previousReading =(Double) query.getSingleResult();
	      return previousReading;
		 }catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
	}



	@Override
	public boolean addCurrentBill(CurrentBill currentBill) {
		Double units = currentBill.getFinalReading()-currentBill.getInitialReading();
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		MonthlyConsumption monthlyConsumption = new MonthlyConsumption();
		MonthlyConsumptionPK mothlyPk = new MonthlyConsumptionPK();
		CurrentBill bill = manager.find(CurrentBill.class, currentBill.getRrNumber());
		double amount = generateBill.billCalculator(units, currentBill.getTypeOfConsumer());
	
		 try {
			 transaction.begin();
			 if(bill != null) {
				 manager.remove(bill);
			 }
			 monthlyConsumption.setBillAmount(amount);
			 monthlyConsumption.setStatus("Not Paid");
			 monthlyConsumption.setInitialReading(currentBill.getInitialReading());
			 monthlyConsumption.setFinalReading(currentBill.getFinalReading());
			 monthlyConsumption.setUnitsConsumed(units);
			 mothlyPk.setDate(new Date());
			 mothlyPk.setRrNumber(currentBill.getRrNumber());
			 monthlyConsumption.setConsumptionPk(mothlyPk);
			 currentBill.setBillAmount(amount);
			 currentBill.setUnitsConsumed(units);
			 manager.persist(monthlyConsumption);
			 manager.persist(currentBill);
			 transaction.commit();
			 return true;
		 }catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}//End of addCurrentBill()
}//End of Class
