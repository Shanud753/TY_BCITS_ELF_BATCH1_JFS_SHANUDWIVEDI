<%@page import="com.bcits.discomusecase.beans.ConsumersMaster"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<%ConsumersMaster conMaster = (ConsumersMaster) session.getAttribute("loggedInconInfo");%>

  <%String msg = (String) request.getAttribute("msg");
  String errMsg = (String) request.getAttribute("errMsg");
  %>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Consumer's Page</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="./resources/fontawesome-free-5.12.0-web/css/all.css">
<link rel="stylesheet" href="${css}/consumerContent.css">

<style type="text/css">

body{
background-image: url(${images}/Lighting-lamps.jpg);
background-position: center;
background-size: cover;
}

nav.navbar {
	width: 1600px;
	height: 110px;
}

#h3 {
	padding-left: 21px;
	padding-bottom: 70px;
	padding-top: 20px;
}

#h6 {
	padding-top: 62px;
	padding-right: 598px;
	padding-left: 575px;
	margin-left: -1010px;
}

#consumerlogo {
	width: 140px;
	height: 130px;
	margin-left: -10px;
	margin-top: -30px;
}

table {
	font-size: 20px;
	margin-left: 440px;
	margin-top: -400px;
}
</style>
</head>
<% if(msg != null && !msg.isEmpty()) { %>
	<h1 style="color: green;"><%=msg %></h1>
	<%} %>
	<% if(errMsg != null && !errMsg.isEmpty()) { %>
	<h2 style="color: red;"><%=errMsg %></h2>
	<%} %>
<body style="background-color: #d9f7f7;">
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

				<div class="links"
					style="padding-left: 100px; margin-top: 39px; font-size: 22px;">
					<!-- <a style="color: blue;" href="./homePage"><i
						class="fas fa-home"></i>Home</a>  -->
						
						<a style="color: blue; margin-left: 20px;"
						href="./ConsumerLogout" ><i class="fas fa-sign-out-alt"></i>Logout</a>
					&nbsp; &nbsp;
				</div>
			</div>

		</nav>
	</header>

	<br>
	<div class="row" >
		<div class="col-3">
			<br>
			<div class="list-group"
				style="text-align: center; font: bold; font-size: 20px; margin-left: 40px; margin-right:">
				<a href="./consumerContentPage" class="list-group-item list-group-item-action active">My
					Account</a> <a href="./currentBill"
					class="list-group-item list-group-item-action ">Current Bill</a> <a
					href="./electricityConsumption"
					class="list-group-item list-group-item-action"> Electricity
					Consumption</a> <a href="./displayBillHistorysPage"
					class="list-group-item list-group-item-action">Bill History</a> <a
					href="./payment" class="list-group-item list-group-item-action">Pay
					Online</a> <a href="./displayForgotPasswordPage"
					class="list-group-item list-group-item-action">Change Password</a>
				<a href="./consumerComplaintResolvedDetails"
					class="list-group-item list-group-item-action">Complaints
					Details</a>

			</div>
		</div>
		</div>
		<div class="col-8" align="center">
			<div class="consumerDetails">
				<br>
				<table >
					<tr>
						<td><strong><u>Consumer Details</u></strong></td>
					</tr>
					<tr>
						<td><strong>Name</strong></td>
						<td>: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
						<td><strong><%= conMaster.getFirstName()+" "+conMaster.getLastName() %></strong></td>
					</tr>
					<tr>
						<td><strong>RR Number</strong></td>
						<td>:</td>
						<td><strong><%= conMaster.getRrNumber() %></strong></td>
					</tr>
					<tr>
						<td><Strong>PhoneNumber</Strong></td>
						<td>:</td>
						<td><strong><%= conMaster.getPhnNo() %></strong></td>
					</tr>
					<tr>
						<td><strong>Email</strong></td>
						<td>:</td>
						<td><strong><%= conMaster.getEmail() %></strong></td>
					</tr>
					<tr>
						<td><Strong>Region</Strong></td>
						<td>:</td>
						<td><strong><%= conMaster.getRegion()%></strong></td>
					</tr>
					<tr>
						<td><strong>Type Of Consumer</strong></td>
						<td>:</td>
						<td><strong><%= conMaster.getTypeOfConsumer() %></strong></td>
					</tr>
					<tr>
						<td><strong>Address</strong></td>
						<td>:</td>
						<td><strong><%= conMaster.getAddressLine1()+ "" +conMaster.getAddressLine2() %></strong></td>
					</tr>
					<tr>
						<td><strong> <a href="./queryPage" class="card-link">HelpLine</a></strong></td>
					</tr>
				</table>
			</div>
			<script src="${js}/jquery-3.4.1.js"></script>
			<script src="${js}/bootstrap.min.js"></script>
</body>
</html>