package com.bcits.discomusecase.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bcits.discomusecase.beans.BillHistory;
import com.bcits.discomusecase.beans.BillHistoryPK;
import com.bcits.discomusecase.beans.ConsumersMaster;
import com.bcits.discomusecase.beans.CurrentBill;
import com.bcits.discomusecase.beans.EmployeeMaster;
import com.bcits.discomusecase.beans.MonthlyConsumption;
import com.bcits.discomusecase.beans.MonthlyConsumptionPK;
import com.bcits.discomusecase.beans.SupportCustBean;
import com.bcits.discomusecase.config.EntityManagerFactoryConfig;
import com.bcits.discomusecase.sendemail.EmailGenerator;

@Repository
public class EmployeeDAOImplementation implements EmployeeDAO {

	@PersistenceUnit
	private EntityManagerFactory factory ;

	@Autowired
	private GenerateBill generateBill;

	private EmailGenerator mail = new EmailGenerator();
	
	@Override
	public EmployeeMaster authentication(Integer empId, String password) {
		EntityManager manager = factory.createEntityManager();
		try {
			EmployeeMaster empMasterInfo = manager.find(EmployeeMaster.class, empId);
			if(empMasterInfo != null  && empMasterInfo.getPassword().equals(password)) {
				return empMasterInfo;
			}else {
				return null;
			}
		
		} catch (Exception e) {
			
			e.printStackTrace();
			return null;
		}
		
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
	public double getPreviousReading(String rrNumber) {
		EntityManager manager = factory.createEntityManager();
		double  previousReading=0.0;
		try {
			String jpql = "select finalReading from CurrentBill where rrNumber=:rrNum order by finalReading DESC";
			Query query = manager.createQuery(jpql);
			query.setMaxResults(1);
			query.setParameter("rrNum", rrNumber);
			previousReading =(double) query.getSingleResult();
			
		}catch (Exception e) {
			return 0.0;
		}

		if(previousReading != 0.0) {
			return previousReading;
		}
		return 0;
	}



	@Override
	public CurrentBill addCurrentBill(CurrentBill currentBill,String region) {

		double units = currentBill.getFinalReading()-currentBill.getInitialReading();
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		MonthlyConsumption monthlyConsumption = new MonthlyConsumption();
		MonthlyConsumptionPK mothlyPk = new MonthlyConsumptionPK();
		CurrentBill bill = manager.find(CurrentBill.class, currentBill.getRrNumber());
		if(bill != null) {
			Calendar cal = Calendar.getInstance();
		  	cal.setTime(new Date());
		  	Calendar cal1 = Calendar.getInstance();
		  	cal1.setTime(bill.getStatementDate());
		  	if(cal.get(Calendar.MONTH) == cal1.get(Calendar.MONTH)) {
		  		return null;
		  	}
		}
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
			monthlyConsumption.setRegion(region);
			mothlyPk.setDate(new Date());
			mothlyPk.setRrNumber(currentBill.getRrNumber());
			monthlyConsumption.setConsumptionPk(mothlyPk);
			currentBill.setBillAmount(amount);
			currentBill.setUnitsConsumed(units);
			currentBill.setRegion(monthlyConsumption.getRegion());
			currentBill.setStatus("Not Paid");
			currentBill.setStatementDate(new Date());
			manager.persist(monthlyConsumption);
			manager.persist(currentBill);
			transaction.commit();
			return currentBill;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}//End of addCurrentBill()

	@Override
	public boolean sendMail(String rrNumber,ConsumersMaster master) {
		EntityManager manager = factory.createEntityManager();
		CurrentBill bill = manager.find(CurrentBill.class, rrNumber);
		
		if(mail.sendMail(bill,master)) {
			return true;
		}
		return false;
	}

	@Override
	public List<SupportCustBean> getComplaints(String region) {
		EntityManager manager = factory.createEntityManager();
		try {
			String jpql =" from SupportCustBean where region = :reg ";
			Query query =manager.createQuery(jpql);
			query.setParameter("reg", region);
			List<SupportCustBean> supportList = query.getResultList();
			if(supportList == null && supportList.isEmpty()) {
				return null;
			}
			return supportList;
		}catch (Exception e) {
			return null;
		}
	}



	@Override
	public boolean sendResponse(String rrNumber, String response, Date date) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			String jpql = " from SupportCustBean where supportBeanCustPK.rrNumber= :rrNum and supportBeanCustPK.date= :date ";
			Query query = manager.createQuery(jpql);
			query.setParameter("rrNum", rrNumber);
			query.setParameter("date", date);

			SupportCustBean supportBean = (SupportCustBean) query.getSingleResult();
			supportBean.setResponse(response);
			transaction.commit();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
		}

