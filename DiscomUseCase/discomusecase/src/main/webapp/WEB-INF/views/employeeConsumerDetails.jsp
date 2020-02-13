<%@page import="com.bcits.discomusecase.beans.ConsumersMaster"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
    <jsp:include page="empHeader.jsp"></jsp:include>
    <%List<ConsumersMaster> consumersMasterList = (List<ConsumersMaster>)request.getAttribute("consumersMasterList"); %>  
    <spring:url var="css" value="/resources/css"/>
    <spring:url var="js" value="/resources/js"/>
    <spring:url var="images" value="/resources/images"/>
   
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Consumer's Page</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="/fontawesome-free-5.12.0-web/css/all.css">
    <link rel="stylesheet" href="${css}/employeeContent.css">
    
</head>

<body>
    
     <% if(consumersMasterList != null ){ %>
<table border ="1" style='width:70%; margin-left: 200px; margin-top: 200px'>
	     <thead style='background-color: black; color: white'>
	         <tr style="height:35px">
	         <th>RR Number</th>
	         <th>Name</th>
	         <th>Email</th>
	         <th>Phone Number</th>
	         <th>Region</th>
	         <th>Consumer Type</th>
	         <th>Date Of Connection</th>
	         <th>Address1</th>
	         <th>Address2</th>
	         <th>City</th>
	         <th>Meter Number</th>
	         <th>Remove Consumer</th>
	         </tr>
	     </thead>
	     <% for(ConsumersMaster consumersMasterBean
	    		 :consumersMasterList){ %>
	    		 <form action="./deleteConsumer">
	    		 <input name="rrNumber" type="text" value=" <%= consumersMasterBean.getRrNumber() %>" hidden="true">
	      <tr style="height:35px; color:white;">
	        <td  style="height:10px;"><%= consumersMasterBean.getRrNumber() %></td>
	        <td><%= consumersMasterBean.getFirstName() %></td>
	        <td><%= consumersMasterBean.getEmail() %></td>
	        <td><%= consumersMasterBean.getPhnNo() %></td>
	        <td><%= consumersMasterBean.getRegion() %></td>
	         <td><%=consumersMasterBean.getTypeOfConsumer()%></td>
	        <td><%= consumersMasterBean.getDateOfConnection() %></td>
	        <td><%= consumersMasterBean.getAddressLine1() %></td>
	        <td><%= consumersMasterBean.getAddressLine2()%></td>
	        <td><%= consumersMasterBean.getCity() %></td>
	        <td><%= consumersMasterBean.getMeterNumber() %></td>
	        <td> <input type="submit" value="Click to Delete" ></td>
	        </tr>
	        </form>
	<%} 
	}else {%>
	<h2 style="color: red">No Record To Display..</h2>
	<%} %>
    
    <script src="${js}/jquery-3.4.1.js"></script>
	<script src="${js}/bootstrap.min.js"></script>
</body>
</html>