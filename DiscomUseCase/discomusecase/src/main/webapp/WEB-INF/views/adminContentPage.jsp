<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
   <spring:url var="css" value="/resources/css" />
    <spring:url var="js" value="/resources/js" />
    <spring:url var="images" value="/resources/images" />
    
<% String errMsg =(String) request.getAttribute("errMsg"); %>
<% String msg =(String) request.getAttribute("msg"); %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Admin Login Form</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="/fontawesome-free-5.12.0-web/css/all.css">
    <link rel="stylesheet" href="${css}/consumerlogin.css">
   <!--  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"> -->
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 

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
         <div align="right" style="margin-top: -40px;">
		<a style="color:white; font-size: 25px;" href="./logOut"><i class="fas fa-sign-out-alt"></i>SignOut</a> &nbsp; &nbsp;
	</div>
        </nav>
    </header>
 
<% if(errMsg != null && !errMsg.isEmpty()){ %>
<h2 style="color: red;" align="center"> <%= errMsg %></h2>
<%} %>
<% if(msg != null && !msg.isEmpty()){ %>
<h2 style="color: green;" align="center"> <%=msg %></h2>
<%} %>
<div class="container">
<div class="login-form"  style="color: black;">
    <form action="./addEmployee" method="post">
		<h3>Add Employees</h3>
        <div class="form-group">
        	<input type="number" class="form-control" name="empId" placeholder="Employee ID" required="required">
        </div>
		<div class="form-group">
            <input type="text" class="form-control" name="empName" placeholder="Employee Name" required="required">
        </div>
		<div class="form-group">
            <input type="text" class="form-control" name="designation" placeholder="Designation" required="required">
        </div>      
        <div class="form-group">
            <input type="password" class="form-control" name="password" placeholder="Password" required="required">
        </div>  
          <div class="form-group">
            <input type="password" class="form-control" name="conPassword" placeholder="Confirm Password" required="required">
        </div> 
        <div class="form-group">
				<select id="region" class="form-control" name="region" required>
                    <option selected>Choose...</option>
                    <option>Bangalore North</option>
                    <option>Bangalore South</option>
                </select>          </div>     
        
		<div class="form-group">
            <button type="submit" class="btn btn-success btn-lg btn-block">Register Now</button>
        </div>
    </form>
</div>
</div>
</body>
</html>