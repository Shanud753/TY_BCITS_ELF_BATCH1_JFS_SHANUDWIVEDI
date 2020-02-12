<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.bcits.discomusecase.beans.ConsumersMaster"%>
<%@page import="com.bcits.discomusecase.beans.CurrentBill"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<% ConsumersMaster masterInfo = (ConsumersMaster)request.getAttribute("loggedInconInfo");
CurrentBill billInfo = (CurrentBill) request.getAttribute("billInfo");
String errMsg = (String) request.getAttribute("errMsg");
%>

<jsp:include page="consumerHeader.jsp"></jsp:include>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Consumer Login</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="/fontawesome-free-5.12.0-web/css/all.css">
    <link rel="stylesheet" href="${css}/currentBill.css">


</head>

<body>

<% if(errMsg != null && !errMsg.isEmpty()) { %>
	<h2 style="color: red;"><%=errMsg %></h2>
	<%} %>

 <div class="col-8" align="center">
  <h3 align="center">ELECTRICITY BILL</h3><br>
  <table style="font-size: 20px">
                <tr>
                    <td><strong>Name</strong></td>
                    <td>: &nbsp;&nbsp;</td>
                    <td><strong><%= masterInfo.getFirstName()+" "+masterInfo.getLastName() %></strong></td>
                </tr>
                <tr>
                    <td><strong>RR Number</strong></td>
                    <td>:</td>
                    <td><strong><%= billInfo.getRrNumber() %></strong></td>
                </tr>
                
                <tr>
                    <td><Strong>Previous Reading</Strong></td>
                    <td>:</td>
                    <td><strong><%=billInfo.getInitialReading() %></strong></td>
                </tr>
                <tr>
                    <td><strong>Presence Reading</strong></td>
                    <td>:</td>
                    <td><strong><%=billInfo.getFinalReading() %></strong></td>
                </tr>
                <tr>
                    <td><strong>Consumption</strong></td>
                    <td>:</td>
                    <td><strong><%=billInfo.getUnitsConsumed() %></strong></td>
                </tr>
                 <tr>
                    <td><strong>Bill Amount</strong></td>
                    <td>:</td>
                    <td><strong><%=billInfo.getBillAmount() %></strong></td>
                </tr>
                 <tr>
                    <td><Strong>Due Date</Strong></td>
                    <td>:</td>
                     
                    <td><% SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy"); %>
                          <strong><%= formatter.format(billInfo.getDueDate()) %></strong></td>
                </tr>
            </table><br>
  	  </div>
  </div>



    <script src="${js}/jquery-3.4.1.js"></script>
    <script src="${js}/bootstrap.min.js"></script>

</body>
</html>