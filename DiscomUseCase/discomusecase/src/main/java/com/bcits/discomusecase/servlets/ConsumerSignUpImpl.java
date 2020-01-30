package com.bcits.discomusecase.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bcits.discomusecase.beans.ConsumersMaster;

public class ConsumerSignUpImpl extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Get the Form Data
		String firstName = req.getParameter("fName");
		String lastName = req.getParameter("lName");
		String email =req.getParameter("email");
		String mobNumber = req.getParameter("number");
		String fpassword = req.getParameter("password");
		String cpassword = req.getParameter("cpassword");
		String rrNumber = req.getParameter("rr-number");
		String address1 = req.getParameter("address1");
		String address2 = req.getParameter("address2");
		String city = req.getParameter("rr-number");


		ConsumersMaster consumersMaster = new ConsumersMaster();
		consumersMaster.setFirstName(firstName);
		consumersMaster.setLastName(lastName);
		consumersMaster.setEmail(email);
		consumersMaster.setPhnNo(Long.parseLong(mobNumber));
		consumersMaster.setPassword(fpassword);
		consumersMaster.setConfirmPassword(cpassword);
		consumersMaster.setRrNumber(rrNumber);
		consumersMaster.setAddressLine1(address1);
		consumersMaster.setAddressLine2(address2);
		consumersMaster.setCity(city);
		
		
		




	}

}
