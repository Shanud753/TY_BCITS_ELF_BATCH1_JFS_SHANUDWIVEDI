<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
   <spring:url var="css" value="/resources/css" />
    <spring:url var="js" value="/resources/js" />
    <spring:url var="images" value="/resources/images" />
    
    <%String errMsg = (String) request.getAttribute("errMsg");%>
        
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Consumer Login</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="/fontawesome-free-5.12.0-web/css/all.css">
    <link rel="stylesheet" href="${css}/consumerlogin.css">


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
<% if(errMsg != null && !errMsg.isEmpty()) { %>
<h2 style ="color:red;"><%=errMsg %></h2>
<%} %>
    <div class="container">
        <div class="card col-8 col-sm-8 col-md-8 col-lg-8 col-xl-8 mx-auto d-block mt-5" style="width: 600px; height: 440px; box-shadow: 0 0 20px;">
            <form id="formData" onsubmit="validation(); return false" method="post" action="./consumerLoginPage" >
                <legend style="font-size: 25px;">Consumer Login</legend>
                <div id="consumerlogo1">
                    <img src="${images}/img-01.png" alt="IMG" style="width: 160px; height:140px; margin-top: 60px;">
                </div>
                <div id="form">
                <div id="form-group">
                    <label for="emai" style="font-size: 17px; padding-top: 20px; font-weight: bolder;">Email-Id</label>
                    <input type="email" class="form-control" id="emai" placeholder="enter  email" style="font-size: 14px;" name="email">
                    <span id="ema"  class="text-danger font-weight-bold"></span>
                    <br>
                    <label for="pwd" style="font-size: 17px;  padding-top: 22px; font-weight: bolder;">Password</label>
                    <input type="password" class="form-control" id="pwd" placeholder="enter  password" style="font-size: 14px;"name="password">
                    <span id="userpass" class="text-danger font-weight-bold"></span>
                </div>
                <button type="submit" class="btn btn-success mx-auto d-block" id="btn" >Submit </button><br>
                <div class="text-center p-t-12">
                    <span id="txt1" style=" color: black;">
                    Forgot
                </span>
                    <a id="txt1" href="./displayForgotPasswordPage">
                    Password?
                </a>
                </div><br>

                <div class="text-center p-t-136">
                    <a class="txt2" href="./consumerRegister" style="font-weight: bolder; font: size 380px;  color: white;">
                    Regiter Now
                    <i class="fa fa-long-arrow-right m-l-5" aria-hidden="true"></i>
                </a>
                </div>
            </div>
            </form>
        </div>
    </div>

    <!-- <div class="list-group" style="width: 270px; height: 300px; margin-left: 160px; margin-top: 0px;">
        <button type="button" class="list-group-item list-group-item-action active">
          Consumer Login
        </button>
        <button type="button" class="list-group-item list-group-item-action">Consumer Registration</button>
        <button type="button" class="list-group-item list-group-item-action">View Bill</button>
        <button type="button" class="list-group-item list-group-item-action" disabled>Download Payment Reciept</button>
    </div> -->

    <script src="${js}/jquery-3.4.1.js"></script>
    <script src="${js}/bootstrap.min.js"></script>

</body>
</html>
