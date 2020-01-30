package com.bcits.springboot.service;

import java.util.List;

import com.bcits.springboot.beans.EmployeeInfoBean;

public interface EmployeeService {
	
	public com.bcits.springboot.beans.EmployeeInfoBean authenticate(int empId,String password);
	public boolean addEmployee(EmployeeInfoBean bean,String cnfpassword);
	public boolean deleteEmployee(int empId);
	public EmployeeInfoBean getEmployee(int empId);
	public List<EmployeeInfoBean> getAllEmployees();
	public boolean updateEmployee(EmployeeInfoBean bean);
	
}//End of Service
