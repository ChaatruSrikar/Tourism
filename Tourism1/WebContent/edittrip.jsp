<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="UpdateTripServlet" method="post">
	<label for="tourCode">Trip Code:</label>
	<input type="text" name="tripCode" disable=true value="${requestScope.tripCode}"/>
	
	<label for="tourName">Trip Name:</label>
	<input type="text" name="tourName" value="${requestScope.tourName}"/>
	
	<label for="tourStart">Start Date:</label>
	<input type="Date" name="Startdate" value="${requestScope.Startdate}"/>
	
	<label for="tourEnd">End Date:</label>
	<input type="Date" name="enddate" value="${requestScope.enddate}"/>
	
	<label for="tourSrc">Source:</label>
	<input type="text" name="origin" value="${requestScope.origin}"/>
	
	<label for="tourDest">Destination:</label>
	<input type="text" name="Destination" value="${requestScope.Destination}"/>
	
	<label for="tourCost">Trip Cost:</label>
	<input type="text" name="Cost" value="${requestScope.Cost}"/>
	
	<input type="submit" value="Edit"/>
</form>
</body>
</html>