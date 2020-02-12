<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

  
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Home Page</title>
    
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <link rel="stylesheet" href="/fontawesome-free-5.12.0-web/css/all.css">
    <link rel="stylesheet" href="${css}/index.css">

</head>
<body>
   <header class="header">
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<a class="navbar-brand" href="./homePage"><img
				src="${images}/discomlogo.png" alt="" id="consumerlogo"></a>
			<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
				<div class="navbar-nav">
					<h3 id="h3">Electricity Supply Company Limited</h3>
					<h6 id="h6">CIN - U04010KA2002SGC030438 | GST No -
						29AACCB1412G1Z5</h6>
				</div>
			</div>

		</nav>
	</header>


    <div  style="width: 1000px; height: 820px; margin-left: 40px; margin-top: 30px;">
        <div id="carouselExampleInterval" class="carousel slide" data-ride="carousel">
            <div class="carousel-inner">
                <div class="carousel-item active" data-interval="10000">
                    <img src="${images}/energysave2.jpg" class="d-block w-100" alt="..." style="width: 200px; height: 400px;">
                </div>
                <div class="carousel-item" data-interval="2000">
                    <img src="${images}/bulb.jpeg" class="d-block w-100" alt="..." style="width: 200px; height: 400px;">
                </div>
                <div class=" carousel-item ">
                    <img src="${images}/back2.jpg " class="d-block w-100 " alt="..." style="width: 200px; height: 400px;">
                </div>
                <div class=" carousel-item ">
                    <img src="${images}/saveenergy.jpg " class="d-block w-100 " alt="..." style="width: 200px; height: 400px;">
                </div>
                <div class=" carousel-item ">
                    <img src="${images}/back13.jpg " class="d-block w-100 " alt="..." style="width: 200px; height: 400px;">
                </div>
                <div class=" carousel-item ">
                    <img src="${images}/enerrgysave3.png " class="d-block w-100 " alt="..." style="width: 200px; height: 400px;">
                </div>
            </div>
            <a class="carousel-control-prev" href="#carouselExampleInterval" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carouselExampleInterval" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
    </div>
    <div class="fill">
        <form action="" style="border: 1px  black; ">
            <table>
                <tr>
                    <h2 style="background-color: darkblue; color: white;"> <span class="colorchange">DISCOM HELPLINE</span></h2>
                </tr>
                <tr>
                    <td> <img src="${images}/phone.png" style="width: 30px; height: 20px; background-color: white;"></td>
                    <td><input type="text" name="" placeholder="Helpline Number" style="width: 280px; height: 40px; font-size: 18px; color: black; background-color: rgb(218, 241, 255);" disabled></td>
                </tr>
                <tr>
                    <td> <img src="${images}/sms.png" style="width: 30px; height: 20px; background-color: white;"></td>
                    <td><input type="text" name="" placeholder="SMS Facility 765432" style="width: 280px; height: 40px; font-size: 18px;  background-color: rgb(218, 241, 255);" disabled></td>
                </tr>
                <tr>
                    <td> <img src="${images}/whatsap.jpg" style="width: 30px; height: 20px; background-color: white;"></td>
                    <td><input type="text" name="" placeholder="whatsap Facility" style="width: 280px; height: 40px; font-size: 18px;  background-color: rgb(218, 241, 255);" disabled></td>
                </tr>
                <tr>
                    <td> <img src="${images}/whatsap.jpg" style="width: 30px; height: 20px; background-color: white;"></td>
                    <td><input type="text" name="" placeholder="whatsap Safety Helpline" style="width: 280px; height: 40px; font-size: 18px;   background-color: rgb(218, 241, 255); " disabled></td>
                </tr>
                <tr>
                    <td> <img src="${images}/facebook.png" style="width: 30px; height: 20px; background-color: white;"></td>
                    <td><input type="text" name="" placeholder="facebook" style="width: 280px; height: 40px; font-size: 15px; background-color: rgb(218, 241, 255);" disabled></td>
                </tr>
                <tr>
                    <td> <img src="${images}/Twitter.png" style="width: 30px; height: 20px; background-color: white;"></td>
                    <td><input type="text" name="" placeholder="Twitter" style="width: 280px; height: 40px; font-size: 18px;   background-color: rgb(218, 241, 255);" disabled></td>
                </tr>
                <tr>
                    <td> <img src="${images}/message.png" style="width: 30px; height: 20px; background-color: white;"></td>
                    <td><input type="text" name="" placeholder="Message Facility" style="width: 280px; height: 40px; font-size: 18px;   background-color: rgb(218, 241, 255);" disabled></td>
                </tr>
            </table>
        </form>
    </div>

    <div class="portal">
        <a href="./consumerLoginPage"><img src="${images}/consumer.png" alt="" class="rounded-circle" style="margin-left: 190px;"></a>
        <a href="./employeeLogin"><img src="${images}/employee.png" alt="" class="rounded-circle" style="margin-left: 340px;"></a>
    </div>

      <script src="${js}/jquery-3.4.1.js"></script>
    <script src="${js}/bootstrap.min.js"></script>
</body>

</html>