		return false;
	}



	@Override
	public List<MonthlyConsumption> getCollectedBill(String region) {
		EntityManager manager = factory.createEntityManager();
		try {
			String jpql=" from MonthlyConsumption where region = :reg";
			Query query =manager.createQuery(jpql);
			query.setParameter("reg", region);
			List<MonthlyConsumption> billList = query.getResultList();
			return billList;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}



	@Override
	public List<BillHistory> getBillList(String region) {
		EntityManager manager = factory.createEntityManager();
		try {
			String jpql=" from BillHistory where region = :reg";
			Query query =manager.createQuery(jpql);
			query.setParameter("reg", region);
			List<BillHistory> billList = query.getResultList();
			return billList;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}



	@Override
	public boolean removeConsumer(String rrNumber) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			ConsumersMaster consumersMaster = manager.find(ConsumersMaster.class, rrNumber);
			transaction.begin();
			manager.remove(consumersMaster);
			transaction.commit();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}//End of remove()



	@Override
	public List<MonthlyConsumption> getCollectedBill() {
		EntityManager manager = factory.createEntityManager();
		try {
			String jpql=" from MonthlyConsumption ";
			Query query =manager.createQuery(jpql);
			List<MonthlyConsumption> billList = query.getResultList();
			return billList;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}



	@Override
	public boolean clearDueAmount(String rrNumber, Date date) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		String jpql = " from MonthlyConsumption where consumptionPk.rrNumber=:rrNum and consumptionPk.date= :date1 ";
		Query query = manager.createQuery(jpql);
		query.setParameter("rrNum", rrNumber);
		query.setParameter("date1", date);
		MonthlyConsumption monthlyConsumption = (MonthlyConsumption) query.getSingleResult();
		
		CurrentBill currentBill = manager.find(CurrentBill.class,rrNumber);
		BillHistory bill = new BillHistory();
        BillHistoryPK billPk = new BillHistoryPK();
        if(monthlyConsumption != null) {
        	transaction.begin();
        	monthlyConsumption.setStatus("paid");
        	currentBill.setStatus("paid");
        	bill.setBillAmount(monthlyConsumption.getBillAmount());
        	bill.setRegion(monthlyConsumption.getRegion());
        	bill.setStatus("Success");
        	billPk.setPayDate(new Date());
        	billPk.setRrNumber(rrNumber);
        	bill.setBillHistoryPk(billPk);
        	manager.persist(bill);
        	transaction.commit();
        	return true;
        }
  
		return false;
	}//End of clearDueAmount()



	@Override
	public List<Object[]> monthlyCollectedBills(String region) {
		EntityManager manager = factory.createEntityManager();
		try {
			String jpql =" select sum(billAmount) , Date_FORMAT(consumptionPk.date,'%Y-%m') from MonthlyConsumption"
					+ "  where region=:reg and status = 'paid' GROUP BY MONTH(consumptionPk.date) ";
			Query query = manager.createQuery(jpql);
			query.setParameter("reg", region);
			List<Object[]> collectedBillsRevenue = query.getResultList();
			Object bill1[] = collectedBillsRevenue.get(0);
			System.out.println(bill1[0]);
			System.out.println(bill1[1]);
			return collectedBillsRevenue;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			manager.close();
		}			
	}



	@Override
	public List<Object[]> monthlyPendingBills(String region) {
		EntityManager manager = factory.createEntityManager();
		try {
			String jpql =" select sum(billAmount) , Date_FORMAT(consumptionPk.date,'%Y-%m') from MonthlyConsumption"
					+ "  where region=:reg and status = 'Not Paid' GROUP BY MONTH(consumptionPk.date) ";
			Query query = manager.createQuery(jpql);
			query.setParameter("reg", region);
			
			List<Object[]> monthlyBillsPending = query.getResultList();
			Object bill2[] = monthlyBillsPending.get(0);
			System.out.println(bill2[0]);
			System.out.println(bill2[1]);
			return monthlyBillsPending;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			manager.close();
		}			
	}





	
}//End of Class
