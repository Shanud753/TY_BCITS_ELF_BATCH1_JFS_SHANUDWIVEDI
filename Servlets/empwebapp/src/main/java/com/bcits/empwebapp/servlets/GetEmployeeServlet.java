package com.bcits.empwebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bcits.empwebapp.beans.EmployeePrimaryInfo;
@WebServlet("/getEmployee")
public class GetEmployeeServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Validate the Session
		
		HttpSession session = req.getSession(false);
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		if (session != null) {
			//Valid session
			//Get the Form data
			
			String empIdVal = req.getParameter("empId");
			int empId = Integer.parseInt(empIdVal);
			
			//Search data in database
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("emsPersistenceUnit");
			EntityManager manager = emf.createEntityManager();
			EmployeePrimaryInfo employeePrimaryInfo = manager.find(EmployeePrimaryInfo.class, empId);
			
			if(employeePrimaryInfo!=null) {
				//display employee record
				EmployeePrimaryInfo loggedInfo = (EmployeePrimaryInfo) session.getAttribute("empInfo");
				out.println("<html>");
				out.println("<body>");
				
				out.println("<h1>Hello "+ loggedInfo.getEname()  + " ! </h1>" );
				out.println("<a href='./employeeHome.html'>HOME</a><br>" );
				
				out.println("<h1 style='color: green'>Employee Id "+empId  + " Found  </h1>" );
				out.println("<br><br>Employee Name = "+ employeePrimaryInfo.getEname());
				out.println("<br><br>Employee Mobile No = "+ employeePrimaryInfo.getMobileNo());
				out.println("<br><br>Employee Designation = "+ employeePrimaryInfo.getDesignation());
				out.println("<br><br>Employee Salary = "+ employeePrimaryInfo.getSalary());
				out.println("</body>");
				out.println("</html>");		
			}else {
				out.println("<html>");
				out.println("<body>");
				out.println("<h1 style='color: red'>Employee Id "+empId + " Not Found!!!</h1>" );
				out.println("</body>");
				out.println("</html>");	
			}
			manager.close();
			emf.close();
			
		}else {
			//Invalid Session
			out.println("<html>");
			out.println("<body>");
			out.println("<h1 style='color: red'> Please Login First !!!</h1>" );
			out.println("</body>");
			out.println("</html>");	
			
			req.getRequestDispatcher("./loginForm.html").include(req, resp);
		}
	}//End of doget()
}//End of class
