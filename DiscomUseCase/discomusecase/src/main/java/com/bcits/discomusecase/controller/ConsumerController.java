package com.bcits.discomusecase.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.bcits.discomusecase.beans.ConsumersMaster;
import com.bcits.discomusecase.service.ConsumerService;


@Controller
//@RequestMapping("/consumer")
public class ConsumerController {

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		CustomDateEditor dateEditor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
		binder.registerCustomEditor(Date.class, dateEditor);
	}
	@Autowired
	private ConsumerService service;
	
	@GetMapping("/consumerLoginPage")
	public String displayConsumerLoginForm() {
		return "consumerLoginPage";
	}
	
	@PostMapping("/consumerContent")
	public String consumerContent() {
		return "consumerContent";
	}
	
	@GetMapping("/consumerRegister")
	public String displayConsumerRegistrationform() {
		return "consumerRegistration";
	}
	
	@PostMapping("/addConsumer")
	public String addConsumer(ConsumersMaster consumersMaster, ModelMap modelMap) {
			if(service.addConsumer(consumersMaster)) {
				modelMap.addAttribute("msg", "Consumer Record Added SuccessFully!!");
				return "consumerRegistration";
			}else {
				 modelMap.addAttribute("errMsg", "Consumer Not Added");
				 return "consumerRegistration";
			}
	
		
	}//End of addEmployee()
	
	@GetMapping("/employeeLogin")
	public String displayemployeeLoginForm() {
		return "employeeLoginForm";
	}
	
	@PostMapping("/employeeContent")
	public String employeeContent() {
		return "employeeContent";
	}
	
	
	@GetMapping("/homePage")
	public String displayhomePage() {
		return "index";
	}
}
