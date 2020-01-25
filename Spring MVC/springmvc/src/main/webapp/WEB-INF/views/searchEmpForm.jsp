<%@page import="com.bcits.springmvc.beans.EmployeeInfoBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%EmployeeInfoBean employeeInfoBean = (EmployeeInfoBean) request.getAttribute("employeeInfoBean");
     String errMsg = (String) request.getAttribute("errMsg");
    %>
    <jsp:include page="header.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Management Portal</title>
</head>
<body>
<fieldset>
       <legend>Search Employee</legend>
      <form action="./search">
       <label>Employee Id : </label>
       <input type="text" name="empId" required>
       &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
       <input type="submit" value="Search">
       </form>
   </fieldset><br><br>
   
   <%if(errMsg != null && !errMsg.isEmpty()) {%>
   <h3 style="color:red;"><%=errMsg %></h3>
   <%} %>
   
   <%if(employeeInfoBean != null){%>
   <div align="center">
   <table border="1" style="width:70%">
   <tr style="background: navy; color:white;">
       <th>Employee ID</th>
       <th>Name</th>
        <th>Designation</th>
        <th>Salary</th>
         <th>DOB</th>
        <th>Joining Date</th>
         <th>Mobile</th>
     </tr>
     
      <tr>
      <td><%=employeeInfoBean.getEmpId() %></td>
      <td><%=employeeInfoBean.getEname() %></td>
      <td><%=employeeInfoBean.getDesignation() %></td>
      <td><%=employeeInfoBean.getSalary() %></td>
      <td><%=employeeInfoBean.getDob()%></td>
      <td><%=employeeInfoBean.getDoj() %></td>
      <td><%=employeeInfoBean.getMobileNo()%></td>
      </tr>
   </table>
   </div>
   
 <%}else{ %>
 <h2><%=errMsg %></h2>
 <%} %>
</body>
</html><br><br>

<jsp:include page="footer.jsp"></jsp:include>