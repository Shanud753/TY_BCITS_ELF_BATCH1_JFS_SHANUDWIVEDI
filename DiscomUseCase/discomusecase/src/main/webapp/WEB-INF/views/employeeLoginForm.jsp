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
    <title>Employee Login</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="/fontawesome-free-5.12.0-web/css/all.css">
    <link rel="stylesheet" href="${css}/employee.css">


</head>

<body>
    <header class="header">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="/index.html"><img src="${images}/discomlogo.png" alt="" id="consumerlogo"></a>
            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                <div class="navbar-nav">
                    <h3 id="h3">Electicity Supply Company Limited
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
        <div class="card col-8 col-sm-8 col-md-8 col-lg-8 col-xl-8 mx-auto d-block mt-5" style="width: 600px; height: 440px; box-shadow: 0 0 20px;">
            <form id="formData" onsubmit="validation(); return false" method="post" action="./employeeContent">
                <legend style="font-size: 25px; color: white;"><u>Employee Login</u></legend>
                <div id="form">
                <div id="form-group">
                    <label for="empId" style="font-size: 17px; padding-top: 20px; font-weight: bolder; color: white;">Employee Id</label>
                    <input type="text" class="form-control" id="empId" placeholder="Enter  Employee ID" style="font-size: 14px;">
                    <span id="emp1"  class="text-danger font-weight-bold"></span>
                    <br>
                    <label for="desig" style="font-size: 17px;  padding-top: 22px; font-weight: bolder; color: white;">Designation</label>
                    <input type="text" class="form-control" id="desig" placeholder="Enter Employee Designation" style="font-size: 14px;">
                    <span id="desig1" class="text-danger font-weight-bold"></span>
                </div>
                <button type="submit" class="btn btn-success mx-auto d-block" id="btn" >Submit </button><br>
                <div class="text-center p-t-12">
                    <span id="txt1" style=" color: white;">
                    Forgot
                </span>
                    <a id="txt1" href="index.jsp">
                    Password?
                </a>
                </div><br>
            </div>
            </form>
        </div>
    </div>
  
    <script src="${js}/jquery-3.4.1.js"></script>
    <script src="${js}/bootstrap.min.js"></script>
    <script src="${js}/employee.js"></script>

</body>
</html>