<%@page import="java.util.List"%>
<%@page import="com.bcits.discomusecase.beans.BillHistory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />
  <%String msg = (String) request.getAttribute("msg");
  String errMsg = (String) request.getAttribute("errMsg");
  %>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Consumer Login</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="./resources/fontawesome-free-5.12.0-web/css/all.css">
<link rel="stylesheet" href="${css}/password.css">


</head>

<body>
	<header class="header">
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<a class="navbar-brand" href="./homePage"><img
				src="${images}/discomlogo.png" alt="" id="consumerlogo"></a>
			<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
				<div class="navbar-nav">
					<h3 id="h3">Electricity Supply Company Limited</h3>
					<h6 id="h6">CIN - U04010KA2002SGC030438 | GST No -
						29AACCB1412G1Z5</h6>
				</div>

				<div class="homelink " align="right">
			<a style="color: blue;" href="./homePage"><i class="fas fa-home"></i>Home</a> &nbsp; &nbsp; 
		</div>
			</div>
			
		</nav>
	</header>
	
	<% if(msg != null && !msg.isEmpty()) { %>
	<h1 style="color: green;"><%=msg %></h1>
	<%} %>
	<% if(errMsg != null && !errMsg.isEmpty()) { %>
	<h2 style="color: red;"><%=errMsg %></h2>
	<%} %>
	
<fieldset style="width: 500px;">

  <form action="./resetPassword" method="post">
  <h3 id="form">Enter the Password to Change </h3>
  
  <div class="form-group" id="form">
    <label for="exampleInputEmail1">Password</label>
    <input type="text" class="form-control" id="exampleInputEmail1" name="password">
  </div>
  <div class="form-group" id="form">
    <label for="exampleInputPassword1">Confirm Password</label>
    <input type="text" class="form-control" id="exampleInputPassword1" name="confPassword">
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
 </fieldset>
  </div>
  </div>
</body>
</html>