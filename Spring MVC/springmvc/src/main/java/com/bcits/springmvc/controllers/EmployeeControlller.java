package com.bcits.springmvc.controllers;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.bcits.springmvc.beans.EmployeeInfoBean;
import com.bcits.springmvc.dao.EmployeeDao;

import com.bcits.springmvc.service.EmployeeService;

@Controller
public class EmployeeControlller {

	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		CustomDateEditor dateEditor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
		binder.registerCustomEditor(Date.class, dateEditor);
	}
	@Autowired
	private EmployeeService service ;
	@GetMapping("/login")
	public String displayLogin() {
		
		return "empLoginForm";
	}
	@PostMapping("/login")
	public String authenticate(int empId ,String password,HttpServletRequest req, ModelMap modelMap) {
		
		
		EmployeeInfoBean employeeInfoBean = service.authenticate(empId, password);
		
		if(employeeInfoBean != null) {
			//Valid Credentials
			HttpSession session = req.getSession(true);
			session.setAttribute("loggedInEmpInfo", employeeInfoBean);
			
			return "employeeHome";
		}else {
			//Invalid Credentials
			modelMap.addAttribute("errMsg", "Invalid Credentials!!");
			return "empLoginForm";
		}
	}//End of authenticate()
	
	@GetMapping("/searchEmpForm")//just to display form
	public String displaySearchEmployeeForm(HttpSession session , ModelMap modelMap) {
		
		if(session.isNew()) {          //session Validation
			//User Not Logged IN
			session.invalidate();
			
			modelMap.addAttribute("errMsg", "Please Login First!");
			return "empLoginForm";
		}else {
			//User Already LoggedIn
			return "searchEmpForm";
		}
	}//End of displaySearchEmployeeForm()

	@GetMapping("/search")
 public String searchEmployee(int empId, HttpSession session, ModelMap modelMap) {
	 if(session.getAttribute("loggedInEmpInfo") != null) {
		 //Valid Session
		 EmployeeInfoBean employeeInfoBean = service.getEmployee(empId);
		 
		 if(employeeInfoBean != null) {
			 modelMap.addAttribute("employeeInfoBean", employeeInfoBean);
		 }else {
			 modelMap.addAttribute("errMsg", "Employee Id Not Found!");
		 }
		 return "searchEmpForm";
	 }else {
		 //Invalid Session
		 modelMap.addAttribute("errMsg", "Please Login First");
		 return "empLoginForm";
	 }
 }//End of searchEmployee()
	
	@GetMapping("/deleteEmpForm")
	public String displayDeleteEmployeeForm(@SessionAttribute(name="loggedInEmpInfo", required=false) EmployeeInfoBean employeeInfoBean,
			ModelMap modelMap) {
		
		if(employeeInfoBean != null) {
			//Valid Session
			return "deleteEmpForm";
		}else {
			//Invalid Session
			modelMap.addAttribute("errMsg", "Please Login First!!");
			return "empLoginForm";
		}
		
	}//End of displayDeleteEmployeeForm()
	@GetMapping("/delete")
	public String deleteEmployee(int empId, @SessionAttribute(name="loggedInEmpInfo",required = false) EmployeeInfoBean employeeInfoBean,
			ModelMap modelMap) {
		if(employeeInfoBean != null) {
			//Valid Session
			if(service.deleteEmployee(empId)) {
				modelMap.addAttribute("msg", "Employee Record Deleted SuccessFully!!");
			}else {
				 modelMap.addAttribute("errMsg", "Employee Id Not Found");
			}
			return "deleteEmpForm";
		}else {
			modelMap.addAttribute("errMsg", "Please Login First!!");
			return "empLoginForm";
		}
		
	}//End of deleteEmployee()
	@GetMapping("/logout")
	public String logout(HttpSession session, ModelMap modelMap) {
		
		session.invalidate();
		modelMap.addAttribute("errMsg", "You Are SuccessFully Logged Out");
		
		return "empLoginForm";
	}
	
	/*
	 * @GetMapping("/getAllEmpForm") public String
	 * seeAllEmpForm(@SessionAttribute(name="loggedInEmpInfo", required=false)
	 * EmployeeInfoBean employeeInfoBean, ModelMap modelMap) {
	 * 
	 * if(employeeInfoBean != null) { //Valid Session return "seeAllEmpForm"; }else
	 * { //Invalid Session modelMap.addAttribute("errMsg", "Please Login First!!");
	 * return "empLoginForm"; }
	 * 
	 * }//End of seeAllEmpForm()
	 */	
	@GetMapping("/seeAllEmployee")
	public String getAllEmployeeInfo(
			@SessionAttribute(name = "loggedIngInfo", required = false) EmployeeInfoBean employeeInfoBean, ModelMap modelMap,
			EmployeeInfoBean infoBean) {
		if (infoBean != null) {
			//Valid Session
			List<EmployeeInfoBean> empInfoList = service.getAllEmployees();
			modelMap.addAttribute("allEmpDetails", empInfoList);
			return "getAllEmpForm";
		} else {
			// Invalid session
			modelMap.addAttribute("errMsg", "Please Login First..");
			return "employeeLoginForm";
		}
	}//End of getAllEmployeeInfo()
	@GetMapping("/addEmpForm")
	public String displayAddEmployeeForm(@SessionAttribute(name="loggedInEmpInfo", required=false) EmployeeInfoBean employeeInfoBean,
			ModelMap modelMap) {
		
		if(employeeInfoBean != null) {
			//Valid Session
			return "addEmpForm";
		}else {
			//Invalid Session
			modelMap.addAttribute("errMsg", "Please Login First!!");
			return "empLoginForm";
		}
		
	}//End of displayAddEmployeeForm()
	
	@PostMapping("/addEmployee")
	public String addEmployee(@SessionAttribute(name="loggedInEmpInfo",required = false) EmployeeInfoBean employeeInfoBean,
			ModelMap modelMap, EmployeeInfoBean employeeInfoBean2,String cnfpassword) {
		if(employeeInfoBean != null) {
			//Valid Session
			if(service.addEmployee(employeeInfoBean2, cnfpassword)) {
				modelMap.addAttribute("msg", "Employee Record Added SuccessFully!!");
				return "addEmpForm";
			}else {
				 modelMap.addAttribute("errMsg", "Employee Id Not Found");
				 return "addEmpForm";
			}
			
		}else {
			modelMap.addAttribute("errMsg", "Please Login First!!");
			return "empLoginForm";
		}
		
	}//End of addEmployee()
	
	@GetMapping("/updateEmpForm")
	public String displayUpdateEmployeeForm(@SessionAttribute(name="loggedInEmpInfo", required=false) EmployeeInfoBean employeeInfoBean,
			ModelMap modelMap) {
		
		if(employeeInfoBean != null) {
			//Valid Session
			return "updateEmpForm";
		}else {
			//Invalid Session
			modelMap.addAttribute("errMsg", "Please Login First!!");
			return "empLoginForm";
		}
		
	}//End of displayUpdateEmployeeForm()
	
	@GetMapping("/updateEmployee")
	public String updateEmployee(@SessionAttribute(name="loggedInEmpInfo",required = false) EmployeeInfoBean employeeInfoBean,
			ModelMap modelMap ,EmployeeInfoBean employeeInfoBean2) {
		if(employeeInfoBean != null) {
			//Valid Session
			if(service.updateEmployee(employeeInfoBean2)) {
				modelMap.addAttribute("msg", "Employee Record Updated SuccessFully!!");
			}else {
				 modelMap.addAttribute("errMsg", "Employee Id Not Found");
			}
			return "updateEmpForm";
		}else {
			modelMap.addAttribute("errMsg", "Please Login First!!");
			return "empLoginForm";
		}
		
	}//End of updateEmployee()

}
