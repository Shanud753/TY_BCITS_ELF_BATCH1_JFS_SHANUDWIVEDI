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
import com.bcits.discomusecase.beans.CurrentBill;
import com.bcits.discomusecase.beans.EmployeeMaster;
import com.bcits.discomusecase.beans.SupportCustBean;
import com.bcits.discomusecase.sendemail.EmailGenerator;
import com.bcits.discomusecase.service.ConsumerService;
import com.bcits.discomusecase.service.EmployeeService;
import com.bcits.discomusecase.beans.BillHistory;
import com.bcits.discomusecase.beans.EmployeeMaster;
import com.bcits.discomusecase.beans.MonthlyConsumption;


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
	public String authenticate(int empId, String password, ModelMap modelMap,HttpServletRequest req) {
		EmployeeMaster employeeMasterBean=service.authentication(empId,password); 
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
			double previousReading = service.getPreviousReading(rrNumber);
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

	@GetMapping("/billGenerated")
	public String generateBill(ModelMap modelMap,HttpSession session,CurrentBill currentBill) {
		EmployeeMaster employeeMaster= (EmployeeMaster)session.getAttribute("loggedInEmp");
		if(employeeMaster!= null) {
			CurrentBill currentBill1 = service.addCurrentBill(currentBill,employeeMaster.getRegion());
			if (currentBill1 != null) {
				ConsumersMaster consumer= conService.getConsumer(currentBill1.getRrNumber());
				if(service.sendMail(currentBill1.getRrNumber(), consumer)) {
					modelMap.addAttribute("msg", "Bill Generated for RR Number " + currentBill.getRrNumber() + " Sucessfully..");
					return "actionSuccessFullPage";

				}else {

					modelMap.addAttribute("errMsg", "This Month Bill is Already Generated" + currentBill.getRrNumber());
					return "actionSuccessFullPage";
				}


			}else {
				modelMap.addAttribute("errMsg", "No Record Found");
				return "actionSuccessFullPage";

			}
		}else {
			modelMap.addAttribute("errMsg","Please Login First");
			return "employeeLoginForm";
		}

	}



	@GetMapping("/consumerComplaintsDetails")
	public String diplayComplaintPage(ModelMap modelMap, HttpSession session) {
		EmployeeMaster empMasterInfo = (EmployeeMaster) session.getAttribute("loggedInEmp");
		if(empMasterInfo != null) {
			List<SupportCustBean> supportList = service.getComplaints(empMasterInfo.getRegion());
			if(supportList != null) {
				modelMap.addAttribute("supportList",supportList);
			}else {
				modelMap.addAttribute("errMsg","No Querys found..");
			}
			return "complaintsResolvedPage";
		}else {
			modelMap.addAttribute("errMsg", "Invalid Credential !!");
			return "employeeLoginPage";
		}
	}

	@GetMapping("/sendResponse")
	public String sendResponseToConsumer(ModelMap modelMap, HttpSession session,Integer rrNumber,String response, Date date) {
		EmployeeMaster empMasterInfo = (EmployeeMaster) session.getAttribute("loggedInEmp");

		if (empMasterInfo != null) {
			if(service.sendResponse(rrNumber, response, date)) {
				modelMap.addAttribute("msg","response sent.");
			}
			return "complaintsResolvedPage";
		}else {
			modelMap.addAttribute("errMsg", "Please Login First..");
			return "employeeLoginPage";
		}
	}

	@GetMapping("/BillCollected")
	public String displayBillCollectedPage(ModelMap modelMap, HttpSession session) {
		EmployeeMaster empMasterInfo = (EmployeeMaster) session.getAttribute("loggedInEmp");
		if(empMasterInfo != null) {
			List<BillHistory> billHistoryLists = service.getBillList(empMasterInfo.getRegion());
			if(billHistoryLists != null && !billHistoryLists.isEmpty()) {
				modelMap.addAttribute("billHistroy",billHistoryLists);
			}else {
				modelMap.addAttribute("errMsg","No record is found.");
			}
			return "billCollected";
		}else {
			modelMap.addAttribute("errMsg", "Invalid Credential !!");
			return "employeeLoginPage";
		}
	}

	@GetMapping("/billPending")
	public String displayBillCollected(ModelMap modelMap, HttpSession session) {
		EmployeeMaster empMasterInfo = (EmployeeMaster) session.getAttribute("loggedInEmp");
		if(empMasterInfo != null) {
			List<MonthlyConsumption> billList = service.getCollectedBill(empMasterInfo.getRegion());
			if(billList != null && !billList.isEmpty()) {
				modelMap.addAttribute("billList",billList);
			}else {
				modelMap.addAttribute("errMsg","No record is found.");
			}
			return "PendingBills";
		}else {
			modelMap.addAttribute("errMsg", "Invalid Credential !!");
			return "employeeLoginPage";
		}
	}

	@GetMapping("/deleteConsumer")
	public String removeConsumer(ModelMap modelMap, HttpSession session,int rrNumber) {
		EmployeeMaster empMasterInfo = (EmployeeMaster) session.getAttribute("loggedInEmp");
		if(empMasterInfo != null) {
			if(service.removeConsumer(rrNumber)) {
				modelMap.addAttribute("msg","Consumer Profile Deleted.");
			}
			return "complaintsResolvedPage";
		}else {
			modelMap.addAttribute("errMsg", "Please Login First..");
			return "employeeLoginPage";
		}
	}
	
	@GetMapping("/monthlyrevenue")
	public String consumptionPage(HttpSession session, ModelMap modelMap) {
		EmployeeMaster empMasterInfo = (EmployeeMaster) session.getAttribute("loggedInEmp");
		if(empMasterInfo != null) {
		       List<Object[]> billCollectedList =service.monthlyCollectedBills(empMasterInfo.getRegion());
		       List<Object[]> billsPending =service.monthlyBillsPending(empMasterInfo.getRegion());
		       List<Object[]> totalRevenue =service.totalRevenueGenerated(empMasterInfo.getRegion());
		       modelMap.addAttribute("billCollectedList",billCollectedList);
		       modelMap.addAttribute("billsPending",billsPending);
		       modelMap.addAttribute("totalRevenue",totalRevenue);
		       return "monthRevenue";
		       
		}else {
			session.invalidate();
			return "employeeLoginPage";
		}
	}
	
	@PostMapping("/clearDueAmount")
	public String clearDue(HttpSession session, ModelMap modelMap,int rrNumber,Date date) {
		EmployeeMaster empMasterInfo = (EmployeeMaster) session.getAttribute("loggedInEmp");
		if(empMasterInfo != null) {
		 if(service.clearDueAmount(rrNumber, date)) {
			 List<MonthlyConsumption> monthlyBillList = service.getCollectedBill(empMasterInfo.getRegion());
			 if(monthlyBillList != null && !monthlyBillList.isEmpty()) {
				 modelMap.addAttribute("monthlyBillList",monthlyBillList);
				}else {
					modelMap.addAttribute("errMsg","No record is found.");
				} 
			 }else {
				 modelMap.addAttribute("errMsg","No record is found."); 
		 }
		 return "PendingBills";
		}else {
			modelMap.addAttribute("errMsg", "Please Login First..");
			return "employeeLoginPage";
		}
	}
}



