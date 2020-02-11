<%@page import="com.bcits.discomusecase.beans.ConsumersMaster"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
   <spring:url var="css" value="/resources/css" />
    <spring:url var="js" value="/resources/js" />
    <spring:url var="images" value="/resources/images" />
    
    <%ConsumersMaster conMaster = (ConsumersMaster) session.getAttribute("loggedInconInfo");%>
<!-- /*     String errMsg = (String) request.getAttribute("errMsg"); */  -->
    
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Consumer's Page</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="/fontawesome-free-5.12.0-web/css/all.css">
    <link rel="stylesheet" href="${css}/consumerContent.css">
     <link rel="stylesheet" href="${css}/consumerlogin.css">
    
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
<%-- <% if(errMsg != null && !errMsg.isEmpty()) { %>
<h2 style ="color:red;"><%=errMsg %></h2>
<%} %> --%>
    <div class="list-group" id="list">
      <button type="button" class="list-group-item list-group-item-action active">
          My Account
        </button> 
      <a href="./electricityConsumption"><button type="button" class="list-group-item list-group-item-action ">
          Electricity Consumption
        </button></a> 
        
       <a href="./displayBillHistorysPage"><button type="button" class="list-group-item list-group-item-action">Bill History</button></a>
        <a href="./currentBill"><button type="button" class="list-group-item list-group-item-action">Current Bill</button></a>
         <a href="./payment"><button type="button" class="list-group-item list-group-item-action" >Pay Online</button></a>
          <a href="./consumerComplaintResolvedDetails"><button type="button" class="list-group-item list-group-item-action" >Complaints Details</button></a>
         <a href="./displayForgotPasswordPage"><button type="button" class="list-group-item list-group-item-action" >Change Password</button></a>
        <a href="./ConsumerLogout"><button type="button" class="list-group-item list-group-item-action" >Logout</button></a>
    </div>

    <div class="card"  id="card">
        <div class="card-body">
            <h5 class="card-title" style="color: white;">Consumer Details</h5>
            <h6 class="card-subtitle mb-2 text-muted"style="color:white" > Meter Number:<%=conMaster.getMeterNumber() %> </h6>
            <p id="card-text" style="color:white">Name:            <%=conMaster.getFirstName() %></p>
            <p id="card-text" style="color:white">Address:         <%=conMaster.getAddressLine1() %></p>
            <p id="card-text" style="color:white">&nbsp;&nbsp;&nbsp;<%=conMaster.getAddressLine2() %></p>
             <p id="card-text" style="color:white">RR-Number        <%=conMaster.getRrNumber() %></p>
            <p id="card-text" style="color:white">Mobile Number    <%=conMaster.getPhnNo() %></p>
             <p id="card-text" style="color:white">Region          <%=conMaster.getRegion() %></p>
             <p id="card-text" style="color:white">City             <%=conMaster.getCity() %></p>
            <a href="./homePage" class="card-link">Home Page</a>
            <a href="./queryPage" class="card-link">HelpLine</a>
        </div>
    </div>

    <script src="/jquery-3.4.1.js"></script>
    <script src="/bootstrap.min.js"></script>
</body>

</html>