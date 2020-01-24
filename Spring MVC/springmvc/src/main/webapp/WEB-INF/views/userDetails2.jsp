<%@page import="com.bcits.springmvc.beans.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <% UserBean userBean = (UserBean) request.getAttribute("userBean");
      String name = (String) request.getAttribute("name");
      %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <h5> User Id =<%=userBean.getEmpId()%></h5>
 <h5> Password =<%=userBean.getPassword()%></h5>
 <h5> Name =<%=name%></h5>
</body>
</html>