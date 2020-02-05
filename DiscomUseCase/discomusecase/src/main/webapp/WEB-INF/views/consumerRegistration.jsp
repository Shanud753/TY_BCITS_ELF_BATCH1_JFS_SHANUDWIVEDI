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
    <title>Consumer Registration</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="/fontawesome-free-5.12.0-web/css/all.css">
    <link rel="stylesheet" href="${css}/consumerlogin.css">

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

    <div class="container">
        <form onsubmit="validation(); return false">
            <div class="form-row">
                <div class="form-group col-md-6">
                  <label for="fname" style="padding-top: 30px; font-weight: bolder; font-size: 18px;">First-Name</label>
                  <input type="text" class="form-control" id="fname">
                  <span id="userfName" class="text-danger font-weight-bold"></span>
                </div>
                <div class="form-group col-md-6">
                  <label for="lname"  style="padding-top: 30px; font-weight: bolder; font-size: 18px;" >Last-Name</label>
                  <input type="text" class="form-control" id="lname">
                  <span id="userlName" class="text-danger font-weight-bold"></span>
                </div>
              </div>
            <div class="form-row">
              <div class="form-group col-md-4">
                <label for="email" style="font-weight: bolder; font-size: 18px;">Email</label>
                <input type="email" class="form-control" id="email">
                <span id="emailid"  class="text-danger font-weight-bold"></span>
              </div>
              <div class="form-group col-md-4">
                <label for="inputPassword4" style="font-weight: bolder; font-size: 18px;">Password</label>
                <input type="password" class="form-control" id="pwd">
                <span id="userpass" class="text-danger font-weight-bold"></span>
              </div>
              <div class="form-group col-md-4">
                <label for="cpwd" style="font-weight: bolder; font-size: 18px;">Confirm Password</label>
                <input type="password" class="form-control" id="cpwd">
                <span id="usercpass"  class="text-danger font-weight-bold"></span>
              </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                  <label for="rrnumber" style="font-weight: bolder; font-size: 18px;">RR-Number</label>
                  <input type="text" class="form-control" id="rrnumber">
                  <span id="rrnum"  class="text-danger font-weight-bold"></span>
                </div>
                <div class="form-group col-md-4">
                  <label for="inputState" style="font-weight: bolder; font-size: 18px;">Type of Consumer</label>
                  <select id="inputState" class="form-control">
                    <option selected>Select</option>
                    <option>Residential</option>
                    <option>Commercial</option>
                    <option>Industries </option>
                  </select>
                </div>
                <div class="form-group col-md-2">
                    <label for="inputState" style="font-weight: bolder; font-size: 18px;">Region</label>
                    <select id="inputState" class="form-control">
                      <option selected>Select</option>
                      <option>Bangalore North</option>
                      <option>Bangalore South</option>
                    </select>
                  </div>
              </div>
            <div class="form-group">
              <label for="address1" style="font-weight: bolder; font-size: 18px;">Address</label>
              <input type="text" class="form-control" id="address1" placeholder="1234 Main St">
              <span id="addressval1"  class="text-danger font-weight-bold"></span>
            </div>
            <div class="form-group">
              <label for="address2" style="font-weight: bolder; font-size: 18px;">Address 2</label>
              <input type="text" class="form-control" id="address2" placeholder="Apartment, studio, or floor">
              <span id="addressval2"  class="text-danger font-weight-bold"></span>
            </div>
            <div class="form-row">
              <div class="form-group col-md-6">
                <label for="city" style="font-weight: bolder; font-size: 18px;">City</label>
                <input type="text" class="form-control" id="city" placeholder="City">
                <span id="city1"  class="text-danger font-weight-bold"></span>
             </div>
              <div class="form-group col-md-4">
                <label for="mobile" style="font-weight: bold; font-size: 18px;">Mobile number</label>
                <input type="tel" class="form-control" id="mobile" placeholder="Mobile Number">
                <span id="phnnumber"  class="text-danger font-weight-bold"></span>
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
     <script src="${js}/jquery-3.4.1.js"></script>
    <script src="${js}/bootstrap.min.js"></script>
    <script src="${js}/consumerRegister.js"></script>
</body>
</html>