package com.bcits.discomusecase.service;

import java.util.Date;
import java.util.List;import org.springframework.ui.ModelMap;

import com.bcits.discomusecase.beans.BillHistory;
import com.bcits.discomusecase.beans.ConsumersMaster;
import com.bcits.discomusecase.beans.CurrentBill;
import com.bcits.discomusecase.beans.MonthlyConsumption;

public interface ConsumerService {
	public ConsumersMaster authenticate(int rrNumber,String password);
	
	public ConsumersMaster getConsumer(int rrNumber);
	
	public boolean addConsumer(ConsumersMaster consumersMaster);
	
	public boolean deleteConsumer(int rrNumber);
	
	public List<ConsumersMaster> getAllConsumers();
	
	public boolean updateConsumer(ConsumersMaster bean);
	
	public List<CurrentBill>  currentBillGeneration(CurrentBill billDetails);
	
	public boolean addCurrentBillDetails(CurrentBill billInfo);
	
	public MonthlyConsumption getConsumption(int rrNumber);
	
	public CurrentBill currentBillDetails(int rrNumber);
	
	public boolean billPayment(int rrNumber, Date date, Double amount);
	
	public List<BillHistory> getBillHistory(int rrNumber);
	public CurrentBill getBillAmount(int meterNumber);
	

}
