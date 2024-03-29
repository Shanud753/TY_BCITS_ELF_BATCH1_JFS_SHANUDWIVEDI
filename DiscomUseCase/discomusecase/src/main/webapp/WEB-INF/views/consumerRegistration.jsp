<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
   <spring:url var="css" value="/resources/css" />
    <spring:url var="js" value="/resources/js" />
    <spring:url var="images" value="/resources/images" />
     <jsp:include page="Header.jsp"></jsp:include>
      <%String msg = (String) request.getAttribute("msg");
  String errMsg = (String) request.getAttribute("errMsg");
  %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Consumer Registration</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="/fontawesome-free-5.12.0-web/css/all.css">
    <link rel="stylesheet" href="${css}/consumerlogin.css">

</head>
<body>
    
    <% if(msg != null && !msg.isEmpty()) { %>
	<h1 style="color: white;"><%=msg %></h1>
	<%} %>
	<% if(errMsg != null && !errMsg.isEmpty()) { %>
	<h2 style="color: red;"><%=errMsg %></h2>
	<%} %>

    <div class="container">
        <form id="formData" onsubmit="validation(); return false" method="post" action="./addConsumer" >
            <div class="form-row">
                <div class="form-group col-md-6">
                  <label for="fname" style="padding-top: 30px; font-weight: bolder; font-size: 18px;">First-Name</label>
                  <input type="text" class="form-control" id="fname" name="firstName">
                  <span id="userfName" class="text-danger font-weight-bold"></span>
                </div>
                <div class="form-group col-md-6">
                  <label for="lname"  style="padding-top: 30px; font-weight: bolder; font-size: 18px;" >Last-Name</label>
                  <input type="text" class="form-control" id="lname" name="lastName">
                  <span id="userlName" class="text-danger font-weight-bold"></span>
                </div>
              </div>
            <div class="form-row">
              <div class="form-group col-md-4">
                <label for="emai" style="font-weight: bolder; font-size: 18px;">Email</label>
                <input type="email" class="form-control" id="emai" name="email">
                <span id="emailid"  class="text-danger font-weight-bold"></span>
              </div>
              <div class="form-group col-md-4">
                <label for="pwd" style="font-weight: bolder; font-size: 18px;">Password</label>
                <input type="password" class="form-control" id="pwd" name="password">
                <span id="userpass" class="text-danger font-weight-bold"></span>
              </div>
              <div class="form-group col-md-4">
                <label for="cpwd" style="font-weight: bolder; font-size: 18px;">Confirm Password</label>
                <input type="password" class="form-control" id="cpwd" name="confirmPassword">
                <span id="usercpass"  class="text-danger font-weight-bold"></span>
              </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                  <label for="rrnumb" style="font-weight: bolder; font-size: 18px;">RR-Number</label>
                  <input type="text" class="form-control" id="rrnumb" name="rrNumber">
                  <span id="rrnum"  class="text-danger font-weight-bold"></span>
                </div>
                <div class="form-group col-md-4">
                  <label for="inputState" style="font-weight: bolder; font-size: 18px;">Type of Consumer</label>
                  <select id="inputState" class="form-control" name="typeOfConsumer">
                    <option selected>Select</option>
                    <option>Residential</option>
                    <option>Commercial</option>
                    <option>Industries </option>
                  </select>
                </div>
                <div class="form-group col-md-2">
                    <label for="inputState" style="font-weight: bolder; font-size: 18px;">Region</label>
                    <select id="inputState" class="form-control" name="region">
                      <option selected>Select</option>
                      <option>Bangalore North</option>
                      <option>Bangalore South</option>
                    </select>
                  </div>
              </div>
            <div class="form-group">
              <label for="address1" style="font-weight: bolder; font-size: 18px;">Address</label>
              <input type="text" class="form-control" id="address1" placeholder="1234 Main St" name="addressLine1">
              <span id="addressval1"  class="text-danger font-weight-bold"></span>
            </div>
            <div class="form-group">
              <label for="address2" style="font-weight: bolder; font-size: 18px;">Address 2</label>
              <input type="text" class="form-control" id="address2" placeholder="Apartment, studio, or floor" name="addressLine2">
              <span id="addressval2"  class="text-danger font-weight-bold"></span>
            </div>
            <div class="form-row">
              <div class="form-group col-md-4">
                <label for="cit" style="font-weight: bolder; font-size: 18px;">City</label>
                <input type="text" class="form-control" id="cit" placeholder="City" name="city">
                <span id="city1"  class="text-danger font-weight-bold"></span>
             </div>
              <div class="form-group col-md-4">
                <label for="mobile" style="font-weight: bold; font-size: 18px;">Mobile number</label>
                <input type="tel" class="form-control" id="mobile" placeholder="Mobile Number" name="phnNo">
                <span id="phnnumber"  class="text-danger font-weight-bold"></span>
                </div>
                 <div class="form-group col-md-2">
                <label for="meterNum" style="font-weight: bold; font-size: 18px;">Meter number</label>
                <input type="tel" class="form-control" id="meterNum" placeholder="Mobile Number" name="meterNumber" required="required">
                <span id="meterNumber"  class="text-danger font-weight-bold"></span>
                </div>
                 <div class="form-group col-md-2">
                <label for="dateConnection" style="font-weight: bold; font-size: 18px;">Date of Connection</label>
                <input type="date" class="form-control" id="dateConnection" placeholder="Enter Date Of Connection" name="dateOfConnection" required="required">
                <span id="dateCon"  class="text-danger font-weight-bold"></span>
                </div>
            </div>
            <div class="form-group">
              <div class="form-check">
                <input class="form-check-input" type="checkbox" id="gridCheck">
                <label class="form-check-label" for="gridCheck" style="font-size: 17px;">
                    By Clicking, I Agree the Terms and Conditions
                </label>
              </div>
            </div>
            <button type="submit" class="btn btn-primary">Sign in</button>
          </form>
    </div>
     <script src="${js}/consumerRegister.js"></script>
     <script src="${js}/jquery-3.4.1.js"></script>
    <script src="${js}/bootstrap.min.js"></script>
    
</body>
</html>