package com.bcits.discomusecase.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bcits.discomusecase.service.ConsumerService;

@Controller
//@RequestMapping("/consumer")
public class ConsumerController {

//	@InitBinder
//	public void initBinder(WebDataBinder binder) {
//		CustomDateEditor dateEditor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
//		binder.registerCustomEditor(Date.class, dateEditor);
//	}
//	@Autowired
//	private ConsumerService service;
	
	@GetMapping("/consumerLoginPage")
	public String displayConsumerLoginForm() {
		return "consumerLoginPage";
	}
	
	@GetMapping("/consumerRegistration")
	public String displayConsumerRegistrationform() {
		return "consumerRegistration";
	}
	
	@GetMapping("/employeeLogin")
	public String displayemployeeLoginForm() {
		return "employeeLoginForm";
	}
	
	@GetMapping("/homePage")
	public String displayhomePage() {
		return "index";
	}
}
