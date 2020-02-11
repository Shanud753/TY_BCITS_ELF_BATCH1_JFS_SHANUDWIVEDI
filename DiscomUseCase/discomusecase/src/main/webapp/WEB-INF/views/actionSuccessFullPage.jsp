<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

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
<title>Employee's Page</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="/fontawesome-free-5.12.0-web/css/all.css">
<link rel="stylesheet" href="${css}/navbar.css">


</head>

<body>
	<header class="header">
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<a class="navbar-brand" href="/index.html"><img
				src="${images}/discomlogo.png" alt="" id="consumerlogo"></a>
			<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
				<div class="navbar-nav">
					<h3 id="h3">Electricity Supply Company Limited</h3>
					<h6 id="h6">CIN - U04010KA2002SGC030438 | GST No -
						29AACCB1412G1Z5</h6>
				</div>

				<div id="lang">
					<a href="">English</a>&nbsp; |&nbsp; <a href="">Kannada</a>
				</div>
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
	
		<script src="/Jquery/jquery-3.4.1.js"></script>
		<script src="/bootstrap-4.4.1-dist/js/bootstrap.min.js"></script>
</body>
</html>