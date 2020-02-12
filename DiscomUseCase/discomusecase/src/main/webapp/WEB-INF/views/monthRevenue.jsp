<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@page import="com.bcits.discomusecase.beans.MonthlyConsumption"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />
<jsp:include page="empHeader.jsp"></jsp:include>
<% List<Object[]> billCollectedList = (List<Object[]>) request.getAttribute("billCollectedList");
List<Object[]> billsPending = (List<Object[]>) request.getAttribute("billsPending");
List<Object[]> totalRevenue = (List<Object[]>) request.getAttribute("totalRevenue");
%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Month Revenue</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="/fontawesome-free-5.12.0-web/css/all.css">
    <link rel="stylesheet" href="${css}/navbar.css">


</head>

<body>
    <%int i=0;
    for(i=0;i<billCollectedList.size();i++) {%>
       <% Object[] collected = billCollectedList.get(i);%>
    <%} %>
    
    
     <%int j=0;
    for(j=0;j<billsPending.size();j++) {%>
       <% Object[] pending = billsPending.get(j);%>
    <%} %>
    
     <%int k=0;
    for(k=0;k<totalRevenue.size();k++) {%>
       <% Object[] totalRevenue1 = totalRevenue.get(i);%>
    <%} %>
    
   <table border ="1" style='width:70%; margin-left: 200px; margin-top: 200px'>
	     <thead style='background-color: navy; color: white'>
	         
	      
	        
	    		 
	      </table>
    <script src="${js}/jquery-3.4.1.js"></script>
    <script src="${js}/bootstrap.min.js"></script>

</body>
</html>