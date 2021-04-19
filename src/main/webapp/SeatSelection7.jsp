<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id = "movieBean" class = "beans.MovieBean" scope = "request" />
<jsp:useBean id = "showingBean" class = "beans.ShowingBean" scope = "request" />
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.List"%>
<%
	String myStr = "MyIdStr";
%>
<%-- <% 
	String pattern = "HH:mm";
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
	String  = simpleDateFormat.format(new Date());
	System.out.println(date);
%> --%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
	<title>Seat Selection</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
	<link rel="stylesheet" href="/beans_and_jdbc/css/style.css">
</head>
<body id="body">
	<nav class="navbar navbar-custom navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
   			<a class="navbar-brand" href="#">Ticket Booker</a>
    		<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    		</button>
    		<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
      		<div class="navbar-nav">
        		<a class="nav-link" href="/beans_and_jdbc/MovieServlet">Movies</a>
       			<a class="nav-link" href="#">Prices</a>
     		</div>
    	</div>
  		</div>
	</nav>
	<!-- <nav class="navbar navbar-inverse">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>                        
                        </button>
                        <a class="navbar-brand" href="#">Ticket Booker</a>
                    </div>
                    <div class="collapse navbar-collapse" id="myNavbar">
                        <ul class="nav navbar-nav">
                            <li class="active"><a href="#">Home</a></li>
                            <li><a href="#">Movies</a></li>
                            <li><a href="#">Prices</a></li>
                        </ul>
                        <ul class="nav navbar-nav navbar-right">
                            <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                        </ul>
                    </div>
                </div>
    </nav> -->
	
<div class="container-fluid text-center movieInfo d-block ">
	<h2>${showing.getMovie().getTitle()}</h2>
	<h3><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> <fmt:formatDate value="${showing.time}" pattern="hh:mm a" /></h3>
