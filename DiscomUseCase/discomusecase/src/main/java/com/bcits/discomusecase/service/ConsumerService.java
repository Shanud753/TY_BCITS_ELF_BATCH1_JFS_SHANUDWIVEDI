package com.bcits.discomusecase.service;

import org.springframework.stereotype.Service;

import com.bcits.discomusecase.beans.ConsumersMaster;


public interface ConsumerService {
	public ConsumersMaster authenticate(int empId,String password);
	public boolean addConsumer(ConsumersMaster consumersMaster);
//	public boolean deleteEmployee(int empId);
}
