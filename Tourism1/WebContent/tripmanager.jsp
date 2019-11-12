<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Trip Manager</title>
<style>
	#formAdd{
		display:none;
	}
</style>
</head>
<body>
<jsp:include page="header.jsp"/>

<h2>Bookings Made</h2>
<table>
		<tr>
		<th id="CodeHeader">Trip Code</th>
		<th id="NameHeader">UserName</th>
		<th id="BookingHeader">No of Bookings</th>
	</tr>
	<c:forEach var="booking" items="${requestScope.bookingList}">
	<tr>
		<td id="code${booking.tourCode}"><c:out value="${booking.tourCode}"/></td>
		<td id="name${booking.tourCode}"><c:out value="${booking.user}"/></td>
		<td id="numt${booking.tourCode}"><c:out value="${booking.bookNum}"/></td>
	</tr>
	</c:forEach>
</table>
<hr/>
<br/>
<div><input type="button" value="Add Trips" onClick='document.getElementById("formAdd").style.display="block";'></div>

<div id="formAdd">
<h2>Add trips</h2>
<form action="UpdateTripServlet" method="post">
	<label for="tourCode">Tour Code:</label>
	<input type="text" name="tripCode" />
	<br/>
	<label for="tourName">Tour Name</label>
	<input type="text" name="tourName"/>
	<br/>
	<label for="tourStart">Tour Start Date</label>
	<input type="date" name="Startdate"/>
	<br/>
	<label for="tourEnd">Tour End Date</label>
	<input type="date" name="enddate"/>
	<br/>
	<label for="tourSrc">Tour Origin</label>
	<input type="text" name="origin"/>
	<br/>
	<label for="tourDest">Tour Destination</label>
	<input type="text" name="Destination"/>
	<br/>
	<label for="tourCost">Tour Cost</label>
	<input type="number"  name="Cost"/>
	<br/>
	<input type="submit" value="Add tour" />
</form>

</div>
</body>
</html>