<%@page import="com.bcits.springsecuritymvc.beans.EmpInfoBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:include page="header.jsp" />
    <%EmpInfoBean infoBean = (EmpInfoBean) request.getAttribute("empInfoBean"); %>
<!DOCTYPE html>
<html>
<body>
 <div align="center">
 <fieldset>
 <legend>Search Employee</legend>
 <form action="./getEmployee">
 Employee ID : <input type="text" name="empId" required="required">
 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
 <input type="submit" value="search">
 </form>
 </fieldset>
 
  <%if(infoBean != null){ %>
 <table>
 <thead>
 <tr style="background: navy; color: white" >
 <th>Employee ID</th>
 <th>Employee Name</th>
 <th>Password</th>
 <th>Role</th>
 </tr>
 <tbody>
 <tr>
 <td><%= infoBean.getEmpId()%></td>
 <td><%= infoBean.getName()%></td>
 <td><%= infoBean.getPassword()%></td>
 <td><%= infoBean.getRole()%></td>
 </tr>
 </tbody>
 </thead>
 </table>
 <%}else{ %>
 <h3 style="color: red;">Employee ID Not Found</h3>
 <%} %>
 
 </div>

</body>
</html>