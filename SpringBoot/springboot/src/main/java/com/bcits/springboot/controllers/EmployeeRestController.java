package com.bcits.springboot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bcits.springboot.beans.EmployeeInfoBean;
import com.bcits.springboot.beans.EmployeeResponse;
import com.bcits.springboot.service.EmployeeService;

//@Controller
@RestController
public class EmployeeRestController {

	@Autowired
	public EmployeeService service;

	@GetMapping(path = "/getEmployee", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public EmployeeResponse getEmployee(int empId) {

		EmployeeInfoBean employeeInfoBean = service.getEmployee(empId);
		EmployeeResponse employeeResponse = new EmployeeResponse();

		if (employeeInfoBean != null) {
			employeeResponse.setStatusCode(201);
			employeeResponse.setMessage("Success");
			employeeResponse.setDescription("Employee Record Found For ID " + empId);
			employeeResponse.setEmployeeInfoBean(employeeInfoBean);
		} else {
			employeeResponse.setStatusCode(401);
			employeeResponse.setMessage("Faied");
			employeeResponse.setDescription("Employee ID not found");
		}

		return employeeResponse;
	}// End of getEmployee()

	@GetMapping(path = "/getAllEmployee", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public EmployeeResponse getAllEmployee() {
		List<EmployeeInfoBean> employeeList = service.getAllEmployees();
		EmployeeResponse employeeResponse = new EmployeeResponse();

		if (employeeList != null) {
			employeeResponse.setStatusCode(201);
			employeeResponse.setMessage("Success");
			employeeResponse.setDescription("Record Fetched SuccessFully");
			employeeResponse.setEmployeeList(employeeList);
		} else {
			employeeResponse.setStatusCode(401);
			employeeResponse.setMessage("Faied");
			employeeResponse.setDescription("Unable to Fetch the Records");
		}

		return employeeResponse;

	}// End of getAllEmployee()

	/*
	 * @DeleteMapping(path="/deleteEmployee", produces =
	 * {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}) public
	 * boolean deleteEmployee(int empId) { return service.deleteEmployee(empId);
	 * }//End of deleteEmployee()
	 */

	@DeleteMapping(path = "/deleteEmployee/{employeeID}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public EmployeeResponse deleteEmployee(@PathVariable(name = "employeeID") int empId) {
		boolean isDeleted = service.deleteEmployee(empId);
		EmployeeResponse employeeResponse = new EmployeeResponse();

		if (isDeleted) {
			employeeResponse.setStatusCode(201);
			employeeResponse.setMessage("Success");
			employeeResponse.setDescription("Record Deleted SuccessFully");
		} else {
			employeeResponse.setStatusCode(401);
			employeeResponse.setMessage("Faied");
			employeeResponse.setDescription("Unable to Delete the Record");
		}
		return employeeResponse;
	}// End of deleteEmployee()

	@PostMapping(path = "/addEmployee", consumes = { MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public EmployeeResponse addEmployee(@RequestBody EmployeeInfoBean employeeInfoBean) {

		boolean isAdded = service.addEmployee(employeeInfoBean, "qwerty");
		EmployeeResponse employeeResponse = new EmployeeResponse();

		if (isAdded) {
			employeeResponse.setStatusCode(201);
			employeeResponse.setMessage("Success");
			employeeResponse.setDescription("Record Added SuccessFully");
		} else {
			employeeResponse.setStatusCode(401);
			employeeResponse.setMessage("Faied");
			employeeResponse.setDescription("Unable to Add the Record");
		}
		return employeeResponse;
	}// End of addEmployee()
	
	
	  @PutMapping(path="/updateEmployee", consumes =
	  {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE}, produces
	  = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE}) public
	  EmployeeResponse updateEmployee(@RequestBody EmployeeInfoBean
	  employeeInfoBean) {
	  
	  boolean isUpdated = service.updateEmployee(employeeInfoBean);
	  EmployeeResponse employeeResponse = new EmployeeResponse();
	  
	  if(isUpdated) { employeeResponse.setStatusCode(201);
	  employeeResponse.setMessage("Success");
	  employeeResponse.setDescription("Record Updated SuccessFully"); }else {
	  employeeResponse.setStatusCode(401); employeeResponse.setMessage("Faied");
	  employeeResponse.setDescription("Unable to Update the Record"); } return
	  employeeResponse; }//End of updateEmployee()
	 

}// End of class
