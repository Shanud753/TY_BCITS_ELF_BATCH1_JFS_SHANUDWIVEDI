package com.bcits.springmvc.service;

import java.util.List;

import com.bcits.springmvc.beans.EmployeeInfoBean;

public interface EmployeeService {
	
	public EmployeeInfoBean authenticate(int empId,String password);
	public boolean addEmployee(EmployeeInfoBean bean);
	public boolean deleteEmployee(int empId);
	public EmployeeInfoBean getEmployee(int empId);
	public List<EmployeeInfoBean> getAllEmployees();
	public boolean updateEmployee(EmployeeInfoBean bean);
	
}//End of Service
