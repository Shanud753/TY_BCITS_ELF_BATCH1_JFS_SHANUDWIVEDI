package com.bcits.discomusecase.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcits.discomusecase.beans.BillHistory;
import com.bcits.discomusecase.beans.ConsumersMaster;
import com.bcits.discomusecase.beans.CurrentBill;
import com.bcits.discomusecase.beans.MonthlyConsumption;
import com.bcits.discomusecase.beans.SupportCustBean;
import com.bcits.discomusecase.dao.ConsumerDAO;


	@Service
	public class ConsumerServiceImpl implements ConsumerService{

		@Autowired
		private ConsumerDAO dao;

		@Override
		public ConsumersMaster authenticate(String email, String password) {

			return dao.authenticate(email,password);
		}

		@Override
		public boolean addConsumer(ConsumersMaster consumersMaster) {
            if(consumersMaster != null) {
			return dao.addConsumer(consumersMaster);
            }
            return false;
		}

		@Override
		public ConsumersMaster getConsumer(int rrNumber) {

			return dao.getConsumer(rrNumber);
		}


		@Override
		public boolean updateConsumer(ConsumersMaster bean) {
			if(bean != null) {
				return dao.updateConsumer(bean);
			}
			return dao.updateConsumer(bean);
		}



		@Override
		public boolean deleteConsumer(int rrNumber) {

			return dao.deleteConsumer(rrNumber);
		}//End of Delete()


		@Override
		public List<ConsumersMaster> getAllConsumers() {

			return dao.getAllConsumers();
		}

		@Override
		public List<CurrentBill> currentBillGeneration(CurrentBill billDetails) {
			
			return dao.currentBillGeneration(billDetails);
		}

		@Override
		public boolean addCurrentBillDetails(CurrentBill billInfo) {
			
			return dao.addCurrentBillDetails(billInfo);
		}

		@Override
		public List<MonthlyConsumption> getConsumption(int rrNumber) {
			
			return dao.getConsumption(rrNumber);
		}

		@Override
		public CurrentBill currentBillDetails(int rrNumber) {
			
			return dao.currentBillDetails(rrNumber);
		}

		@Override
		public boolean billPayment(int rrNumber, Date date, double amount) {
			
			return dao.billPayment(rrNumber, date, amount);
		}

		@Override
		public List<BillHistory> getBillHistory(int rrNumber) {
			
			return dao.getBillHistory(rrNumber);
		}

		@Override
		public CurrentBill getBillAmount(int rrNumber) {
			
			return dao.getBillAmount(rrNumber);
		}

		@Override
		public boolean setSupportRequest(String supportMsg, Integer rrNumber, String region) {
			
			return dao.setSupportRequest(supportMsg, rrNumber, region);
		}

		@Override
		public List<SupportCustBean> getResponse(Integer rrNumber) {
			
			return dao.getResponse(rrNumber);
		}

		@Override
		public boolean changePassword(String password, String confPassword, int rrNumber) {
				if(!password.equals(confPassword)) {
					return false;
				}
				return dao.changePassword(password,rrNumber); 
			}

		@Override
		public boolean forgotPassword(ConsumersMaster consumersMaster, String confPassword) {
			if(!consumersMaster.getPassword().equals(confPassword)) {
				return false;
			}
			return dao.forgotPassword(consumersMaster);
		}//end of reSetPassword()
		

		@Override
		public boolean authenticationForgotPassword(ConsumersMaster consumersMaster) {
			return dao.authenticationForgotPassword(consumersMaster);
		}//end of authenticationForSetPassword()

		

	

		
		}

