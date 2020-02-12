<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
   <spring:url var="css" value="/resources/css" />
    <spring:url var="js" value="/resources/js" />
    <spring:url var="images" value="/resources/images" />
    
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Admin Login</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="/fontawesome-free-5.12.0-web/css/all.css">
    <link rel="stylesheet" href="${css}/navbar.css">


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


 <div class="container">
        <div class="card col-8 col-sm-8 col-md-8 col-lg-8 col-xl-8 mx-auto d-block mt-5" style="width: 600px; height: 440px; box-shadow: 0 0 20px;background-image: url('${images}/b17.jpg');">
            <form id="formData"  method="post" action="./adminLogin" >
                <legend style="font-size: 25px;color: white;">Admin Login</legend>
                <div id="consumerlogo1">
                    <img src="${images}/img-01.png" alt="IMG" style="width: 160px; height:140px; margin-top: 60px; margin-left: 180px; margin-top:-20px; ">
                </div>
                <div id="form">
                <div id="form-group">
                    <label for="user" style="font-size: 17px; padding-top: 20px; font-weight: bolder;color: white;">User-Name</label>
                    <input type="text" class="form-control" id="user" placeholder="enter  UserName" style="font-size: 14px;" name="username">
                    <span id="user1"  class="text-danger font-weight-bold"></span>
                    <br>
                    <label for="pwd" style="font-size: 17px;  padding-top: 22px; font-weight: bolder;color: white;">Password</label>
                    <input type="password" class="form-control" id="pwd" placeholder="enter  password" style="font-size: 14px;"name="password">
                    <span id="userpass" class="text-danger font-weight-bold"></span>
                </div>
                <button type="submit" class="btn btn-success mx-auto d-block" id="btn" style="margin-top: 20px;">Submit </button><br>
                <div class="text-center p-t-12">      
    </form>
</body>
</html>