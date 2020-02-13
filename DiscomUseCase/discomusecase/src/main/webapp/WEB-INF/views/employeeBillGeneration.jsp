<%@page import="com.bcits.discomusecase.beans.ConsumersMaster"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
 <jsp:include page="empHeader.jsp"></jsp:include>


<%List<ConsumersMaster> consumersMasterList = (List<ConsumersMaster>)request.getAttribute("consumersMasterList"); %>
 <%String msg = (String) request.getAttribute("msg");
  String errMsg = (String) request.getAttribute("errMsg");
  %>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Employee's Page</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="/fontawesome-free-5.12.0-web/css/all.css">
<link rel="stylesheet" href="${css}/navbar.css">
<link rel="stylesheet" href="${css}/generate.css">
<script>
function myFunction() {
  // Declare variables
  var input, filter, ul, li, a, i, txtValue;
  input = document.getElementById('myInput');
  filter = input.value.toUpperCase();
  table = document.getElementById("myTable");
  tr = ul.getElementsByTagName('tr');

  // Loop through all list items, and hide those who don't match the search query
  for (i = 0; i < li.length; i++) {
    th = li[i].getElementsByTagName("th")[0];
    txtValue = a.textContent || a.innerText;
    if (txtValue.toUpperCase().indexOf(filter) > -1) {
      li[i].style.display = "";
    } else {
      li[i].style.display = "none";
    }
  }
}
</script>
<style type="text/css">

#myInput {
  background-image: url('/css/searchicon.png'); /* Add a search icon to input */
  background-position: 10px 12px; /* Position the search icon */
  background-repeat: no-repeat; /* Do not repeat the icon image */
  width: 100%; /* Full-width */
  font-size: 16px; /* Increase font-size */
  padding: 12px 20px 12px 40px; /* Add some padding */
  border: 1px solid #ddd; /* Add a grey border */
  margin-bottom: 12px; /* Add some space below the input */
}

#myTable {
  /* Remove default list styling */
  list-style-type: none;
  padding: 0;
  margin: 0;
}

#myTable tr th {
  border: 1px solid #ddd; /* Add a border to all links */
  margin-top: -1px; /* Prevent double borders */
  background-color: #f6f6f6; /* Grey background color */
  padding: 12px; /* Add some padding */
  text-decoration: none; /* Remove default text underline */
  font-size: 18px; /* Increase the font-size */
  color: black; /* Add a black text color */
  display: block; /* Make it into a block element to fill the whole list */
}

#myTable tr th:hover:not(.header) {
  background-color: #eee; /* Add a hover effect to all links, except for headers */
}

</style>

</head>

<body>
	
	<% if(msg != null && !msg.isEmpty()) { %>
	<h1 style="color: green;"><%=msg %></h1>
	<%} %>
	<% if(errMsg != null && !errMsg.isEmpty()) { %>
	<h2 style="color: red;"><%=errMsg %></h2>
	<%} %>


	<% if(consumersMasterList != null ){ %>
  <!--  <input  id="myInput" onkeyup="myFunction()" type="text" placeholder="Search rrNumber.."> -->
 <table border ="1" style='width:70%; margin-left: 200px; margin-top: 200px'>
	     <thead style='background-color: black; color: white'>
	         <tr style="height:35px">

				<th >Sl No</th>
				<th >RR Number</th>
				<th >Name</th>
				<th >Email Id</th>
				<th >Phone Number</th>
				<th >Region</th>
				<th >Consumer Type</th>
				<th >Bill Generation</th>
			</tr>

   </thead>
		<% int i=1;
	     for(ConsumersMaster consumersMasterBean
	    		 :consumersMasterList){  %>
		<form action="./billGeneratePage" method="get">
			<input name="rrNumber" type="text"
				value="<%= consumersMasterBean.getRrNumber()%>" hidden="true">
			<tr style="height:35px; color:white;">
				 <td ><%= i %></td>
				<td ><%= consumersMasterBean.getRrNumber() %></td>
				<td ><%= consumersMasterBean.getFirstName() %></td>
				<td><%= consumersMasterBean.getEmail() %></td>
				<td ><%= consumersMasterBean.getPhnNo() %></td>
				<td><%= consumersMasterBean.getRegion() %></td>
				<td><%=consumersMasterBean.getTypeOfConsumer() %></td>
				<td >
				<button type="submit">
						<h4 style='color: black'>Click Here To Generate Bill</h4>
					</button></td>
			</tr>
		</form>
		
		<% i++;} 
	     
	}else {%>
		<h3><%=errMsg %></h3>
		<%} %>

   	<script src="${js}/jquery-3.4.1.js"></script>
	<script src="${js}/bootstrap.min.js"></script>
</body>
</html>