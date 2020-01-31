package com.bcits.discomusecase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcits.discomusecase.beans.ConsumersMaster;
import com.bcits.discomusecase.dao.ConsumerDAO;

@Service
public class ConsumerServiceImpl implements ConsumerService{

	@Autowired
	private ConsumerDAO dao;
	
	@Override
	public ConsumersMaster authenticate(int empId, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addConsumer(ConsumersMaster consumersMaster) {
//		if(!consumersMaster.getPassword().equals(consumersMaster.getConfirmPassword())) {
//			return false;
//		}
		return dao.addConsumer(consumersMaster);
	}

}//
