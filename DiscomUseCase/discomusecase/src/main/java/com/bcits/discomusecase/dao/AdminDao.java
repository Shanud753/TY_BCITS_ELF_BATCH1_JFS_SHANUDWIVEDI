package com.bcits.discomusecase.dao;

import com.bcits.discomusecase.beans.AdminInfo;
import com.bcits.discomusecase.beans.EmployeeMaster;

public interface AdminDao {

	public AdminInfo authenticate(String username, String password);
	public boolean addEMployee(EmployeeMaster empInfo);
}
