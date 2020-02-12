<%@page import="com.bcits.discomusecase.beans.SupportCustBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />
<jsp:include page="consumerHeader.jsp"></jsp:include>
<% String msg = (String) request.getAttribute("msg"); 

  String errMsg = (String) request.getAttribute("errMsg");
  %>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Employee Help</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="/fontawesome-free-5.12.0-web/css/all.css">



</head>

<body>
<% if(msg != null && !msg.isEmpty()) { %>
	<h1 style="color: green;"><%=msg %></h1>
	<%} %>
	<% if(errMsg != null && !errMsg.isEmpty()) { %>
	<h2 style="color: red;"><%=errMsg %></h2>
	<%} %>
	
	<div class="container-fluid bg">
		<div class="row">
			<div class="col-md-4 col-sm-4 col-xs-12"></div>
			<div class="col-md-4 col-sm-4 col-xs-12">
				<form action="./getQueryInfo" method="post">
					<h3 style="color: black">Consumer Help</h3>
					<img class="img rounded-circle " src="${images}/help.png">
					<div>
						<label style="color: black">Complaint textarea</label>
						<textarea rows="5" cols="50" name="request"
							placeholder="Enter text here..."></textarea>
					</div>
					<div>
						<button type="submit" class="btn btn-success">Send</button>
					</div>
			</div>
			</form>
		</div>
		<div class="col-md-4 col-sm-4 col-xs-12"></div>
	</div>

	</div>
	</form>
</body>
</html>