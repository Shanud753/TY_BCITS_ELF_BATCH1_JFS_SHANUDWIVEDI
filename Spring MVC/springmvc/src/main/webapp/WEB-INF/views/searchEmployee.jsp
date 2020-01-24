<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	String empId = (String) request.getAttribute("empId");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>
		Employee <%=empId%> Details
	</h1>
	 Name = Shwetha
	<br> Designation = SD
	<br> Mobile = 8475769389
</body>
</html>