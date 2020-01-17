package com.bcits.empwebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bcits.empwebapp.beans.EmployeePrimaryInfo;
@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int empIdVal = Integer.parseInt(req.getParameter("empId"));
		String password = req.getParameter("password");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("emsPersistenceUnit");
		EntityManager manager = emf.createEntityManager();
		
		String jpql = " from EmployeePrimaryInfo where empId=:empId and password=:pwd ";
		Query query = manager.createQuery(jpql);
		query.setParameter("empId", empIdVal);
		query.setParameter("pwd", password);
		
		EmployeePrimaryInfo employeePrimaryInfo = null;
		try {
			employeePrimaryInfo = (EmployeePrimaryInfo) query.getSingleResult();
		}catch(Exception e) {
			e.printStackTrace();
		}
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		
		if(employeePrimaryInfo != null) {
			//Valid Credentials
			//create the session
			HttpSession session = req.getSession(true);
			session.setMaxInactiveInterval(60);
			session.setAttribute("empInfo", employeePrimaryInfo);
			
			out.println("<h1 style='color: navy'>Welcome  " + employeePrimaryInfo.getEname() + "  :)!! </h1>");
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("./employeeHome.html");
			dispatcher.include(req, resp);
		}else {
			//Invalid Credentials
			out.println("<h1 style='color: red'> Invalid Credentials !!!</h1>");
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("./employeeHome.html");
			dispatcher.include(req, resp);
		}
		out.println("</body>");
		out.println("</html>");
		manager.close();
		emf.close();
	
	}//End of doPost()
	

}//End of Class
