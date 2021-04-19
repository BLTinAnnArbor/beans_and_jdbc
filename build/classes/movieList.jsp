<% String headline = "my headline"; %>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id = "movieList" class = "beans.MovieListBean" scope = "request" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String message=(String)session.getAttribute("message");
/* List movies = movieList.getMovies(); */
/* String mine = "";
for(int i=0; i< movies.size(); i++){
	System.out.println(movies.get(i).toString());
}
String[] arr = {"red","blue","green"};  */

%>
<c:forEach items="${ml}" var="movie">
    ${movie.getTitle()}<br>
    ${movie.imageLink}<br>
</c:forEach>
<%-- <c:forEach items="${movielist}" var="listEl">
	<c:forEach items="${ListEl}" var="film">
    1 ${film.getTitle()}<br>
   	${film.imageLink}<br>
	</c:forEach>
</c:forEach> --%>


    
    <h1><%=headline %></h1>
    <p>${msg}</p>
    <p>${message}</p>
<%-- 		<p>${movieList}</p>
	Time: ${showing.timeString}<br>
	Date: ${showing.dateString}<br>
	Screen: ${showing.screenName} (${showing.screenRows} rows, ${showing.screenCols} cols)<br>
	Movie: ${showing.movie.title}<br>
	Rating: ${showing.movie.rating.displayName}<br> --%>
</body>
</html>