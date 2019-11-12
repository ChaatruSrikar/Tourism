<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Confirm Booking</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<h2><c:out value="Booking"/></h2>
<p><c:out value="${requestScope.Tour}"/> - &#8377;<c:out value="${requestScope.BookingCost}"/></p>
<div><a href="TripList">Cancel</a>&#160;&#160;<a href="booking">Book</a></div>
</body>
</html>