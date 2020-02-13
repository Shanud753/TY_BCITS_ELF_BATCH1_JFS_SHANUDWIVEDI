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
		public double getPreviousReading(String rrNumber) {
			
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
		public boolean sendResponse(String rrNumber, String response, Date date) {
		
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
		public boolean removeConsumer(String rrNumber) {
			
			return dao.removeConsumer(rrNumber);
		}

		@Override
		public boolean sendMail(String rrNumber,ConsumersMaster master) {
			
			return dao.sendMail(rrNumber,master);
		}

		@Override
		public List<MonthlyConsumption> getCollectedBill() {
		return dao.getCollectedBill();
		}

		@Override
		public boolean clearDueAmount(String rrNumber, Date date) {
			
			return dao.clearDueAmount(rrNumber, date);
		}

		@Override
		public List<Object[]> monthlyCollectedBills(String region) {
			
			return dao.monthlyCollectedBills(region);
		}

		@Override
		public List<Object[]> monthlyPendingBills(String region) {
			
			return dao.monthlyPendingBills(region);
		}

			
		
}
		

		

