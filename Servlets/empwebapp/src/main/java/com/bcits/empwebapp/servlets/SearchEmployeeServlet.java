package com.bcits.empwebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchEmployeeServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	String empIdVal = req.getParameter("empId");
	
	ServletConfig config = getServletConfig();
	String myConfigParamVal = config.getInitParameter("servletName");
	
	ServletContext context = getServletContext();
	String myContextParamVal = context.getInitParameter("appName");
	
	resp.setContentType("text/html");
	
	PrintWriter out = resp.getWriter();
	out.print("<html>");
	out.print("<body>");
	out.print("<h1> Emp ID = " + empIdVal + "</h1>");
	out.print("Emp Name = Sargun <br>");
	out.print("Salary = 100000 /-  <br>");
	out.print("Designation = SD  <br>");
	out.println("<h2> Servlet Name = " +myConfigParamVal );
	out.println("<h2> Application Name = " +myContextParamVal );
	out.print("</body>");
	out.print("</html>");
	}//End of doGet()

}//End of Class
