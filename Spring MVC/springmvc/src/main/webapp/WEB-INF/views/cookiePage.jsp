<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% String msg = (String) request.getAttribute("msg"); %>
    <% String errMsg = (String) request.getAttribute("errMsg"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CookiePage</title>
</head>
<body>
 <a href="./createCookie">Click Here</a> To Create Cookie..<br> 
 <a href="./readCookie">Click Here</a> To Read Cookie..
 
 <% if(msg != null && !msg.isEmpty()){ %>
      <h2 style="color:green;"><%=msg %></h2>
 <%} %>
 
  <% if(errMsg != null && !errMsg.isEmpty()){ %>
      <h2 style="color:red;"><%=errMsg %></h2>
 <%} %>
 
</body>
</html>