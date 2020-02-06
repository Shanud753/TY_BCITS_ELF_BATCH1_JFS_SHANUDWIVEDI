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
	
	public double billCalculator(double units, String typeOfConsumer) {
	
		EntityManager manager = factory.createEntityManager();
		String jpql = " from TarrifMaster where type= :typeOfCons ";
		Query query = manager.createQuery(jpql);
		query.setParameter("typeOfCons", typeOfConsumer);
		List<TarrifMaster> tarrifList = query.getResultList();
		
		long initialRange = tarrifList.get(0).getTarrifMasterPk().getRange();
		long middleRange = tarrifList.get(1).getTarrifMasterPk().getRange();
		long finalRange = tarrifList.get(2).getTarrifMasterPk().getRange();
		
		double initialAmount =  tarrifList.get(0).getAmount();
		double middleAmount =  tarrifList.get(1).getAmount();
		double finalAmount =  tarrifList.get(2).getAmount();
		System.out.println(initialRange + " " + middleRange + " " + finalRange);
		System.out.println(initialAmount + " " + middleAmount + " " + finalAmount);

		
		
		double billAmount = 0.0;
		if(units < initialRange) {
			billAmount = units * initialAmount;
			
		}else if(units < middleRange){
			billAmount = (initialRange * initialAmount) + (units - initialRange * middleAmount);
			
		}else if(units > finalRange) {
			billAmount = (initialRange * initialAmount) + (initialRange * middleAmount) + ((units - middleRange)*finalAmount);
			
		}
		System.out.println(billAmount);
		return billAmount;
		
	}	
}
