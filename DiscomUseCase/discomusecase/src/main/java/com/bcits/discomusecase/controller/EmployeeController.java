package com.bcits.discomusecase.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
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

import com.bcits.discomusecase.beans.ConsumersMaster;
import com.bcits.discomusecase.beans.EmployeeMaster;
import com.bcits.discomusecase.service.ConsumerService;
import com.bcits.discomusecase.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	@Autowired
	private ConsumerService conService;
	
	  @InitBinder public void initBinder(WebDataBinder binder) { CustomDateEditor
	  dateEditor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
	  binder.registerCustomEditor(Date.class, dateEditor); }
	 
	@GetMapping("/employeeLogin")
	public String displayemployeeLoginForm() {
		return "employeeLoginForm";
	}
	
	
	@PostMapping("/employeeContent")
	public String employeeContent(int empId ,String designation,HttpServletRequest req, ModelMap modelMap) {
		return "employeeContent";
	}
	
	@PostMapping("/employeeLoginHome")
	public String authenticate(Integer empId, String designation, ModelMap modelMap,HttpServletRequest req) {
		EmployeeMaster employeeMasterBean=service.authentication(empId,designation); 
		String region = employeeMasterBean.getRegion();
        if( employeeMasterBean!= null) { 
	        HttpSession session = req.getSession(true);
       	    session.setAttribute("loggedInEmp", employeeMasterBean);
       	   int count = service.noOfConsumers(region);
       	   modelMap.addAttribute("count", count);
       	    return "employeeContent";
        }else {
	     modelMap.addAttribute("errMsg","Invalid Creadential");
	    return "employeeLoginForm";
        }     
	}// end of authenticate()
	
	@GetMapping("/employeeLogout")
	public String employeeLogOut(ModelMap modelMap, HttpSession session) {
		session.invalidate();
		return "employeeLoginForm";
	}//end of employeeLogOut()
	
	@GetMapping("/currentBillPageGen")
	public String displayCurrentBillPageGen() {
		return "currentBillGenerate";
		
	}// end of displayCurrentBillPage()
	
	
	@GetMapping("/getAllConsumer")
	public String getAllConsumer(HttpSession session ,ModelMap modelMap) {
		EmployeeMaster employeeMasterBean = (EmployeeMaster)session.getAttribute("loggedInEmp");
		if(session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("errMsg","Please Login First");
			return "employeeLoginForm";
		}else {
			if(employeeMasterBean != null) {
			  String region = employeeMasterBean.getRegion();
			  List<ConsumersMaster> consumersMasterList=service.getAllConsumer(region);
			  modelMap.addAttribute("consumersMasterList",consumersMasterList);
			  return "employeeConsumerDetails";
			}else {
				modelMap.addAttribute("errMsg","Unable to Load");
				return "consumerFailedPage";
			}
		}
	}//end of getAllConsumer()
	
	
	@GetMapping("/billGeneration")
	public String dispalyBillGeneration(HttpSession session ,ModelMap modelMap) {
		EmployeeMaster employeeMasterBean = (EmployeeMaster)session.getAttribute("loggedInEmp");
		if(session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("errMsg","Please Login First");
			return "employeeLoginForm";
		}else {
			if(employeeMasterBean != null) {
			  String region = employeeMasterBean.getRegion();
			  List<ConsumersMaster> consumersMasterList=service.getAllConsumer(region);
			  modelMap.addAttribute("consumersMasterList",consumersMasterList);
			  return "employeeBillGeneration";
			}else {
				modelMap.addAttribute("errMsg","Unable to Load");
				return "consumerFailedPage";
			}
		}
	}//end of dispalyBillGeneration()
	
	@GetMapping("/billGeneratePage")
	public String displayCurrentBillPage(HttpSession session ,ModelMap modelMap,int rrNumber) {
		EmployeeMaster employeeMasterBean = (EmployeeMaster)session.getAttribute("loggedInEmp");
		
			if(employeeMasterBean != null) {
				ConsumersMaster master = conService.getConsumer(rrNumber);
				Double previousReading = service.getPreviousReading(rrNumber);
				if(master != null) {
					 modelMap.addAttribute("conMaster", master);	
					 modelMap.addAttribute("previousReading", previousReading);		  
				}
				
			}else {
				modelMap.addAttribute("errMsg","Unable to Load");
				return "consumerFailedPage";
			}
			return "currentBillGenerate";	
	}//end of displayCurrentBillPage()
	
}	
	

