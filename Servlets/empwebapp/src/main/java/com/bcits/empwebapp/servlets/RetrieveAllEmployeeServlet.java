package com.bcits.empwebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bcits.empwebapp.beans.EmployeePrimaryInfo;

@WebServlet("/retrieveEmployee")
public class RetrieveAllEmployeeServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Get the Form Data

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("emsPersistenceUnit");
		EntityManager manager = emf.createEntityManager();
		Query query = manager.createQuery(" from EmployeePrimaryInfo ");
		List<EmployeePrimaryInfo> info = query.getResultList();
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		//Get the Form Data

		if (info != null) {
			for (EmployeePrimaryInfo employeePrimaryInfo : info) {
				//Display Employee Record
				out.print("<html>");
				out.println("<body");
				out.println("Employee ID      : "+employeePrimaryInfo.getEmpId());
				out.println("<br>Name             : "+employeePrimaryInfo.getEname());
				out.println("<br>Date Of Birth: "+employeePrimaryInfo.getDob());
				out.println("<br>Designation  : "+employeePrimaryInfo.getDesignation());
				out.println("<br>Salary       : "+employeePrimaryInfo.getSalary());
				out.println("<br>Mobile no    : "+employeePrimaryInfo.getMobileNo()+"<br><br>");
				out.println("</body");
				out.println("</html>");
			}
		}else {
			//display empId not Found
			out.println("<h1 style ='color:red;'>No Employee Record id Found. </h1>");
		}

		manager.clear();
		emf.close();
	}
}
