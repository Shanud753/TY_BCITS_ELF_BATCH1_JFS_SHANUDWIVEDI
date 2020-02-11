<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.bcits.discomusecase.beans.SupportCustBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
   <spring:url var="css" value="/resources/css" />
    <spring:url var="js" value="/resources/js" />
    <spring:url var="images" value="/resources/images" />
     <% String errMsg = (String) request.getAttribute("errMsg");%>
     <% 
     List<SupportCustBean> supportList =(List<SupportCustBean>) request.getAttribute("supportList");
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
<% if(errMsg != null && !errMsg.isEmpty()) { %>
<h2 style ="color:white;"><%=errMsg %></h2>
<%} %>

<%
    	if(supportList != null){
    %>
    <div style="margin-left: 40px">
	<table class="table" style="color: blue;">
  <thead >
    <tr>
      <th scope="col">No &nbsp;&nbsp;&nbsp;&nbsp;</th>
      <th scope="col">RR Number &nbsp;&nbsp;&nbsp;&nbsp;</th>
      <th scope="col">Date &nbsp;&nbsp;&nbsp;&nbsp;</th>
      <th scope="col">Complaints Details &nbsp;&nbsp;&nbsp;&nbsp;</th>
      <th scope="col">Response &nbsp;&nbsp;&nbsp;&nbsp;</th>
    </tr>
  </thead>
  <tbody id="myTable">
    <%
    	int i=1; 
      for(SupportCustBean supportBean : supportList ) {
    %>
  <form action="./" method="get" >
  	<tr>
      <th scope="row"><%= i %> </th>
       <td><strong><%= supportBean.getSupportBeanCustPK().getRrNumber() %> </strong></td>
        <td><strong><% SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy"); %> 
             <%=formatter.format(supportBean.getSupportBeanCustPK().getDate()) %>
       <td><strong><%= supportBean.getRequest() %> </strong></td>
        <td><strong><textarea class="form-Control" rows="2" id="comment" readonly="readonly" ><%=supportBean.getResponse() %></textarea></strong></td>
    </tr>
     </form>
    <% i++; }}%>
   		</tbody>
	</table>
  </div>
    </div>
</body>
</html>