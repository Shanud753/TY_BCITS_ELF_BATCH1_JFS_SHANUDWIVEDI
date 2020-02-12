<%@page import="java.util.List"%>
<%@page import="com.bcits.discomusecase.beans.BillHistory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />
  <jsp:include page="consumerHeader.jsp"></jsp:include>  
    <% List<BillHistory> billHistory =(List<BillHistory>) request.getAttribute("billHistory"); %>
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
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="/fontawesome-free-5.12.0-web/css/all.css">
<link rel="stylesheet" href="${css}/navbar.css">


</head>

<body>
	 <% if(msg != null && !msg.isEmpty()) { %>
	<h1 style="color: green;"><%=msg %></h1>
	<%} %>
	<% if(errMsg != null && !errMsg.isEmpty()) { %>
	<h2 style="color: red;"><%=errMsg %></h2>
	<%} %>
 <% if(billHistory != null && !billHistory.isEmpty()) { %>
  <table border ="1" style='width:70%; margin-left: 200px; margin-top: 200px'>
    <thead style='background-color: navy; color: white'>
    <tr style="height:35px">
    <th>Pay Date</th> 
    <th>Amount</th>
     <th>Status</th>
      <th>Region</th>
    </tr>
    </thead>
    <%for(BillHistory history: billHistory){ %>
    <tr style="height:35px; color:black">
     <td><%=history.getBillHistoryPk().getPayDate() %></td>
    <td><%=history.getBillAmount() %></td>
     <td><%=history.getStatus() %></td>
     <td><%=history.getRegion() %></td>
    </tr>
    <%} %>
  </table>
<%} %>
</body>
</html>