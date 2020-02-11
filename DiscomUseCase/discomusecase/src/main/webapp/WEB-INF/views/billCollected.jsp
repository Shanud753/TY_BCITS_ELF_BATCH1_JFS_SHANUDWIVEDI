<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.bcits.discomusecase.beans.CurrentBill"%>
<%@page import="com.bcits.discomusecase.beans.BillHistory"%>
<%@page import="com.bcits.discomusecase.beans.MonthlyConsumption"%>
<%@page import="com.bcits.discomusecase.beans.EmployeeMaster"%>
<%@page import="com.bcits.discomusecase.beans.ConsumersMaster"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
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
      <link rel="stylesheet" href="${css}/complaint.css">
        <link rel="stylesheet" href="${css}/navbar.css">
     


</head>

<body>
    <header class="header">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="/index"><img src="${images}/discomlogo.png" alt="" id="consumerlogo"></a>
            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                <div class="navbar-nav">
                    <h3 id="h3">Electricity Supply Company Limited
                    </h3>
                    <h6 id="h6">
                        CIN - U04010KA2002SGC030438 | GST No - 29AACCB1412G1Z5 </h6>
                </div>

                <div id="lang">
                    <a href="">English</a>&nbsp; |&nbsp;
                    <a href="">Kannada</a>
                </div>
            </div>
            </div>
        </nav>
    </header>
    <% if(errMsg != null && !errMsg.isEmpty()) { %>
<h2 style ="color:white;"><%=errMsg %></h2>
<%} %>

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
	<h3 style="color: navy;"><%=errMsg %></h3>
	<% } %>	
	</div>
		</div>
		</div>
	<script src="${js}/jquery-3.4.1.js"></script>
</body>
</html>