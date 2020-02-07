package com.bcits.discomusecase.dao;

import javax.persistence.Query;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import com.bcits.discomusecase.beans.TarrifMaster;

@Repository
public class GenerateBill {

	@PersistenceUnit
	private EntityManagerFactory factory ;
	
	public double billCalculator(double unit, String typeOfConsumer) {
		EntityManager manager = factory.createEntityManager();
		String jpql = " from TarrifMaster where type= :typeOfCons ";
		Query query = manager.createQuery(jpql);
		query.setParameter("typeOfCons", typeOfConsumer);
		List<TarrifMaster> tariffList = query.getResultList();

		long initRange = tariffList.get(0).getTarrifMasterPk().getRange();
		long midRange = tariffList.get(1).getTarrifMasterPk().getRange();
		long finalRange = tariffList.get(2).getTarrifMasterPk().getRange();

		double initAmount = tariffList.get(0).getAmount();
		double midAmount = tariffList.get(1).getAmount();
		double finalAmount = tariffList.get(2).getAmount();

		double bill = 0.0;

		if (unit < initRange) {
			bill = unit * initAmount;
		}else if(unit < midRange) {
			bill = ( initRange * initAmount) +((unit -initRange) * midAmount);
		}else if (unit > finalRange) {
			bill = (initRange * initAmount) +((midRange-initRange) * midAmount) +((unit - midRange) * finalAmount);
		}
		return bill;
	}
}
