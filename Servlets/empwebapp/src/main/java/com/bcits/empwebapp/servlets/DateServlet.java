package com.bcits.empwebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DateServlet extends HttpServlet {
	
	 public DateServlet() {
		System.out.println("Its Instantiation Phase");
	}
	 
	 @Override
	public void init() throws ServletException {
	   System.out.println("Its Initialization Phase");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Java code to generate current system date and time (dynamic)
		Date date = new Date();
		
		ServletConfig config = getServletConfig();
		String myConfigParamVal = config.getInitParameter("servletName");
		
		ServletContext context = getServletContext();
		
		String myContextParamVal = context.getInitParameter("appName");
		//code to generate dynamic response
		resp.setContentType("text/html"); //what type of content it is going to recieve
		resp.setHeader("refresh", "1");
		
		System.out.println("Its Request Phase");
		
		PrintWriter out = resp.getWriter();
		out.println("<html>");      //we can write any Html Content
		out.println("<body>");
		out.println("<h1>Current System Date & Time is:-" + date + "</h1>");
		out.println("<h2> Servlet Name = " +myConfigParamVal );
		out.println("<h2> Application Name = " +myContextParamVal );
		out.println("</body>");
		out.println("</html>");
		
	}//End of doGet()

	@Override
	public void destroy() {
		System.out.println("Its Destroy Phase");
	}
}//End of Class
