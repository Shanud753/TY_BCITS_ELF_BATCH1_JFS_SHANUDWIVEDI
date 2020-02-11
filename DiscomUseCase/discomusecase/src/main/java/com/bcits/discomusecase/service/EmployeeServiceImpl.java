package com.bcits.discomusecase.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcits.discomusecase.beans.BillHistory;
import com.bcits.discomusecase.beans.ConsumersMaster;
import com.bcits.discomusecase.beans.CurrentBill;
import com.bcits.discomusecase.beans.EmployeeMaster;
import com.bcits.discomusecase.beans.MonthlyConsumption;
import com.bcits.discomusecase.beans.SupportCustBean;
import com.bcits.discomusecase.dao.EmployeeDAO;
import com.bcits.discomusecase.sendemail.EmailGenerator;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	
		
		@Autowired
		private EmployeeDAO dao;

		
		@Autowired
		private ConsumerService conService;
		
		
		@Override
		public EmployeeMaster authentication(Integer empId, String password) {
			if(empId<1 && password.isEmpty()) {
				return null;
			}
			return dao.authentication(empId, password);
			
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
		public double getPreviousReading(int rrNumber) {
			
			return dao.getPreviousReading(rrNumber);
		}

		@Override
		public CurrentBill addCurrentBill(CurrentBill currentBill,String region) {
			if(currentBill != null ) {
			  return dao.addCurrentBill(currentBill, region);
			}
			return null;
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

		@Override
		public List<MonthlyConsumption> getCollectedBill(String region) {
			if(region != null) {
				return dao.getCollectedBill(region);
			}
			return null;
		}
		

		@Override
		public List<BillHistory> getBillList(String region) {
				if(region != null) {
					return dao.getBillList(region);
				}
				return null;
			
		}

		@Override
		public boolean removeConsumer(int rrNumber) {
			
			return dao.removeConsumer(rrNumber);
		}

		@Override
		public boolean sendMail(int rrNumber) {
			
			return dao.sendMail(rrNumber);
		}

		@Override
		public List<MonthlyConsumption> getCollectedBill() {
		return dao.getCollectedBill();
		}	
		
}
		

		

