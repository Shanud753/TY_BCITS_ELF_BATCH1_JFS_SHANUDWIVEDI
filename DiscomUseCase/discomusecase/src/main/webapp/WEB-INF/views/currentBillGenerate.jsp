<%@page import="com.bcits.discomusecase.beans.ConsumersMaster"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
   <spring:url var="css" value="/resources/css" />
    <spring:url var="js" value="/resources/js" />
    <spring:url var="images" value="/resources/images" />
   <jsp:include page="empHeader.jsp"></jsp:include> 
 
   <%String msg = (String) request.getAttribute("msg");
  String errMsg = (String) request.getAttribute("errMsg");
 ConsumersMaster consumerMaster =(ConsumersMaster) request.getAttribute("conMaster");
 double previousReading = (double)request.getAttribute("previousReading");
  %>
 
        
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Consumer Login</title>
     <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="/fontawesome-free-5.12.0-web/css/all.css">


</head>

<body>

<% if(msg != null && !msg.isEmpty()) { %>
<h3 style ="color:green;"><%=msg %></h3>
<%} %>
<% if(errMsg != null && !errMsg.isEmpty()) { %>
<h2 style ="color:red;"><%=errMsg %></h2>
<%} %>

	
    <div class="container">
        <div class="card col-12 col-sm-12 col-md-12 col-lg-12 col-xl-12 mx-auto d-block mt-5" style="width: 600px; height: 400px; box-shadow: 0 0 20px; background-image: url('/images/b19.jpg');">
            <form id="formData" onsubmit="validation(); return false"  action="./billGenerated" >
                <legend style="font-size: 25px;"><u>Current Bill Generation</u></legend>
                <div class="form-row">
                <div class="form-group col-md-6">
                  <label for="rrnumber" style="font-size: 17px; padding-top: 20px; font-weight: bolder;">RR-Number</label>
                  <input type="text" class="form-control" id="rrnumber" name="rrNumber" value=<%=consumerMaster.getRrNumber() %>>
                  <span id="rrnum" class="text-danger font-weight-bold"></span>
                </div>
                <div class="form-group col-md-6">
                  <label for="initialReading"  style="padding-top: 30px; font-weight: bolder; font-size: 18px;" >initialReading</label>
                  <input type="number" class="form-control" id="initialReading" name="initialReading" value=<%=previousReading%>>
                  <span id="initialRead" class="text-danger font-weight-bold"></span>
                </div>
              </div>
                
                <div class="form-row">
                <div class="form-group col-md-6">
                <label for="finalReading" style="font-weight: bolder; font-size: 18px;">Final-Reading</label>
                <input type="number" class="form-control" id="finalReading" name="finalReading">
                <span id="finalRead"  class="text-danger font-weight-bold"></span>
              </div>
              <div class="form-group col-md-6">
                <label for="dueDte" style="font-weight: bolder; font-size: 18px;">Due Date</label>
                <input type="date" class="form-control" id="dueDte" name="dueDate">
                <span id="finaldate" class="text-danger font-weight-bold"></span>
                 </div>
                  </div>
                   <div class="form-row">
                    <div class="form-group col-md-6">
					<label for="inputState" style="font-weight: bolder; font-size: 18px;">Type of Consumer</label> 
				 <input type="text" class="form-control" id="type" style="font-size: 14px;" name="typeOfConsumer" value=<%=consumerMaster.getTypeOfConsumer()%> >
				</div>
                </div>
                <button type="submit" class="btn btn-primary mx-auto d-block" id="btn" style="width: 150px; height: 40px;">Generate Bill </button><br>
            </div>
            </form>
        </div>
    </div>
        	
 
    <script src="${js}/jquery-3.4.1.js"></script>
    <script src="${js}/bootstrap.min.js"></script>

</body>
</html>
