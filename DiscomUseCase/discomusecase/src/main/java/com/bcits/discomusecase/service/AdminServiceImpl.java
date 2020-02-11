package com.bcits.discomusecase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcits.discomusecase.beans.AdminInfo;
import com.bcits.discomusecase.beans.EmployeeMaster;
import com.bcits.discomusecase.dao.AdminDao;


@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminDao dao;
	
	@Override
	public AdminInfo authenticate(String username, String password) {
		return dao.authenticate(username, password);
		}

	@Override
	public boolean addEMployee(EmployeeMaster empInfo,String conPassword) {
		if(empInfo != null && empInfo.getPassword().equals(conPassword)) {
			return dao.addEMployee(empInfo);
		}
		return false;
	}

}
