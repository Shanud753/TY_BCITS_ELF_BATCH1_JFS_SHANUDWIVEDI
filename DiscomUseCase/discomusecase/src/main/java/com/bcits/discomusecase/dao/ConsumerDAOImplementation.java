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
import com.bcits.discomusecase.beans.SupportCustBean;
import com.bcits.discomusecase.beans.SupportCustBeanPK;

@Repository
public class ConsumerDAOImplementation implements ConsumerDAO {

	@PersistenceUnit
	private EntityManagerFactory factory;

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
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			return false;
		}

	}

	@Override
	public ConsumersMaster authenticate(String email, String password) {
		EntityManager manager = factory.createEntityManager();
		Query query = manager.createQuery(" from ConsumersMaster where email= :email ");
		query.setParameter("email", email);
		ConsumersMaster conInfoBean = (ConsumersMaster) query.getSingleResult();
		if (conInfoBean != null && conInfoBean.getPassword().equals(password)) {
			return conInfoBean;
		}
		manager.close();
		return null;
	}

	@Override
	public ConsumersMaster getConsumer(String rrNumber) {
		EntityManager manager = factory.createEntityManager();
		ConsumersMaster consumerMaster = manager.find(ConsumersMaster.class, rrNumber);
		return consumerMaster;
	}

	@Override
	public boolean deleteConsumer(String rrNumber) {
		boolean isDeleted = false;

		EntityManager manager = factory.createEntityManager();
		ConsumersMaster consumerBean = manager.find(ConsumersMaster.class, rrNumber);
		if (consumerBean != null) {
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
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		return isAdded;
	}

	@Override
	public List<MonthlyConsumption> getConsumption(String rrNumber) {
		EntityManager manager = factory.createEntityManager();
		try {
			String jpql = " from MonthlyConsumption where consumptionPk.rrNumber= :rrNum";
			Query query = manager.createQuery(jpql);
			query.setParameter("rrNum", rrNumber);
			List<MonthlyConsumption> consumptionList = (List<MonthlyConsumption>) query.getResultList();
			if (consumptionList != null) {
				return consumptionList;
			} else {
				return null;
			}
		} catch (Exception e) {
			return null;

		} finally {
			manager.close();
		}
	}

	@Override
	public CurrentBill currentBillDetails(String rrNumber) {
		EntityManager manager = factory.createEntityManager();
		try {
			String jpql = " from CurrentBill where rrNumber= :rrNum";
			Query query = manager.createQuery(jpql);
			query.setParameter("rrNum", rrNumber);
			CurrentBill billInfo = (CurrentBill) query.getSingleResult();
			return billInfo;

		} catch (Exception e) {
			return null;
		} finally {
			manager.close();
		}
	}

	@Override
	public boolean billPayment(String rrNumber, Date date, double amount) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		String jpql = " from MonthlyConsumption where consumptionPk.rrNumber= :rrNum ";
		Query query = manager.createQuery(jpql);
		query.setMaxResults(1);
		query.setParameter("rrNum", rrNumber);
		MonthlyConsumption monthlyConsumption = (MonthlyConsumption) query.getSingleResult();
        CurrentBill currentBill =  manager.find(CurrentBill.class, rrNumber);
        
		BillHistory bill = new BillHistory();
		BillHistoryPK billPk = new BillHistoryPK();
		
		
		bill.setBillAmount(amount);
		bill.setStatus("Success");
		bill.setRegion(monthlyConsumption.getRegion());
		billPk.setPayDate(date);
		billPk.setRrNumber(rrNumber);
		bill.setBillHistoryPk(billPk);
		if (billPk != null) {
			transaction.begin();
			monthlyConsumption.setStatus("paid");
			currentBill.setStatus("paid");
			manager.persist(bill);
			transaction.commit();
			return true;
		}

		return false;
	}

	@Override
	public List<BillHistory> getBillHistory(String rrNumber) {
		EntityManager manager = factory.createEntityManager();
		try {
			Query query = manager.createQuery(" from BillHistory where billHistoryPk.rrNumber= :rrNum ");
			query.setParameter("rrNum", rrNumber);
			List<BillHistory> billList = query.getResultList();
			if (billList != null) {
				return billList;
			} else {
				return null;
			}

		} catch (Exception e) {

			e.printStackTrace();
			return null;
		} finally {
			manager.close();
		}
	}

	@Override
	public CurrentBill getBillAmount(String rrNumber) {
		EntityManager manager = factory.createEntityManager();
		CurrentBill currentBill = manager.find(CurrentBill.class, rrNumber);
		if (currentBill != null) {
			return currentBill;
		} else {
			return null;
		}

	}// end of getBillAmount()

	@Override
	public boolean setSupportRequest(String supportMsg, String rrNumber, String region) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		SupportCustBean supportBean = new SupportCustBean();
		SupportCustBeanPK supportCustBeanPK = new SupportCustBeanPK();
		try {
			transaction.begin();
			supportCustBeanPK.setRrNumber(rrNumber);
			supportBean.setRegion(region);
			supportCustBeanPK.setDate(new Date());
			supportBean.setRequest(supportMsg);
			supportBean.setResponse("Not Sent");
			supportBean.setSupportBeanCustPK(supportCustBeanPK);
			manager.persist(supportBean);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public List<SupportCustBean> getResponse(String rrNumber) {
		EntityManager manager = factory.createEntityManager();
		try {
			String jpql = " from SupportCustBean where supportBeanCustPK.rrNumber = :rrNum ";
			Query query = manager.createQuery(jpql);
			query.setParameter("rrNum", rrNumber);
			List<SupportCustBean> supportList = query.getResultList();
			if (supportList == null && supportList.isEmpty()) {
				return null;
			}
			return supportList;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public boolean changePassword(String password, String rrNumber) {
		EntityManager manager = factory.createEntityManager();
		ConsumersMaster consumerInfoBean = manager.find(ConsumersMaster.class, rrNumber);
		EntityTransaction transaction = manager.getTransaction();
		if (consumerInfoBean != null) {
			transaction.begin();
			consumerInfoBean.setPassword(password);
			transaction.commit();
			return true;
		}
		return false;
	}

	@Override
	public boolean forgotPassword(ConsumersMaster consumersMaster) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		String rrNumber = consumersMaster.getRrNumber();
		String jpql = "from ConsumersMaster where rrNumber=:rrNum";
		Query query = manager.createQuery(jpql);
		query.setParameter("rrNum", rrNumber);
		ConsumersMaster consumerMaster1 = (ConsumersMaster) query.getSingleResult();
		String password = consumersMaster.getPassword();
		try {
			transaction.begin();
			consumerMaster1.setPassword(password);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			manager.close();
		}
	}

	@Override
	public boolean authenticationForgotPassword(ConsumersMaster consumersMaster) {
		String rrNumber = consumersMaster.getRrNumber();
		String email = consumersMaster.getEmail();
		EntityManager manager = factory.createEntityManager();
		ConsumersMaster master = manager.find(ConsumersMaster.class, rrNumber);
		if (master != null && master.getEmail().equals(email)) {
			return true;
		} else {
			return false;
		}

	}
}
