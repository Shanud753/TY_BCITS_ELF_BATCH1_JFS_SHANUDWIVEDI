<%@page import="java.util.List"%>
<%@page import="com.bcits.discomusecase.beans.MonthlyConsumption"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<% List<MonthlyConsumption> consumptionList = (List<MonthlyConsumption>) request.getAttribute("monthlyConsumption");%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Consumer Login</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="/fontawesome-free-5.12.0-web/css/all.css">
    <link rel="stylesheet" href="${css}/navbar.css">


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

                <div id="lang">
                    <a href="">English</a>&nbsp; |&nbsp;
                    <a href="">Kannada</a>
                </div>
            </div>
        </nav>
    </header>
   <table border ="1" style='width:70%; margin-left: 200px; margin-top: 200px'>
	     <thead style='background-color: navy; color: white'>
	         <tr style="height:35px">
	          <th>RR Number</th>
	         <th>Date</th>
	         <th>BillAmount</th>
	         <th>Initial Reading</th>
	          <th>Final Reading</th>
	          <th>Consumption</th>
	         </tr>
	     </thead>
	      
	     <% for(MonthlyConsumption list
	    		 :consumptionList){  %>
	      <tr style="height:35px; color:black">
	        <td><%= list.getConsumptionPk().getRrNumber() %></td>
	        <td><%= list.getConsumptionPk().getDate() %></td>
	        <td><%= list.getBillAmount() %></td>
	        <td><%= list.getInitialReading() %></td>
	         <td><%= list.getFinalReading()%></td>
	         <td><%= list.getUnitsConsumed()%></td>
	        </tr>
	        <%} %>
	      </table>
    <script src="${js}/jquery-3.4.1.js"></script>
    <script src="${js}/bootstrap.min.js"></script>

</body>
</html>