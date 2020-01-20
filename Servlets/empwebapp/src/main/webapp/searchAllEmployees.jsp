<%@page import="java.util.List"%>
<%@page import="com.bcits.empwebapp.beans.EmployeePrimaryInfo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% List<EmployeePrimaryInfo> employeesList = (List<EmployeePrimaryInfo>) request.getAttribute("employeesList"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <% if(employeesList!=null) {%>
       <table border="1" style="width:80%;">
       <thead style="background:navy;color:white;">
         <tr style="height:35px">
         <th> EmpId</th>
         <th> Name</th>
         <th> Salary</th>
         <th> Designation</th>
         <th> DOB</th>
         <th> DOJ </th>
         <th> Mobile </th>
         </tr>
       </thead>
       
       <tbody>
       <% for(EmployeePrimaryInfo empInfo:employeesList){ %>
           <tr>
           <td><%= empInfo.getEmpId()%></td>
            <td><%= empInfo.getEname()%></td>
            <td><%= empInfo.getSalary()%></td>
            <td><%= empInfo.getDesignation()%></td>
            <td><%= empInfo.getDob()%></td>
            <td><%= empInfo.getDoj()%></td>
            <td><%= empInfo.getMobileNo()%></td>
           </tr>
       <%} %>
       </tbody>
       </table>
   <%} else{ %>
      <h2 style='color:red'>Employee ID Not Found!!</h2>
   <%} %>
</body>
</html>