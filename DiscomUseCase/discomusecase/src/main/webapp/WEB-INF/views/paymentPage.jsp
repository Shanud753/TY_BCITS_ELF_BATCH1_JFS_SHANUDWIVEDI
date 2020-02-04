<%@page import="com.bcits.discomusecase.beans.CurrentBill"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />
  <%CurrentBill currentBillBean= (CurrentBill)request.getAttribute("currentBillBean"); %>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Consumer Login</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="/fontawesome-free-5.12.0-web/css/all.css">
<link rel="stylesheet" href="${css}/consumerlogin.css">


</head>

<body>
	<header class="header">
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<a class="navbar-brand" href="index.html"><img
				src="${images}/discomlogo.png" alt="" id="consumerlogo"></a>
			<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
				<div class="navbar-nav">
					<h3 id="h3">Electicity Supply Company Limited</h3>
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

	<div class="container">
		<div class="row">
			<div class="col-xs-12 col-md-6 offset-md-4">
				<div class="card " id="card">
					<div class="card-header">
						<div class="row">
							<h3 class="text-xs-center">Payment Details</h3>
							<img class="img-fluid cc-img"
								src="http://www.prepbootstrap.com/Content/images/shared/misc/creditcardicons.png">
						</div>
					</div>
					<div class="card-block">
						<form   action="./successfullPaymentPage"   method="post" role="form">
							<div class="row">
								<div class="col-xs-12">
									<div class="form-group">
										<label>CARD NUMBER</label>
										<div class="input-group">
											<input type="tel" class="form-control"
												placeholder="Valid Card Number"  style="margin-left: 20px; "/> <span
												class="input-group-addon"><span
												class="fa fa-credit-card"></span></span>
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-7 col-md-7">
									<div class="form-group">
										<label><span class="hidden-xs">EXPIRATION</span><span
											class="visible-xs-inline">EXP</span> DATE</label> <input type="tel"
											class="form-control" placeholder="MM / YY" />
									</div>
								</div>
								<div class="col-xs-5 col-md-5 float-xs-right">
									<div class="form-group">
										<label>CV CODE</label> <input type="tel" class="form-control"
											placeholder="CVC" />
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-12">
									<div class="form-group">
										<label>CARD OWNER</label> <input type="text"
											class="form-control" placeholder="Card Owner Names" />
									</div>
								</div>
							</div>
						
					</div>
					<div class="card-footer">
						<div class="row">
							<div class="col-xs-12">
								<button class="btn btn-warning btn-lg btn-block">Process
									payment</button>
							</div>
						</div>
						<div class="row">
							<div class="col-xs-12">
								<label>Amount</label> <input type="text"
										
                         	class="form-control" placeholder="Bill Amount"  value="<%= currentBillBean.getAmount() %>"/>
							</div>
						</div>
					</div>
					</form>
			
		</div>
	</div>

	<style>
.cc-img {
	margin: 0 auto;
}
</style>
</body>
</html>