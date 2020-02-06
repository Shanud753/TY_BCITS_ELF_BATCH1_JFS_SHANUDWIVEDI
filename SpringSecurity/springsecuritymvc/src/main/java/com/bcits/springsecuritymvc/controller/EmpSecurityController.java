package com.bcits.springsecuritymvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bcits.springsecuritymvc.beans.EmpInfoBean;
import com.bcits.springsecuritymvc.service.EmpService;

@Controller
public class EmpSecurityController {

	@Autowired
	private EmpService service;
	
	@GetMapping("/index")
	public String getIndexPage() {
		return "index";
	}
	
	@GetMapping("/register")
	public String getRegisterPage() {
		return "register";
	}
	
	@PostMapping("/register")
	public String register(EmpInfoBean infoBean,ModelMap modelMap) {
		boolean isRegistered = service.register(infoBean);
		if(isRegistered) {
			modelMap.addAttribute("msg", "Registered SuccessFullyy....");
		}else {
			modelMap.addAttribute("errMsg", "Registration Failed :(!!");

		}
		return "register";
	}
	
	@GetMapping("/userSecureHome")
	public String getUserHomePage() {
		return "userHomePage";
	}
	
	@GetMapping("/getEmployeeForm")
	public String getEmployeeForm() {
		return "search";
	}
	
	@GetMapping("/getEmployee")
	public String getEmployee(int empId,ModelMap modelMap) {
		EmpInfoBean empInfoBean = service.getEmployee(empId);
		modelMap.addAttribute("empInfoBean", empInfoBean);
		return "search";
	}
	@GetMapping("/getAllEmployees")
	public String getAllEmployees(ModelMap modelMap) {
		List<EmpInfoBean> employeesList = service.getAllEmployee();
		modelMap.addAttribute("employeesList",employeesList );
		 return "getAllEmployees";
	}
}//End of Controller
