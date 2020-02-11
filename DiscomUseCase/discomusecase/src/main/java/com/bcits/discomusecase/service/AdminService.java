package com.bcits.discomusecase.service;

import com.bcits.discomusecase.beans.AdminInfo;
import com.bcits.discomusecase.beans.EmployeeMaster;


public interface AdminService {
	public AdminInfo authenticate(String username, String password);
	public boolean addEMployee(EmployeeMaster empInfo,String conPassword);

}
