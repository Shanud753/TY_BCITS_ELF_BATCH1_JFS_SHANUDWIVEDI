
package com.bcits.discomusecase.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bcits.discomusecase.beans.BillHistory;
import com.bcits.discomusecase.beans.ConsumersMaster;
import com.bcits.discomusecase.beans.CurrentBill;
import com.bcits.discomusecase.beans.EmployeeMaster;
import com.bcits.discomusecase.beans.MonthlyConsumption;
import com.bcits.discomusecase.beans.SupportCustBean;
import com.bcits.discomusecase.service.ConsumerService;



@Controller
public class ConsumerController {

	@Autowired
	private ConsumerService service;

	@InitBinder public void initBinder(WebDataBinder binder) { CustomDateEditor
		dateEditor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
	binder.registerCustomEditor(Date.class, dateEditor); }



	@GetMapping("/consumerLoginPage")
	public String displayConsumerLoginForm() {
		return "consumerLoginPage";
	}
	
	
	@GetMapping("/consumerContentPage")
	public String displayconsumerContentPage() {
		return "consumerContent";
	}
	
	
	@GetMapping("/ConsumerLogout")
	public String employeeLogOut(ModelMap modelMap, HttpSession session) {
		session.invalidate();
		return "consumerLoginPage";
	}//end of employeeLogOut()

	@PostMapping("/consumerLoginPage")
	public String authenticate(String email ,String password,HttpServletRequest req, ModelMap modelMap) {
		ConsumersMaster consumerInfoBean = service.authenticate(email,password);
		if (consumerInfoBean != null) {
			HttpSession session = req.getSession(true);
			session.setAttribute("loggedInconInfo", consumerInfoBean);
			return "consumerContent";
		} else {
			modelMap.addAttribute("errMsg", "Invalid Credential !!");
			return "consumerLoginPage";
		}
		
	}//End of authenticate()
	  @GetMapping("/displayForgotPasswordPage")
	public String displayPasswordForgot(HttpSession session, ModelMap modelMap) {
		  ConsumersMaster master = (ConsumersMaster) session.getAttribute("loggedInconInfo");
		if (master != null) {
			return "forgotPasswordPage";
		} else {
			modelMap.addAttribute("errMsg", "Please Login First..");
			return "consumerLoginPage";
		}
	}
	  
