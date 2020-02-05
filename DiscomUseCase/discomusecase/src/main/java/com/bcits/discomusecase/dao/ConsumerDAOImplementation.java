package com.bcits.discomusecase.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.bcits.discomusecase.beans.BillHistory;
import com.bcits.discomusecase.beans.BillHistoryPK;
import com.bcits.discomusecase.beans.ConsumersMaster;
import com.bcits.discomusecase.beans.CurrentBill;
import com.bcits.discomusecase.beans.MonthlyConsumption;

	@Repository
	public class ConsumerDAOImplementation implements ConsumerDAO {

		@PersistenceUnit
		private EntityManagerFactory factory ;
		
		
		@Override
		public boolean addConsumer(ConsumersMaster consumersMaster) {
			EntityManager manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			boolean isAdded = false;
			try {
				transaction.begin();
				manager.persist(consumersMaster);
				transaction.commit();
				isAdded = true;
				return isAdded;
			}catch(Exception e) {
				e.printStackTrace();
				transaction.rollback();	
			}
			return isAdded;
		}


		@Override
		public ConsumersMaster authenticate(int rrNumber,String password) {
			
				EntityManager manager = factory.createEntityManager();
				ConsumersMaster consumerInfoBean = manager.find(ConsumersMaster.class, rrNumber);
				if(consumerInfoBean != null && consumerInfoBean.getPassword().equals(password)) {
					return consumerInfoBean;
				}else {
					return null;
				}
				
			}//End of authenticate()
				 
		@Override
		public ConsumersMaster getConsumer(int rrNumber) {
			 EntityManager manager = factory.createEntityManager();
			  ConsumersMaster consumerMaster = manager.find(ConsumersMaster.class, rrNumber);
			  return consumerMaster;
		}


		@Override
		public boolean deleteConsumer(int rrNumber) {
	     boolean isDeleted = false;
			
			EntityManager manager = factory.createEntityManager();
			ConsumersMaster consumerBean = manager.find(ConsumersMaster.class, rrNumber);
			if(consumerBean != null) {
					EntityTransaction transaction = manager.getTransaction();
					transaction.begin();
					manager.remove(consumerBean);
					transaction.commit();
					isDeleted = true;
			}
			manager.close();
			
			return isDeleted;
		}


		@Override
		public List<ConsumersMaster> getAllConsumers() {
			EntityManager manager = factory.createEntityManager();
			Query query = manager.createQuery(" from ConsumersMaster ");
			List<ConsumersMaster> info = query.getResultList();
			return info;
		}


		@Override
		public boolean updateConsumer(ConsumersMaster bean) {
			// TODO Auto-generated method stub
			return false;
		}


		@Override
		public List<CurrentBill> currentBillGeneration(CurrentBill billDetails) {
			EntityManager manager = factory.createEntityManager();
			Query query = manager.createQuery(" from CurrentBill ");
			List<CurrentBill> infoBill = query.getResultList();
			return infoBill;
		}


		@Override
		public boolean addCurrentBillDetails(CurrentBill billInfo) {
			EntityManager manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			boolean isAdded = false;
			try {
				transaction.begin();
				manager.persist(billInfo);
				transaction.commit();
				isAdded = true;
				return isAdded;
			}catch(Exception e) {
				e.printStackTrace();
				transaction.rollback();	
			}
			return isAdded;
		}


		@Override
		public List<MonthlyConsumption> getConsumption(int rrNumber) {
			EntityManager manager = factory.createEntityManager();
			String jpql = " from MonthlyConsumption where consumptionPk.rrNumber= :rrNum";
			Query query = manager.createQuery(jpql);
			query.setParameter("rrNum", rrNumber);
			List<MonthlyConsumption> consumptionList = (List<MonthlyConsumption>) query.getResultList();
			if(consumptionList != null) {
				return consumptionList;
			}
			manager.close();
			return null;
		}


		@Override
		public CurrentBill currentBillDetails(int rrNumber) {
			EntityManager manager = factory.createEntityManager();
			String jpql = " from CurrentBill where rrNumber= :rrNum";
			Query query = manager.createQuery(jpql);
			query.setParameter("rrNum", rrNumber);
			CurrentBill billInfo = (CurrentBill) query.getSingleResult();
			if(billInfo != null) {
				return billInfo;
			}
			manager.close();
			return null;
		}


		@Override
		public boolean billPayment(int rrNumber, Date date, Double amount) {
			EntityManager manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
//			String jpql = " from MonthlyConsumption where rrNumber= :rrNum order by finalReading DESC ";
//			Query query = manager.createQuery(jpql);
//			query.setMaxResults(1);
//			query.setParameter("rrNum", rrNumber);
//			MonthlyConsumption monthlyConsumption = (MonthlyConsumption) query.getSingleResult();
			
			
            BillHistory bill = new BillHistory();
            BillHistoryPK billPk = new BillHistoryPK();
            bill.setAmount(amount);
            bill.setStatus("Success");
            billPk.setPayDate(date);
            billPk.setRrNumber(rrNumber);
            bill.setBillHistoryPk(billPk);
            if(billPk != null) {
            	transaction.begin();
//            	monthlyConsumption.setStatus("paid");
            	manager.persist(bill);
            	transaction.commit();
            	return true;
            }
            
			return false;
		}


		@Override
		public List<BillHistory> getBillHistory(int rrNumber) {
			EntityManager manager = factory.createEntityManager();
            Query query = manager.createQuery(" from BillHistory where rrNumber= :rrNum");
            query.setParameter("rrNum", rrNumber);
            List<BillHistory> billList = query.getResultList();
            if(billList != null) {
            	return billList;
            }
            manager.close();
			return null;
		}


		@Override
		public CurrentBill getBillAmount(int meterNumber) {
			EntityManager manager = factory.createEntityManager();
			CurrentBill currentBill = manager.find(CurrentBill.class, meterNumber);
			if (currentBill != null) {
				return currentBill;
			}
			manager.close();
			return null;
		}//end of getBillAmount()
			
		
	}
	

