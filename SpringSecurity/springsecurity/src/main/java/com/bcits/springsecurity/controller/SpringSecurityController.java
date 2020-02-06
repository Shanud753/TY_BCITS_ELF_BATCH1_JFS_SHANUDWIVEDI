package com.bcits.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SpringSecurityController {

	@GetMapping("/index")
	public String getIndexPage() {
		return "index";
	}//End of getIndexPage()
	
	@GetMapping("/adminSecureHome")
	public String getAdminHomePage() {
		return  "adminHomePage";
	}//End of  getAdminHomePage()
	
	@GetMapping("/userSecureHome")
	public String getUserHomePage() {
		return  "userHomePage";
	}//End of getUserHomePage()
	
	   @GetMapping("/login")
		public String loginForm() {
			return "loginForm";
		}
	
	
}//End of Class
