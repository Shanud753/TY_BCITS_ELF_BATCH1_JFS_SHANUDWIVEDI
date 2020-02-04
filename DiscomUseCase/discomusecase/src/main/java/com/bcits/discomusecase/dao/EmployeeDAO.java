package com.bcits.discomusecase.dao;

import java.util.List;

import com.bcits.discomusecase.beans.ConsumersMaster;
import com.bcits.discomusecase.beans.EmployeeMaster;

public interface EmployeeDAO {
   
	
	public EmployeeMaster authentication(Integer empId, String designation);
	
	public List<ConsumersMaster> getAllConsumer(String region );
	public int noOfConsumers(String region);
	 public Double getPreviousReading(int rrNumber);

}
