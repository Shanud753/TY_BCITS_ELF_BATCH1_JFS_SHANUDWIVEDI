package com.bcits.discomusecase.dao;

import com.bcits.discomusecase.beans.ConsumersMaster;

public interface ConsumerDAO {
	public ConsumersMaster authenticate(int empId,String password);
	public boolean addConsumer(ConsumersMaster consumersMaster);
}
