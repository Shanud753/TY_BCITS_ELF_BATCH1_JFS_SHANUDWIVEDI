<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%! private int a = 10;
       public void setA(int a){
    	   this.a = a;
       }
       public int getA(){
    	   return a;
       }
       
       public String name = "punnu";
       
       public String getName(){
    	   return name;
       }
       public String getName(String name){
    	   return name;
       }
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 style='color: red'>Welcome to JSP :)...</h1>

	<%-- <jsp:include page="/searchEmp">
		<jsp:param value="98765" name="empId" />
	</jsp:include> --%>
	a=  <%= a %><br> 
	a=<%= getA() %><br>
	
	<% setA(100); %>
	a= <%= getA() %><br>
	<br>
	 Name =<%= name %><br>
	  Name =<%= getName() %><br>
	   Name =<%=  getName("shanu") %><br>
	<br>

	<% for(int i =0;i<5;i++){ %>
	<%= getName() %><br>
	<%} %>

</body>
</html>

<%@ include file="date.html" %>

<%-- <%@ include file="/currentDate" %> --%>     <%--Not Allowed (dynamic resource)--%>

<%--forward method--%>
<%--<jsp:forward page="./date.html"  />--%>
<%--static resource--%>
<%--<jsp:forward page="./currentDate"  />--%>
<%--Dynamic resource--%>

<%--<jsp:forward page="./searchEmp?empId=1234"  />--%>        <%--Dynamic resource with param--%>


<%--  <jsp:forward page="./searchEmp">
<jsp:param value="8471" name="empId"/>
</jsp:forward> --%>


<%--include method--%>
<%--  <jsp:include page="/currentDate"></jsp:include>  --%> <%--static resource--%>


 <%-- <jsp:include page="/searchEmp">      
 <jsp:param value="98765" name="empId"/>
 </jsp:include> 
 --%>                         <%--Dynamic resource with param--%>
