</div>
<div class="container-fluid ">
	<div class="row contentContainer">
		<div class="col d-none d-lg-block ">
	  		<div class="row posterInfo">
				<img class="poster" alt="" src="img/${showing.getMovie().getImageLink()}">
				<div class="posterDetails">
					<h5>${showing.getMovie().getTitle()}</h5>
					<p><fmt:formatDate value="${showing.time}" pattern="hh:mm a" /></p>
				</div>
			</div>
		</div> 
		<div class="col">
			<div class="seat-container ">
				<c:forEach begin="1" end="${showing.screenRows}" varStatus="loop">
    				<div class="row seatRow justify-content-center">
					<div class="col-1">${seatList.get((loop.index*showing.screenCols)-1).getRow()}</div>
					<c:forEach begin="1" end="${showing.screenCols}" varStatus="loop2">
						<div class="unit col-1" id="${seatList.get((loop.index*showing.screenCols)-1).getRow().concat(seatList.get(loop2.index-1).getNumber())}" 
						data-bs-toggle="tooltip" data-bs-placement="top" title="${seatList.get((loop.index*showing.screenCols)-1).getRow().concat(seatList.get(loop2.index-1).getNumber())}" >&nbsp;</div>
					</c:forEach>
				</div>
				</c:forEach>
				<!-- <div class="row seatRow justify-content-center">
					<div class="col-1">A</div>
					<div class="unit col-1" id="a1">&nbsp;</div>
					<div class="unit col-1" id="a2">&nbsp;</div>
					<div class="unit col-1" id="a3">&nbsp;</div>
					<div class="unit col-1" id="a4">&nbsp;</div>
					<div class="unit col-1" id="a5">&nbsp;</div>
					<div class="unit col-1" id="a6">&nbsp;</div>
					<div class="unit col-1" id="a7">&nbsp;</div>
					<div class="unit col-1 " id="a8">&nbsp;</div>
					<div class="unit col-1" id="a9">&nbsp;</div>
					<div class="unit col-1" id="a10">&nbsp;</div>
					<div class="unit col-1" id="a11">&nbsp;</div>
					<div class="unit col-1" id="a12">&nbsp;</div>
					<div class="unit col-1" id="a13">&nbsp;</div>
					<div class="unit col-1" id="a14">&nbsp;</div>
				</div>
				<div class="row seatRow justify-content-center">
					<div class="col-1">B</div>
					<div class="unit col-1 " id="b1">&nbsp;</div>
					<div class="unit col-1" id="b2">&nbsp;</div>
					<div class="unit col-1" id="b3">&nbsp;</div>
					<div class="unit col-1" id="b4">&nbsp;</div>
					<div class="unit col-1" id="b5">&nbsp;</div>
					<div class="unit col-1" id="b6">&nbsp;</div>
					<div class="unit col-1" id="b7">&nbsp;</div>
					<div class="unit col-1" id="b8">&nbsp;</div>
					<div class="unit col-1" id="b9">&nbsp;</div>
					<div class="unit col-1" id="b10">&nbsp;</div>
					<div class="unit col-1" id="b11">&nbsp;</div>
					<div class="unit col-1" id="b12">&nbsp;</div>
					<div class="unit col-1" id="b13">&nbsp;</div>
					<div class="unit col-1" id="b14">&nbsp;</div>
				</div>
				<div class="row seatRow justify-content-center">
					<div class="col-1">C</div>
					<div class="unit col-1" id="c1">&nbsp;</div>
					<div class="unit col-1" id="c2">&nbsp;</div>
					<div class="unit col-1" id="c3">&nbsp;</div>
					<div class="unit col-1" id="c4">&nbsp;</div>
					<div class="unit col-1" id="c5">&nbsp;</div>
					<div class="unit col-1" id="c6">&nbsp;</div>
					<div class="unit col-1" id="c7">&nbsp;</div>
					<div class="unit col-1" id="c8">&nbsp;</div>
					<div class="unit col-1" id="c9">&nbsp;</div>
					<div class="unit col-1" id="c10">&nbsp;</div>
					<div class="unit col-1" id="c11">&nbsp;</div>
					<div class="unit col-1" id="c12">&nbsp;</div>
					<div class="unit col-1" id="c13">&nbsp;</div>
					<div class="unit col-1" id="c14">&nbsp;</div>
				</div>
				<div class="row seatRow justify-content-center">
					<div class="col-1">D</div>
					<div class="unit col-1" id="d1">&nbsp;</div>
					<div class="unit col-1" id="d2">&nbsp;</div>
					<div class="unit col-1" id="d3">&nbsp;</div>
					<div class="unit col-1" id="d4">&nbsp;</div>
					<div class="unit col-1" id="d5">&nbsp;</div>
					<div class="unit col-1" id="d6">&nbsp;</div>
					<div class="unit col-1" id="d7">&nbsp;</div>
					<div class="unit col-1" id="d8">&nbsp;</div>
					<div class="unit col-1" id="d9">&nbsp;</div>
					<div class="unit col-1" id="d10">&nbsp;</div>
					<div class="unit col-1" id="d11">&nbsp;</div>
					<div class="unit col-1" id="d12">&nbsp;</div>
					<div class="unit col-1" id="d13">&nbsp;</div>
					<div class="unit col-1" id="d14">&nbsp;</div>
				</div>
				<div class="row seatRow justify-content-center">
					<div class="col-1">E</div>
					<div class="unit col-1" id="e1">&nbsp;</div>
					<div class="unit col-1" id="e2">&nbsp;</div>
					<div class="unit col-1" id="e3">&nbsp;</div>
					<div class="unit col-1 " id="e4">&nbsp;</div>
					<div class="unit col-1 " id="e5">&nbsp;</div>
					<div class="unit col-1 " id="e6">&nbsp;</div>
					<div class="unit col-1 " id="e7">&nbsp;</div>
					<div class="unit col-1 " id="e8">&nbsp;</div>
					<div class="unit col-1 " id="e9">&nbsp;</div>
					<div class="unit col-1 " id="e10">&nbsp;</div>
					<div class="unit col-1 " id="e11">&nbsp;</div>
					<div class="unit col-1 " id="e12">&nbsp;</div>
					<div class="unit col-1 " id="e13">&nbsp;</div>
					<div class="unit col-1" id="e14">&nbsp;</div>
				</div>
				<div class="row labelRow6 justify-content-center ">
					<div class="col-1">&nbsp;</div>
					<div class=" label col-1">1</div>
					<div class="label col-1">2</div>
					<div class="label col-1">3</div>
					<div class="label col-1">4</div>
					<div class="label col-1">5</div>
					<div class="label col-1">6</div>
					<div class="label col-1">7</div>
					<div class="label col-1">8</div>
					<div class="label col-1">9</div>
					<div class="label col-1">10</div>
					<div class="label col-1">11</div>
					<div class="label col-1">12</div>
					<div class="label col-1">13</div>
					<div class="label col-1">14</div>
				</div> -->
			</div> <!--close seat container  -->
		</div> <!-- close col-8  -->
		<div class="col-md-3 cartModule card ">
					<p>Selected Seats: </p>
					<ul id="cartList">
						<li>&nbsp;</li>	
					</ul>
		</div>
	</div> <!-- close row -->
</div>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
<script type="text/javascript" src="/beans_and_jdbc/js/seatScript.js"></script>
<script type="text/javascript" src="jquery-3.5.1.min.js">
$(function () {
    $('[data-bs-toggle="tooltip"]').tooltip()
})
</script>
</body>
</html>