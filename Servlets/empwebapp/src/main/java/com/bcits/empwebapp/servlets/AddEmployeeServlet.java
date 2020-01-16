package com.bcits.empwebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bcits.empwebapp.beans.EmployeePrimaryInfo;
@WebServlet("/addEmployee")
public class AddEmployeeServlet extends HttpServlet {
     
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		//Get the Form Data
		String empIdVal = req.getParameter("empId");
		String nameVal = req.getParameter("ename");
		String mobileVal =req.getParameter("mobileNo");
		String designationVal = req.getParameter("designation");
		String empSalVal = req.getParameter("salary");
		String empPasswordVal = req.getParameter("password");
		String joiningDateVal = req.getParameter("doj");
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date joiningDate = null;
		
		try {
			joiningDate = dateFormat.parse(joiningDateVal);
		} catch(ParseException e){
			e.printStackTrace();
		}
		
		
		EmployeePrimaryInfo primaryInfo = new EmployeePrimaryInfo();
		primaryInfo.setEmpId(Integer.parseInt(empIdVal));
		primaryInfo.setEname(nameVal);
		primaryInfo.setMobileNo(Long.parseLong(mobileVal));
		primaryInfo.setDesignation(designationVal);
		primaryInfo.setSalary(Double.parseDouble(empSalVal));
		primaryInfo.setPassword(empPasswordVal);
		primaryInfo.setDoj(joiningDate);
		
		//Store Employee Data in to DB
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("emsPersistenceUnit");
		EntityManager manager = emf.createEntityManager();
		EntityTransaction tx = manager.getTransaction();
		boolean isAdded = false;
		try {
			tx.begin();
			manager.persist(primaryInfo);
			tx.commit();
			isAdded = true;
		} catch(Exception e) {
			
			e.printStackTrace();
		}
		
		manager.close();
		emf.close();
		
		PrintWriter out = resp.getWriter();
		
		out.println("<html>");
		out.println("<body>");
		if(isAdded) {
			//Employee added Successfully
			out.println("<h1 style='color: green'> Employee Record for Id "+ empIdVal + " Inserted </h1>");
		} else {
			out.println("<h1 style='color: red'> Unable to Insert "+ empIdVal + " Record !! </h1>");
		}
		out.println("</html>");
		out.println("</body>");
		
		
	}//End of doPost()
}//End of Class
