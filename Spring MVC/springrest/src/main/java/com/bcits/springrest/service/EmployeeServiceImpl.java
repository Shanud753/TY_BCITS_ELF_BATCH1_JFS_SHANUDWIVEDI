package com.bcits.springrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcits.springrest.beans.EmployeeInfoBean;

import com.bcits.springrest.dao.EmployeeDao;


@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao dao;
	
	@Override
	public EmployeeInfoBean authenticate(int empId, String password) {
		
		return dao.authenticate(empId, password);
	}


	@Override
	public boolean deleteEmployee(int empId) {
		if(empId <1) {
			return false;
		}
		return dao.deleteEmployee(empId);
	}//End of deleteEmployee()

	@Override
	public EmployeeInfoBean getEmployee(int empId) {
		if(empId<1) {
//			throw new EmployeeException("Invalid Employee Id!!");
		}
		
		EmployeeInfoBean employeeInfoBean = dao.getEmployee(empId);
		if(employeeInfoBean != null) {
//			throw new EmployeeException("Employee Id Not Found!!");
		}
		return employeeInfoBean;
	}//End of getEmployee()

	@Override
	public List<EmployeeInfoBean> getAllEmployees() {
		
		return dao.getAllEmployees();
	}

	@Override
	public boolean updateEmployee(EmployeeInfoBean bean) {
		if(bean != null) {
			return dao.updateEmployee(bean);
		}
		return dao.updateEmployee(bean);
	}

	@Override
	public boolean addEmployee(EmployeeInfoBean bean, String cnfpassword) {
		if(!bean.getPassword().equals(cnfpassword)) {
			return false;
		}
		return dao.addEmployee(bean);
	}

}
