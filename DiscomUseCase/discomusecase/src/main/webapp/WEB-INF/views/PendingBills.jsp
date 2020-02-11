<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.bcits.discomusecase.beans.MonthlyConsumption"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <% List<MonthlyConsumption> billList = (List<MonthlyConsumption>) request.getAttribute("billList"); %>
<% String errMsg =(String) request.getAttribute("errMsg"); %>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bill Generator</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link href="./resources/fontawesome-free-5.12.0-web/css/all.css "rel="stylesheet" type="text/css">
<link href="${css}/sb-admin-2.min.css" rel="stylesheet">
 <link rel="stylesheet" href="/fontawesome-free-5.12.0-web/css/all.css">
  <link rel="stylesheet" href="${css}/complaint.css">
  
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
<div id="page-content-wrapper bill">
		<div style="margin-left: 40px">
			<br>	
     	
	<% if(billList != null && !billList.isEmpty()){ %>	
  <br>
	<table class="table" style="color: rgb(23, 32, 42);">
  <thead class="thead-dark">
    <tr>
      <th scope="col">Sl.No</th>
      <th scope="col">RR Number</th>
      <th scope="col">Amount Due</th> 
      <th scope="col">Bill Generated Date</th> 
      <th scope="col">Payment Status</th>     
    </tr>
  </thead>
  <tbody id="myTable">
    <%int i=1; 
    for(MonthlyConsumption bill : billList) {
      	Calendar cal = Calendar.getInstance();
      	cal.setTime(new Date());
      	Calendar cal1 = Calendar.getInstance();
      	cal1.setTime(bill.getConsumptionPk().getDate());
      	if(cal.get(Calendar.MONTH) == cal1.get(Calendar.MONTH) && bill.getStatus().equals("Not Paid")){	
    %>
    
  	<tr>
      <th scope="row"><%= i %></th>
      <td><strong><%= bill.getConsumptionPk().getRrNumber()%></strong></td>
      <td><strong><%= bill.getBillAmount() %></strong></td>
      <td><strong> <% SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy"); %>
      <%= formatter.format(bill.getConsumptionPk().getDate()) %></strong></td>
      <td style="color: red;"><strong><%= bill.getStatus()%></strong></td>
    </tr>
    <%  i++ ; } }%>
   		</tbody>
	</table>
	<%} else{%>
	<h3 style="color: navy;"><%=errMsg %></h3>
	<% } %>
	</div>
		</div>
		</div>
   	<script src="${js}/jquery-3.4.1.js"></script>
	<script src="${js}/bootstrap.min.js"></script>
</body>
</html>