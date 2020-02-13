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
    <div class=" col-8 col-sm-8 col-md-8 col-lg-8 col-xl-8 " style="margin-top: 100px;margin-left: 260px">
		 <legend><h4 style="padding-top: 2mm;padding-bottom:2mm;font-size: larger;text-align: center;">Monthly Revenue</h4></legend>
         <table class="table table-bordered table-info mt-2" style="border-style: solid; background-color: #a4c7dd;">
            <thead>
              <tr >    
               
                <th scope="col">Date</th>    
                <th scope="col">TotalRevenue</th> 
                <th scope="col" >Collected Amount</th> 
                <th scope="col">Pending</th> 
              </tr>
            </thead>
		<tbody>
		<% double totalRevenue = 0.0;
		
		for( int i=0 ;i<billCollectedList.size();i++) {
			Object[] collectedBills = billCollectedList.get(i);
		      for( int j=0 ;j<billsPending.size();j++) {
			      Object[] pendingBills = billsPending.get(j);
	 			if(pendingBills[1].equals(collectedBills[1])){
	 				totalRevenue = (double)collectedBills[0]+(double)pendingBills[0];
	 				%>
	 				<tr >
	 				  <td ><%=collectedBills[1]%></td>
	 				  <td ><%=totalRevenue %></td>
	 				  <td ><%=collectedBills[0]%></td>
	 				  <td ><%=pendingBills[0] %></td>
	 				</tr> 
	 			<%}    
		 }
	  } 
   
		
		 Object[] collectedBills = null;
		
		 for( int i=0 ;i<billCollectedList.size();i++)   {
		boolean isPresent = false; 
		collectedBills = billCollectedList.get(i);	
			  Object[] pendingBills=null;
			for( int j=0 ; j <billsPending.size();j++){
				pendingBills  = billsPending.get(j);
	 			if(pendingBills[1].equals(collectedBills[1])){
	 				isPresent = true;
					break;
	 			}	
	 			
		 }
			if(!isPresent){	%>
			<tr >
		       <td><%=collectedBills[1] %></td>
		       <td><%=collectedBills[0] %></td>
			   <td><%=0.0 %></td>
			    <td><%=collectedBills[0] %></td>
			   
		</tr> 
		<%}    
		      		
		}
		 
		for( int i=0 ;i<billsPending.size();i++) {
			Object[] pendingBills = billsPending.get(i);
			collectedBills = null;
        boolean isPresent = false;
		      for( int j=0 ; j<billCollectedList.size();j++) {
		    	  collectedBills  = billCollectedList.get(j);
	 			
		    	  if(collectedBills[1].equals(pendingBills[1])){
		    		  isPresent = true;
					break;
	 			}
	 			
		 }
		      if(!isPresent){	%>
				<tr >
			       <td><%=pendingBills[1] %></td>
			       <td><%=pendingBills[0] %></td>
			       <td><%=0.0%></td>
				   <td><%=pendingBills[0] %></td>
			</tr> 
			<%} 		      	
		}
	%>
			</tbody>
			</table>
		 </div>
	
    


   <script src="${js}/jquery-3.2.1.min.js"></script> 
 
</body>
</html>