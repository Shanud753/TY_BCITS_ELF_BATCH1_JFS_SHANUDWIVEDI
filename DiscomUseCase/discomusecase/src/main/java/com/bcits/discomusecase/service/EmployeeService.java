package com.bcits.discomusecase.service;

import java.util.Date;
import java.util.List;

import com.bcits.discomusecase.beans.ConsumersMaster;
import com.bcits.discomusecase.beans.CurrentBill;
import com.bcits.discomusecase.beans.EmployeeMaster;
import com.bcits.discomusecase.beans.SupportCustBean;
import com.bcits.discomusecase.beans.BillHistory;
import com.bcits.discomusecase.beans.MonthlyConsumption;

public interface EmployeeService {
    
	public EmployeeMaster authentication(Integer empId , String designation);
	
	public List<ConsumersMaster> getAllConsumer(String region );
	public int noOfConsumers(String region);
	 public double getPreviousReading(String rrNumber);
	 public CurrentBill addCurrentBill(CurrentBill currentBill,String region);
	 public List<SupportCustBean> getComplaints(String region);
	 public boolean sendResponse(String rrNumber,String response, Date date);
	 public  List<MonthlyConsumption> getCollectedBill(String region);
	 public List<BillHistory> getBillList(String region);
	 public boolean removeConsumer(String rrNumber);
	 public boolean sendMail(String rrNumber,ConsumersMaster master);
	 public  List<MonthlyConsumption> getCollectedBill();
	 public boolean clearDueAmount(String rrNumber,Date date);
	 public List<Object[]> monthlyCollectedBills(String region);
	 public List<Object[]> monthlyPendingBills(String region);
}
