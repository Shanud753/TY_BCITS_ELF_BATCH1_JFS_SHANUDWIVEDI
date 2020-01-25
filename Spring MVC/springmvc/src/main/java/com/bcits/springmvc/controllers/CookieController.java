package com.bcits.springmvc.controllers;



import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cookie")
public class CookieController {

   @GetMapping("/cookiePage")
	public String getCookiePage() {
		return "cookiePage";
		
	}//End of getCookiePage()
   
   @GetMapping("/createCookie")
   public String createCookie(HttpServletResponse resp,ModelMap modelMap) {    //Handler Method
	   Cookie myCookie = new Cookie("empName","Vidya");
	   resp.addCookie(myCookie);
	   
	   modelMap.addAttribute("msg", "Cookie Create Successfully!..");
	   return "cookiePage";
	   }
   @GetMapping("/readCookie")                                                   //Handler Method
   public String readCookie(@CookieValue(name="empName", required=false) String employeeName, ModelMap map) { //required
	   if(employeeName != null) {
	   map.addAttribute("msg", "Cookie Value is "+ employeeName);
	   }else { 
		   map.addAttribute("errMsg", "Cookie Not Present!!"); 
	   }
	   return "cookiePage";
   }
}//End of Class
