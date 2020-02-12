<%@page import="java.util.List"%>
<%@page import="com.bcits.discomusecase.beans.MonthlyConsumption"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />
<jsp:include page="consumerHeader.jsp"></jsp:include>
<% List<MonthlyConsumption> consumptionList = (List<MonthlyConsumption>) request.getAttribute("monthlyConsumption");%>
 <%String msg = (String) request.getAttribute("msg");
  String errMsg = (String) request.getAttribute("errMsg");
  %>

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
<% if(msg != null && !msg.isEmpty()) { %>
	<h1 style="color: orange;"><%=msg %></h1>
	<%} %>
	<% if(errMsg != null && !errMsg.isEmpty()) { %>
	<h2 style="color: red;"><%=errMsg %></h2>
	<%} %>
<body style="background-color: #021f31;">
    <%if(consumptionList != null && !consumptionList.isEmpty()){ %>
    
   <table border ="1" style='width:70%; margin-left: 200px; margin-top: 200px'>
	     <thead style='background-color: ; color: white'>
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
	      <%}%>
	      
    <script src="${js}/jquery-3.4.1.js"></script>
    <script src="${js}/bootstrap.min.js"></script>

</body>
</html>