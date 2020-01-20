package com.bcits.empwebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bcits.empwebapp.beans.EmployeePrimaryInfo;
@WebServlet("/deleteEmployee")
public class DeleteEmployeeServlet extends HttpServlet {


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   
		//Validate the Session
		HttpSession session = req.getSession(false);
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		if (session != null) {
		//Get the form Data
		String empIdVal = req.getParameter("empId");
		int empId = Integer.parseInt(empIdVal);

		//Search data in database
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("emsPersistenceUnit");
		EntityManager manager = emf.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
	    EmployeePrimaryInfo employeePrimaryInfo = manager.find(EmployeePrimaryInfo.class, empId);
		try {
			transaction.begin();
			manager.remove(employeePrimaryInfo);
			transaction.commit();
		}	catch (Exception e) {

			e.printStackTrace();
			transaction.rollback();
			
		} 
		manager.close();
		emf.close();

			if(employeePrimaryInfo!=null) {
				//display employee record
				out.println("<html>");
				out.println("<body>");
				out.println("<h1 style='color: green'>Employee Id "+empId  + " Found  </h1>" );
				out.println("Employee Details are Deleted" );
				out.println("</body>");
				out.println("</html>");	
				
			}else {
				out.println("<html>");
				out.println("<body>");
				out.println("<h1 style='color: red'>Employee Id "+empId + " Not Found!!!</h1>" );
				out.println("</body>");
				out.println("</html>");	
			}
		}else {
			//Invalid Session
			out.println("<html>");
			out.println("<body>");
			out.println("<h1 style='color: red'> Please Login First !!!</h1>" );
			out.println("</body>");
			out.println("</html>");	
			
			req.getRequestDispatcher("./loginForm.html").include(req, resp);
		}
		}//End of doGet()	
		
	}//End of Class

