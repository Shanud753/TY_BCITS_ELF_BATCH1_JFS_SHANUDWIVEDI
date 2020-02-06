<%@page import="com.bcits.springsecuritymvc.beans.EmpInfoBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <jsp:include page="header.jsp" />
    <%List<EmpInfoBean>  employeeList  = (List<EmpInfoBean>) request.getAttribute("employeesList"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Spring Web Security - See All Employees</title>
</head>
<body>
<div align="center">
<%if(employeeList != null){ %>
 <table>
 <thead>
 <tr style="background: navy; color:white; height:35px;">
 <th>Employee ID</th>
 <th>Employee Name</th>
 <th>Password</th>
 <th>Role</th>
 </tr>
 </thead>
 <tbody>
 <%for(EmpInfoBean empInfo:employeeList) {%>
 <tr style="height:35px">
 <td><%= empInfo.getEmpId()%></td>
 <td><%= empInfo.getName()%></td>
 <td><%= empInfo.getPassword()%></td>
 <td><%= empInfo.getRole()%></td>
 </tr>
  <%} %>
 </tbody>
 </table>
 <%} else{ %>
<h3 style="color: red;">No Records to Display...</h3>
<%} %>
</div>
</body>
</html>