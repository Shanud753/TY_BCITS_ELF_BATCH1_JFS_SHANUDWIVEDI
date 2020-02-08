package com.bcits.discomusecase.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcits.discomusecase.beans.ConsumersMaster;
import com.bcits.discomusecase.beans.CurrentBill;
import com.bcits.discomusecase.beans.EmployeeMaster;
import com.bcits.discomusecase.beans.SupportCustBean;
import com.bcits.discomusecase.dao.EmployeeDAO;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	
		
		@Autowired
		private EmployeeDAO dao;

		@Override
		public EmployeeMaster authentication(Integer empId, String designation) {
			return dao.authentication(empId, designation);
		}

		@Override
		public List<ConsumersMaster> getAllConsumer(String region) {
			return dao.getAllConsumer(region);
		}

		@Override
		public int noOfConsumers(String region) {
			
			return dao.noOfConsumers(region);
		}

		@Override
		public Double getPreviousReading(int rrNumber) {
			
			return dao.getPreviousReading(rrNumber);
		}

		@Override
		public boolean addCurrentBill(CurrentBill currentBill) {
			
			return dao.addCurrentBill(currentBill);
		}

		@Override
		public List<SupportCustBean> getComplaints(String region) {
				if(region != null) {
					return dao.getComplaints(region);
				}
				return null;
			}

		@Override
		public boolean sendResponse(Integer rrNumber, String response, Date date) {
		
			return dao.sendResponse(rrNumber, response, date);
		}
		}

		

