<%@page import="com.bcits.discomusecase.beans.EmployeeMaster"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
   <spring:url var="css" value="/resources/css" />
    <spring:url var="js" value="/resources/js" />
    <spring:url var="images" value="/resources/images" />
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

<style type="text/css">

body{
background-image: url(${images}/Lighting-lamps.jpg);
background-position: center;
background-size: cover;
width:100%;
height:600px;"
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
#pageContent{

}
</style>
</head>

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
						href="./employeeLogout" ><i class="fas fa-sign-out-alt"></i>Logout</a>
					&nbsp; &nbsp;
				</div>
			</div>

		</nav>
	</header>
	

<div class="row" >
		<div class="col-3">
			<br>
			<div class="list-group"
				style="text-align: center; font: bold; font-size: 20px; margin-left: 40px; margin-right:">
				<a href="./employeeContent" class="list-group-item list-group-item-action active">My
					Account</a> 
					
					<a href="./getAllConsumer"
					class="list-group-item list-group-item-action ">Consumer Details</a> 
					<a
					href="./billGeneration"
					class="list-group-item list-group-item-action"> Months Bill Generation</a>
					
					 <a href="./BillCollected"
					class="list-group-item list-group-item-action">Month Bill Collection</a>
					
					 <a href="./billPending"
					class="list-group-item list-group-item-action">Bills Pending</a>
					
					<a href="./"
					class="list-group-item list-group-item-action">Month On Month Revenue</a>
					
				<a href="./consumerComplaintsDetails"
					class="list-group-item list-group-item-action">Complaints
					Details</a>

			</div>
		</div>
		</div>
    
</body>
</html>