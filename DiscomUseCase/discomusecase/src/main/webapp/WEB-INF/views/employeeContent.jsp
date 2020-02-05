<%@page import="com.bcits.discomusecase.beans.EmployeeMaster"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
   <spring:url var="css" value="/resources/css" />
    <spring:url var="js" value="/resources/js" />
    <spring:url var="images" value="/resources/images" />
    
    <% EmployeeMaster master = (EmployeeMaster) session.getAttribute("loggedInEmp"); %>
    <% int count = (int) request.getAttribute("count"); %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Employee's Page</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="/fontawesome-free-5.12.0-web/css/all.css">
    <link rel="stylesheet" href="${css}/employeeContent.css">
    
</head>

<body>
    <header class="header">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="/index.html"><img src="${images}/discomlogo.png" alt="" id="consumerlogo"></a>
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

    <div class="list-group" id="list">
        <a href="./billGeneration"><button type="button" class="list-group-item list-group-item-action active">Months Bill Generation</button></a>
        <a href=""><button type="button" class="list-group-item list-group-item-action">Month Bill Collection</button></a>
        <a href=""><button type="button" class="list-group-item list-group-item-action">Bill History</button></a>
       <a href="./getAllConsumer"> <button type="button" class="list-group-item list-group-item-action">Consumer Details</button></a>
        <a href=""><button type="button" class="list-group-item list-group-item-action" >Month on Month revenue</button></a>
        <a href="./employeeLogout"><button type="button" class="list-group-item list-group-item-action" >Logout</button></a>
    </div>
    
  <div class="card"  id="card">
        <div class="card-body">
            <h5 class="card-title" style="color: white;">Employee Details</h5>
            <h6 class="card-subtitle mb-2 text-muted"style="color:white" > Meter Number:<%=master.getDesignation() %> </h6>
            <p id="card-text" style="color:white">Employee  Id:            <%=master.getEmpId() %></p>
            <p id="card-text" style="color:white">Employee  Name:          <%=master.getEmpName() %></p>
            <p id="card-text" style="color:white">Region:            <%=master.getRegion() %></p>
            <p id="card-text" style="color:white">No Of Consumers:            <%=count %></p>
            <a href="./homePage" class="card-link">Home Page</a>
        </div>
    </div>

    <script src="/jquery-3.4.1.js"></script>
    <script src="/bootstrap.min.js"></script>
</body>

</html>