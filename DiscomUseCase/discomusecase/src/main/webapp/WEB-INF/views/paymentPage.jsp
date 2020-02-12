<%@page import="com.bcits.discomusecase.beans.CurrentBill"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="html" value="/resources/html" />
<spring:url var="images" value="/resources/images" />
<jsp:include page="consumerHeader.jsp"></jsp:include>
  <%CurrentBill currentBillBean= (CurrentBill)request.getAttribute("currentBillBean");
  String errMsg = (String) request.getAttribute("errMsg");
  %>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Payment Page</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="./resources/fontawesome-free-5.12.0-web/css/all.css">
<link rel="stylesheet" href="${css}/payment.css">


</head>

<body>
<% if(errMsg != null && !errMsg.isEmpty()) { %>
	<h2 style="color: red;"><%=errMsg %></h2>
	<%} %>
	<div class="container">
		<div class="row">
			<div class="col-xs-12 col-md-6 offset-md-4">
				<div class="card " id="card">
					<div class="card-header">
						<div class="row">
							<h3 class="text-xs-center">Payment GateWay</h3>
							<img class="img-fluid cc-img"
								src="http://www.prepbootstrap.com/Content/images/shared/misc/creditcardicons.png">
						</div>
					</div>
					<div class="card-block">
						<form   action="./successfullPaymentPage" onsubmit="validation(); return false "  method="post" role="form">
							<div class="row">
								<div class="col-xs-12">
									<div class="form-group" id="cardNumber">
										<label style="margin-left: 16px;">CARD NUMBER</label>
										<div class="input-group">
											<input type="tel" class="form-control"
												placeholder="Valid Card Number"  style="margin-left: 20px; "/> 
												<span id="cdNum" style="color: red;"></span>
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
												<span id="expdate" style="color: red;"></span>
									</div>
								</div>
								<div class="col-xs-5 col-md-5 float-xs-right">
									<div class="form-group">
										<label>CV CODE</label> <input type="tel" class="form-control"
											placeholder="CVC" />
											<span id="cv" style="color: red;"></span>
									</div>
								</div>
								
							</div>
							<div class="row">
								<div class="col-xs-12">
									<div class="form-group" id="owner">
										<label>CARD OWNER</label> <input type="text"
											class="form-control" placeholder="Card Owner Names" />
											<span id="fname" style="color: red;"></span>
									</div>
								</div>
								
							</div>
						<div class="row">
							<div class="col-xs-12" id="amount">
								<label>AMOUNT</label> <input type="number"		
                         	class="form-control"  value="<%= currentBillBean.getBillAmount() %>" readonly="readonly" style="background-color: white;"/>
							</div>
						</div>
					</div>
					<div class="card-footer">
						<div class="row">
							<div class="col-xs-12">
								<button class="btn btn-warning btn-lg btn-block" id="payButton">Process
									payment</button>
							</div>
						</div>
	
				</form>
		</div>
	</div>
	</div>

	<style>
.cc-img {
	margin: 0 auto;
}
</style>
   <script src="${js}/jquery-3.4.1.js"></script>
	<script src="${js}/bootstrap.min.js"></script>
	<script src="${js}/payment.js"></script>
</body>
</html>