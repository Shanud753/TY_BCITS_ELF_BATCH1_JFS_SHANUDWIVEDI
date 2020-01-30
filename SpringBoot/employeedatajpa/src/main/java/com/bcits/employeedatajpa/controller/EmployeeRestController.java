package com.bcits.employeedatajpa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bcits.employeedatajpa.beans.EmployeeInfoBean;
import com.bcits.employeedatajpa.beans.EmployeeResponse;
import com.bcits.employeedatajpa.repository.EmployeeRepository;

@RestController
public class EmployeeRestController {
  
	@Autowired
	private EmployeeRepository repository;
	
	/*
	 * @GetMapping(path="/getEmployee", produces =
	 * {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE}) public
	 * EmployeeResponse getEmployee(int empId) { EmployeeInfoBean employeeInfoBean =
	 * repository.findById(empId).get(); EmployeeResponse response = new
	 * EmployeeResponse(); if(employeeInfoBean != null) { //to understand that the
	 * data stored in database response.setStatusCode(201);
	 * response.setMessage("Success");
	 * response.setDescription("Record of Employee "+ empId + "Found");
	 * response.setEmployeeInfoBean(employeeInfoBean); }else {
	 * response.setStatusCode(201); response.setMessage("Success");
	 * response.setDescription("Record of Employee "+ empId + " Not Found"); }
	 * 
	 * return response; }//End of getEmployee()
	 */	
	
	@GetMapping(path="/getEmployee",
			produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public EmployeeResponse getEmployee(int empId) {
		//EmployeeInfoBean employeeInfoBean = repository.findById(empId).get();
		Optional<EmployeeInfoBean> op = repository.findById(empId);
		EmployeeResponse response = new EmployeeResponse();
		
		if(op.isPresent()) {  //to understand that the data stored in database
			EmployeeInfoBean employeeInfoBean = op.get();
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Record of Employee "+ empId + "Found");
			response.setEmployeeInfoBean(employeeInfoBean);
		}else {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Record of Employee "+ empId + " Not Found");
		}
		
		return response;
	}//End of getEmployee()
	
	@GetMapping(path="/getEmpIdAndPassEmployee",
			produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE}) 
	public EmployeeResponse getEmpIdAndPassEmployee(int empId,String password) {
		
		EmployeeInfoBean emplyoeeInfo=repository.getEmployeeByIdAndPass(empId, password);
		EmployeeResponse response = new EmployeeResponse();
		
		if(emplyoeeInfo != null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Record of Employees Found");
			response.setEmployeeInfoBean(emplyoeeInfo);
		}else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Record of Employees Not Found");
		}
		return response;
	}
}//End of Class