	  @PostMapping("/resetPassword")
		public String changePassword(HttpSession session, ModelMap modelMap ,String password ,String confPassword) {
		  ConsumersMaster master = (ConsumersMaster) session.getAttribute("loggedInconInfo");
			if (master != null) {
				if(service.changePassword(password, confPassword, master.getRrNumber())) {
					modelMap.addAttribute("msg", "Password Changed Successfully");
					return "forgotPasswordPage";
				}else {
				modelMap.addAttribute("errMsg", "Failed to change the password!!");
				return "forgotPasswordPage";
				}
			}else {
				modelMap.addAttribute("errMsg", "Please Login First..");
				return "consumerLoginPage";
			}
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

	

	@GetMapping("/electricityConsumption")
	public String consumptionPage(HttpSession session, ModelMap modelMap) {
		ConsumersMaster master = (ConsumersMaster) session.getAttribute("loggedInconInfo");
		int rrNumber = master.getRrNumber();
			if(master != null) {
				List<MonthlyConsumption> consumption2 = service. getConsumption(rrNumber);
				if(consumption2 != null && !consumption2.isEmpty()) {
					modelMap.addAttribute("monthlyConsumption", consumption2);
					return "electricityConsumption";
				}else {
					modelMap.addAttribute("errMsg", "Monthly Consumption Not Found");
					return "electricityConsumption";
				}
			}else {
				session.invalidate();
				return "consumerLoginPage";	
			}	
	}

	@GetMapping("/currentBill")
	public String getCurrentBill(HttpSession session, ModelMap modelMap) {
	ConsumersMaster master = (ConsumersMaster) session.getAttribute("loggedInconInfo");
	int rrNumber = master.getRrNumber();
	 
		if(master != null) {
			CurrentBill billInfo = service.currentBillDetails(rrNumber);
			if(billInfo != null) {
				modelMap.addAttribute("billInfo", billInfo);
				return "currentBillDetails";
			}else {
            modelMap.addAttribute("errMsg", "Bill Not Generated for You");
				return "actionSuccessFullPage";
			}

		}else {
			session.invalidate();
			return "consumerLoginPage";	
		}
}
	@GetMapping("/payment")
	public String paymentPage(HttpSession session, ModelMap modelMap) {
		ConsumersMaster consumerBean = (ConsumersMaster) session.getAttribute("loggedInconInfo");
		if(consumerBean != null) {
			int rrNumber = consumerBean.getRrNumber();
			CurrentBill currentBillBean = service.getBillAmount(rrNumber);
			if(currentBillBean != null) {
			modelMap.addAttribute("currentBillBean",currentBillBean);
			return "paymentPage";
			}else {
				modelMap.addAttribute("errMsg", "Bill Not Generated for You So No need to Pay");
				return "actionSuccessFullPage";
			}
			
		}else {
			modelMap.addAttribute("errMsg", "Please Login First!!");
			return "consumerLoginPage";
		}	
	}
  
	@PostMapping("/successfullPaymentPage")
	public String displaySuccessfullPaymentPage(HttpSession session, ModelMap modelMap) {
	  ConsumersMaster master = (ConsumersMaster) session.getAttribute("loggedInconInfo");
	  Date date = new Date();
	  if(master != null) {
		    int meterNumber = master.getRrNumber();
			CurrentBill currentBillBean = service.getBillAmount(meterNumber);
			 double amount = currentBillBean.getBillAmount();
		  if(service.billPayment(master.getRrNumber(), date, amount)) {
			  modelMap.addAttribute("currentBillBean",currentBillBean);
			  return "paymentSuccessFullPage";
		  }else {
			  modelMap.addAttribute("errMsg", "Unable to Process try Again Later !!");
			  return "actionSuccessFullPage";
		  }
	  }else {
		  return "consumerLoginPage";
	  }
	}
	
	@GetMapping("/displayBillHistorysPage")
	public String displayBillHistoryPage(HttpSession session, ModelMap modelMap) {
		ConsumersMaster consumerMaster = (ConsumersMaster) session.getAttribute("loggedInconInfo");
		if(consumerMaster != null) {
			List<BillHistory> billHistory = service.getBillHistory(consumerMaster.getRrNumber());
			if(billHistory != null && !billHistory.isEmpty()) {
				modelMap.addAttribute("billHistory", billHistory);
				return "billHistoryPage";
			}else {
				modelMap.addAttribute("errMsg", "No Bill History For You..:(");
				return "billHistoryPage";
			}
		}else {
			modelMap.addAttribute("errMsg", "Please Login First...");
			return "consumerLoginPage";
		}
	}
	
	@GetMapping("/queryPage")
	public String getQueryPage() {
		return "complaintsDetailsPage";
	}
	@PostMapping("/getQueryInfo")
	public String getQuery(HttpSession session, ModelMap modelMap,String request) {
		ConsumersMaster consumersMaster = (ConsumersMaster) session.getAttribute("loggedInconInfo");
		if (consumersMaster != null ) {
			if(service.setSupportRequest(request, consumersMaster.getRrNumber(), consumersMaster.getRegion())) {
				modelMap.addAttribute("msg","request sent.");
				return "complaintsDetailsPage";
			}else {
				modelMap.addAttribute("errMsg","No query to display!!");
				return "complaintsDetailsPage";
			}
			
		}else {
			modelMap.addAttribute("errMsg", "Please Login First..");
			return "consumerLoginPage";
		}
	}
	@GetMapping("/consumerComplaintResolvedDetails")
	public String displayconsumerComplaintResolvedDetails(ModelMap modelMap, HttpSession session) {
		ConsumersMaster consumersMaster = (ConsumersMaster) session.getAttribute("loggedInconInfo");
		if(consumersMaster != null) {
			List<SupportCustBean> supportList = service.getResponse(consumersMaster.getRrNumber());
			if(supportList != null && !supportList.isEmpty()) {
				modelMap.addAttribute("supportList",supportList);
				return "consumerComplaintResolvedPage";
			}else {
				modelMap.addAttribute("errMsg","No Response found..");
				return "consumerComplaintResolvedPage";
			}
			
		}else {
			modelMap.addAttribute("errMsg", "Invalid Credential !!");
			return "consumerLoginPage";
		}
	}
	@GetMapping("/forgotPasswordPage")
	public String displayConsumerForgotPasswordPage(){
		return "consumerForgotPassword";
	}// end of displayConsumerForgotPasswordPage()
	
	@PostMapping("/forgotPassword")
	public String consumerPasswordChange(ConsumersMaster consumersMaster, String confPassword,ModelMap modelMap){
		if(service.authenticationForgotPassword(consumersMaster)){
			if(service.forgotPassword(consumersMaster, confPassword)){
				modelMap.addAttribute("msg", "Password Changed successfully !!");
				return "consumerForgotPassword";
			}else{
				modelMap.addAttribute("errMsg", "Unable To Change The Password!!");
				return "consumerForgotPassword";
			}
			
		}else{
			modelMap.addAttribute("errMsg", "Invalid Meter Number Or Email");
			return "consumerForgotPassword";
		}
	}// end of consumerPasswordSet()

	
	@GetMapping("/homePage")
	public String displayhomePage() {
		return "index";
	}
	
}
