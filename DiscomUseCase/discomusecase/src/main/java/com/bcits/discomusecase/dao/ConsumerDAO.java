package com.bcits.discomusecase.dao;

import java.util.Date;
import java.util.List;

import com.bcits.discomusecase.beans.BillHistory;
import com.bcits.discomusecase.beans.ConsumersMaster;
import com.bcits.discomusecase.beans.CurrentBill;
import com.bcits.discomusecase.beans.MonthlyConsumption;
import com.bcits.discomusecase.beans.SupportCustBean;

public interface ConsumerDAO {
	public ConsumersMaster authenticate(String email, String password);
	
	public ConsumersMaster getConsumer(int rrNumber);
	
	public boolean addConsumer(ConsumersMaster consumersMaster);
	
	public boolean deleteConsumer(int rrNumber);
	public List<ConsumersMaster> getAllConsumers();
	public boolean updateConsumer(ConsumersMaster bean);
	public List<CurrentBill>  currentBillGeneration(CurrentBill billDetails);
	public boolean addCurrentBillDetails(CurrentBill billInfo);
	public List<MonthlyConsumption> getConsumption(int rrNumber);
	public CurrentBill currentBillDetails(int rrNumber);
	public boolean billPayment(int rrNumber, Date date, double amount);
	public List<BillHistory> getBillHistory(int rrNumber);
	public CurrentBill getBillAmount(int meterNumber);
	public boolean setSupportRequest(String supportMsg,Integer rrNumber,String region);
	 public List<SupportCustBean> getResponse(Integer rrNumber);


	
}
