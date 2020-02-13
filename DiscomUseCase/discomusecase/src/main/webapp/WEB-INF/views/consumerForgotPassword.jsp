<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.bcits.discomusecase.beans.ConsumersMaster"%>
<%@page import="com.bcits.discomusecase.beans.CurrentBill"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />
<jsp:include page="Header.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
#formgroup{
margin-left: 400px;
}
</style>
</head>
<body>
 <%String errMsg = (String)request.getAttribute("errMsg"); %>
  <% if(errMsg != null && !errMsg.isEmpty()){%>
 <h2 style="color:red"><%= errMsg %></h2>
 <%}%>
 <%String msg = (String)request.getAttribute("msg"); %>
  <% if(msg != null && !msg.isEmpty()){%>
 <h2 style="color:red"><%= msg %></h2>
 <%}%>
      <div class="container-fluid bg" id="formgroup">
        <div class="row">
            <div class="col-md-4 col-sm-4 col-xs-12">
                <form action="./forgotPassword" id="login" method="post" style="margin-left: 100px; margin-top: 100px;" >
                    <h3><strong style="padding-bottom: 100px;"><u>Reset Password</u></strong></h3>
                    <div>
                        <label>rrNumber</label>
                        <input type="text" class="form-control" name="rrNumber" placeholder=" Enter rr Number">
                    </div>
                    <div>
                        <label>Email</label>
                        <input type="email" class="form-control" name="email" placeholder=" Enter Email">
                    </div>
                    <div>
                        <label> Set The Password</label>
                        <input type="password" class="form-control" name="password" placeholder=" Set The Password">
                    </div>
                     <div>
                        <label>Re-Enter The Password</label>
                        <input type="password" class="form-control" name="confPassword" placeholder=" Re-Enter The Password">
                        <br>
                    </div>
                    <div>
                        <button type="submit" class="btn btn-success">SET</button>
                        <button type="reset" class="btn btn-success">RESET</button>
                    </div>
                    </div>
                </form>
            </div>
          </div>
    
   

  
</body>
</html>