package com.bcits.discomusecase.dao;

import java.util.Date;
import java.util.List;

import com.bcits.discomusecase.beans.ConsumersMaster;
import com.bcits.discomusecase.beans.CurrentBill;
import com.bcits.discomusecase.beans.EmployeeMaster;
import com.bcits.discomusecase.beans.SupportCustBean;

public interface EmployeeDAO {
   
	
	public EmployeeMaster authentication(Integer empId, String designation);
	
	public List<ConsumersMaster> getAllConsumer(String region );
	public int noOfConsumers(String region);
	 public Double getPreviousReading(int rrNumber);
	 public boolean addCurrentBill(CurrentBill currentBill);
	 public List<SupportCustBean> getComplaints(String region);
	 public boolean sendResponse(Integer rrNumber,String response, Date date);

}
