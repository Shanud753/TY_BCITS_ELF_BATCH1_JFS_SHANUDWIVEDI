<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.bcits.discomusecase.beans.CurrentBill"%>
<%@page import="com.bcits.discomusecase.beans.BillHistory"%>
<%@page import="com.bcits.discomusecase.beans.MonthlyConsumption"%>
<%@page import="com.bcits.discomusecase.beans.EmployeeMaster"%>
<%@page import="com.bcits.discomusecase.beans.ConsumersMaster"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <jsp:include page="empHeader.jsp"></jsp:include>
    <% List<BillHistory> billHistroyList = (List<BillHistory>)request.getAttribute("billHistroy"); %>
<% String errMsg =(String) request.getAttribute("errMsg"); %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Consumer Login</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="/fontawesome-free-5.12.0-web/css/all.css">
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

<body>
   
    <% if(errMsg != null && !errMsg.isEmpty()) { %>
<h2 style ="color:white;"><%=errMsg %></h2>
<%} %>
<div class="row" >
		<div class="col-3">
			<br>
			<div class="list-group"
				style="text-align: center; font: bold; font-size: 20px; margin-left: 40px; margin-right:">
				<a href="./" class="list-group-item list-group-item-action active">My
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
					
					<a href="./monthlyrevenue"
					class="list-group-item list-group-item-action">Month On Month Revenue</a>
					
				<a href="./consumerComplaintsDetails"
					class="list-group-item list-group-item-action">Complaints
					Details</a>

			</div>
		</div>
		</div>
<% if(billHistroyList != null && !billHistroyList.isEmpty()){ %>	
       <input class="form-control" id="myInput" type="text" placeholder="Search Month..">
  <br>
	<table class="table" style="color: rgb(23, 32, 42);">
  <thead class="thead-dark">
    <tr>
      <th scope="col">Sl.No</th>
      <th scope="col">RR Number</th>
      <th scope="col">Amount Paid</th> 
      <th scope="col">PaymentDate</th> 
      <th scope="col">Payment Status</th>     
    </tr>
  </thead>
  <tbody id="myTable">
    <%int i=1; 
    for(BillHistory bill : billHistroyList) {%>
    
  	<tr>
      <th scope="row"><%= i %></th>
      <td><strong><%= bill.getBillHistoryPk().getRrNumber()%></strong></td>
      <td><strong><%= bill.getBillAmount()%></strong></td>
      <td><strong> <% SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy"); %>
      <%= formatter.format(bill.getBillHistoryPk().getPayDate()) %></strong></td>
      <td style="color: green;"><strong><%= bill.getStatus()%></strong></td>
    </tr>
    <%  i++ ; } %>
   		</tbody>
	</table>
	<%} else{%>

	<% } %>	
	</div>
		</div>
		</div>
		
		<script src="${js}/bootstrap.min.js"></script>
	<script src="${js}/jquery-3.4.1.js"></script>
</body>
</html>