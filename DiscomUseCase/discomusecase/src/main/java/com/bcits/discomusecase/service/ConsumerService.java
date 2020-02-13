package com.bcits.discomusecase.service;

import java.util.Date;
import java.util.List;import org.springframework.ui.ModelMap;

import com.bcits.discomusecase.beans.BillHistory;
import com.bcits.discomusecase.beans.ConsumersMaster;
import com.bcits.discomusecase.beans.CurrentBill;
import com.bcits.discomusecase.beans.MonthlyConsumption;
import com.bcits.discomusecase.beans.SupportCustBean;

public interface ConsumerService {
	public ConsumersMaster authenticate(String email, String password);
	
	public ConsumersMaster getConsumer(String rrNumber);
	
	public boolean addConsumer(ConsumersMaster consumersMaster);
	
	public boolean deleteConsumer(String rrNumber);
	
	public List<ConsumersMaster> getAllConsumers();
	
	public boolean updateConsumer(ConsumersMaster bean);
	
	public List<CurrentBill>  currentBillGeneration(CurrentBill billDetails);
	
	public boolean addCurrentBillDetails(CurrentBill billInfo);
	
	public List<MonthlyConsumption> getConsumption(String rrNumber);
	
	public CurrentBill currentBillDetails(String rrNumber);
	
	public boolean billPayment(String rrNumber, Date date, double amount);
	
	public boolean changePassword(String password, String confPassword,String rrNumber);
	
	public List<BillHistory> getBillHistory(String rrNumber);
	public CurrentBill getBillAmount(String rrNumber);
	public boolean setSupportRequest(String supportMsg,String rrNumber,String region);
	 public List<SupportCustBean> getResponse(String rrNumber);
	 
	   public boolean forgotPassword(ConsumersMaster consumersMasterBean, String confPassword);
		public boolean authenticationForgotPassword(ConsumersMaster consumersMaster);
}
