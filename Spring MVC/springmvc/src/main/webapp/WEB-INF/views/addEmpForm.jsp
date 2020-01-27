<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   <%String msg = (String) request.getAttribute("msg");
  String errMsg = (String) request.getAttribute("errMsg");
  %>
  
   <jsp:include page="header.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<fieldset>
       <legend>Add Employee</legend>
     <form action="./addEmployee" method="post">
       
        <label>Employee Id : </label><br>
       <input type="number" name="empId" required>
       &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<br><br>
       
        <label>Employee Name : </label><br>
       <input type="text" name="ename" required>
       &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<br><br>
       
        <label>Employee Mobile No  : </label><br>
        <input type="number" name="mobileNo" required>
       &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<br><br>
        
        <label>Official Mail Id  : </label><br>
        <input type="email" name="officialMailid" required>
       &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<br><br>
       
         <label> Date of Birth  : </label><br>
        <input type="Date" name="dob" required>
       &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<br><br>
       
        <label> Date of Joining  : </label><br>
        <input type="Date" name="doj" required>
       &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<br><br>
       
        <label>Employee Designation  : </label><br>
        <input type="text" name="designation" required>
       &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<br><br>
       
       
        <label>Blood Group : </label><br>
        <input type="text" name="bldGrp" required>
     
       &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<br><br>
       
        <label>Employee Salary  : </label><br>
        <input type="number" name="salary" required>
       &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<br><br>
       
        <label>Department Id : </label><br>
       <input type="number" name="depId" required>
       &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<br><br>
       
         <label>Manager Id : </label><br>
       <input type="number" name="mrgId" required>
       &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<br><br>
       
  
        <label>Employee Password  : </label><br>
        <input type="password" name="password" required>
       &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<br><br>
       
       <label>Confirm Password  : </label><br>
        <input type="password" name="cnfpassword" required>
       &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<br><br>
       
       <input type="submit" value="Add">
       </form>
   </fieldset>
</body>
</html>

<% if(msg != null && !msg.isEmpty()) { %>
<h3 style ="color:green;"><%=msg %></h3>
<%} %>
<% if(errMsg != null && !errMsg.isEmpty()) { %>
<h2 style ="color:red;"><%=errMsg %></h2>
<%} %>
<br><br>

 <jsp:include page="footer.jsp"></jsp:include>