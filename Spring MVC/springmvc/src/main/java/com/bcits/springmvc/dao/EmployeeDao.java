package com.bcits.springmvc.dao;

import java.util.List;

import com.bcits.springmvc.beans.EmployeeInfoBean;

public interface EmployeeDao {

	public EmployeeInfoBean authenticate(int empId,String password);
	public boolean addEmployee(EmployeeInfoBean bean);
	public boolean deleteEmployee(int empId);
	public EmployeeInfoBean getEmployee(int empId);
	public List<EmployeeInfoBean> getAllEmployees();
	public boolean updateEmployee(EmployeeInfoBean bean);
		
	}

