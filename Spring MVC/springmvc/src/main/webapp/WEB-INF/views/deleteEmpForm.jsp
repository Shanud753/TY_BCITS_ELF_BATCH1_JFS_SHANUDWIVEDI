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
<title>Employee Management Portal</title>
</head>
<body>
<fieldset>
       <legend>Delete Employee</legend>
      <form action="./delete">
       <label>Employee Id : </label>
       <input type="text" name="empId" required>
       &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
       <input type="submit" value="Search">
       </form>
   </fieldset>

</body>
</html><br><br>

<% if(msg != null && !msg.isEmpty()) { %>
<h3 style ="color:green;"><%=msg %></h3>
<%} %>
<% if(errMsg != null && !errMsg.isEmpty()) { %>
<h2 style ="color:red;"><%=errMsg %></h2>
<%} %>
<br><br>
 <jsp:include page="footer.jsp"></jsp:include>