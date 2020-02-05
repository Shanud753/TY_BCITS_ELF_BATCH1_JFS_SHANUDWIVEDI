
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
import com.bcits.discomusecase.beans.MonthlyConsumption;
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
	
	@GetMapping("/ConsumerLogout")
	public String employeeLogOut(ModelMap modelMap, HttpSession session) {
		session.invalidate();
		return "consumerLoginPage";
	}//end of employeeLogOut()

	@PostMapping("/consumerLoginPage")
	public String authenticate(int rrNumber ,String password,HttpServletRequest req, ModelMap modelMap) {

		ConsumersMaster consumerInfoBean = service.authenticate(rrNumber,password);	
		if(consumerInfoBean != null) {
			//Valid Credentials
			HttpSession session = req.getSession(true);
			session.setAttribute("loggedInconInfo", consumerInfoBean);

			return "consumerContent";
		}else {
			//Invalid Credentials
			modelMap.addAttribute("errMsg", "Invalid Credentials!!");
			return "consumerLoginPage";
		}
	}//End of authenticate()


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
		if(!session.isNew()) {
			if(master != null) {
				List<MonthlyConsumption> consumption2 = service. getConsumption(rrNumber);
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
	if(!session.isNew()) {
		if(master != null) {
			CurrentBill billInfo = service.currentBillDetails(rrNumber);
			modelMap.addAttribute("billInfo", billInfo);
			return "currentBillDetails";

		}else {
			modelMap.addAttribute("errMsg", "Current Bill Not Found");
			return "currentBillDetails";	
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
			int meterNumber = consumerBean.getRrNumber();
			CurrentBill currentBillBean = service.getBillAmount(meterNumber);
			modelMap.addAttribute("currentBillBean",currentBillBean);
			return "paymentPage";
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
			 Double amount = currentBillBean.getBillAmount();
		  if(service.billPayment(master.getRrNumber(), date, amount)) {
			  modelMap.addAttribute("currentBillBean",currentBillBean);
			  return "paymentSuccessFullPage";
		  }else {
			  modelMap.addAttribute("errMsg", "Unable to Process try Again Later !!");
			  return "consumerFailedPage";
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
			if(billHistory != null) {
				modelMap.addAttribute("billHistory", billHistory);
				return "billHistoryPage";
			}else {
				modelMap.addAttribute("errMsg", "Unable to Process Try Again Later!!");
				return "consumerFailedPage";
			}
		}else {
			modelMap.addAttribute("errMsg", "Please Login First...");
			return "consumerLoginPage";
		}
	}
	
	
	
	@GetMapping("/homePage")
	public String displayhomePage() {
		return "index";
	}
	
}
