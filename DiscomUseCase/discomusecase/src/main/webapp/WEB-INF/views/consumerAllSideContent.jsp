<%@page import="com.bcits.discomusecase.beans.ConsumersMaster"%>
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
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="/fontawesome-free-5.12.0-web/css/all.css">
    <link rel="stylesheet" href="${css}/consumerContent.css">
    
    
</head>

<body>
    <header class="header">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="./homePage"><img src="${images}/discomlogo.png" alt="" id="consumerlogo"></a>
            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                <div class="navbar-nav">
                    <h3 id="h3">Electricity Supply Company Limited
                    </h3>
                    <h6 id="h6">
                        CIN - U04010KA2002SGC030438 | GST No - 29AACCB1412G1Z5 </h6>
                </div>

                <div class="homelink ">
			<a style="color: white;" href="./consumerContent"><i class="fas fa-home"></i>Home</a>  
		<a style="color: blue;" href="./consumerLogout"><i class="fas fa-sign-out-alt"></i>SignOut</a> &nbsp; &nbsp; 
		</div>
            </div>
           
        </nav>
    </header>
    
    <br>
<div class="welcome" ><br>
	<h3 style="margin-top: -10px">Welcome To DISCOM Electricity Limited</h3><br>
</div>
<div class="row" >
  <div class="col-3" ><br>
   <div class="list-group" style="text-align: center;font: bold;font-size: 20px;margin-left: 40px;margin-right: ">
  <a href="./" class="list-group-item list-group-item-action active">My Account</a>
  <a href="./currentBill" class="list-group-item list-group-item-action " >Current Bill</a>
  <a href="./electricityConsumption" class="list-group-item list-group-item-action"> Electricity Consumption</a>
  <a href="./displayBillHistorysPage" class="list-group-item list-group-item-action">Bill History</a>
  <a href="./payment" class="list-group-item list-group-item-action">Pay Online</a>
  <a href="./displayForgotPasswordPage" class="list-group-item list-group-item-action">Change Password</a>
  <a href="./consumerComplaintResolvedDetails" class="list-group-item list-group-item-action">Complaints Details</a>
  
</div>
  </div>
 </div> 
  <script src="${js}/jquery-3.4.1.js"></script>
    <script src="${js}/bootstrap.min.js"></script>
</body>
</html>