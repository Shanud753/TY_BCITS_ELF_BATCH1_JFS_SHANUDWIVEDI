<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% int empId = (Integer) request.getAttribute("empId");
    String password =(String) request.getAttribute("password");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <h5> User Id =<%=empId%></h5>
 <h5> Password =<%=password%></h5>
</body>
</html>