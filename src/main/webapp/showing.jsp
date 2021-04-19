<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:useBean id = "showing" class = "beans.ShowingBean" scope = "request" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Time: ${showing.timeString}<br>
	Date: ${showing.dateString}<br>
	Screen: ${showing.screenName} (${showing.screenRows} rows, ${showing.screenCols} cols)<br>
	Movie: ${showing.movie.title}<br>
	Rating: ${showing.movie.rating.displayName}<br>
</body>
</html>