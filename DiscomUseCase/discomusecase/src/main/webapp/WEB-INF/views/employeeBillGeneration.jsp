<%@page import="com.bcits.discomusecase.beans.ConsumersMaster"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%List<ConsumersMaster> consumersMasterList = (List<ConsumersMaster>)request.getAttribute("consumersMasterList"); %>
 <%String msg = (String) request.getAttribute("msg");
  String errMsg = (String) request.getAttribute("errMsg");
  %>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

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
<link rel="stylesheet" href="${css}/generate.css">

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

	
<!-- Search form -->
<form action="" class="form-inline active-white-4">
  <input class="form-control form-control-sm mr-3 w-75" type="text" placeholder="Search"
    aria-label="Search" id="search">
  <i class="fas fa-search" aria-hidden="true"></i>
</form>

	<% if(consumersMasterList != null ){ %>

	<table border="1"
		style='width: 70%; margin-left: 200px; margin-top: 200px'>
		<thead style='background-color: navy; color: white'>
			<tr style="height: 35px">
				<th>Sl No</th>
				<th>Meter Number</th>
				<th>Name</th>
				<th>Email Id</th>
				<th>Phone Number</th>
				<th>Region</th>
				<th>Consumer Type</th>
				<th>Bill Generation</th>
			</tr>
		</thead>

		<% int i=1;
	     for(ConsumersMaster consumersMasterBean
	    		 :consumersMasterList){  %>
		<form action="./billGeneratePage" method="get">
			<input name="rrNumber" type="number"
				value="<%= consumersMasterBean.getRrNumber()%>" hidden="true">
			<tr style="height: 35px; color: white">
				<td scope="row"><%= i %></td>
				<td><%= consumersMasterBean.getMeterNumber() %></td>
				<td><%= consumersMasterBean.getFirstName() %></td>
				<td><%= consumersMasterBean.getEmail() %></td>
				<td><%= consumersMasterBean.getPhnNo() %></td>
				<td><%= consumersMasterBean.getRegion() %></td>
				<td><%=consumersMasterBean.getTypeOfConsumer() %></td>
				<td><button type="submit">
						<h4 style='color: black'>Click Here To Generated Bill</h4>
					</button></td>
			</tr>
		</form>
		<% i++;} 
	}else {%>
		<h3><%=errMsg %></h3>
		<%} %>

		<script src="${js}/Jquery/jquery-3.4.1.js"></script>
		<script src="${js}/bootstrap-4.4.1-dist/js/bootstrap.min.js"></script>
</body>
</html>