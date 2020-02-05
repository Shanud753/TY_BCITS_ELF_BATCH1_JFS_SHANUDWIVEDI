<%@page import="com.bcits.discomusecase.beans.MonthlyConsumption"%>
<%@page import="com.bcits.discomusecase.beans.CurrentBill"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="/fontawesome-free-5.12.0-web/css/all.css">
<link rel="stylesheet" href="${css}/billGenerate.css">
</head>
<body>
<header class="header">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="index.html"><img src="${images}/discomlogo.png" alt="" id="consumerlogo"></a>
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
<fieldset>
     <%-- <form action="./generateBill" >
       <h3>RR-Number==><%=billInfo.getRrNumber() %></h3>
        <div class="form-group col-md-6">
					<label for="inputState"
						style="font-weight: bolder; font-size: 18px;">Type of
						Consumer</label> <select id="inputConsumer" class="form-control"
						name="typeOfConsumer">
						<option selected>Select</option>
						<option>Residential</option>
						<option>Commercial</option>
						<option>Industries</option>
					</select>
				</div>
	    <h4>Units ==><%=billInfo.getUnitsConsumed() %></h4>
		<% %>		
       <input type="submit" value="PayNow">
       </form> --%>
</fieldset>


</body>
</html>