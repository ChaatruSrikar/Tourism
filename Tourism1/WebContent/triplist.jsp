<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Trips</title>
<style type="text/css">
	table{
		margin-left:auto;
		margin-right:auto;
		border: 1px solid #666633;
		border-collapse:collapse;
	}
	table>tr>th,td{
		padding:10px;
		width:14%;
		text-align:center;
		border-bottom:1px solid #666633;
	}
	#formEdit,#formBook{
		display:none;
	}
	
</style>

<script type="text/javascript">
	function getEditForm(ele){
		var tourCode = document.getElementById("code"+ele).innerHTML;
		var tourName = document.getElementById("name"+ele).innerHTML;
		var tourstartDate = document.getElementById("start"+ele).innerHTML;
		var tourstopDate = document.getElementById("end"+ele).innerHTML;
		var tourstartLoc = document.getElementById("src"+ele).innerHTML;
		var tourstopLoc = document.getElementById("dest"+ele).innerHTML;
		var tourCost = document.getElementById("cost"+ele).innerHTML;

		
		document.getElementById("formEdit").style.display = "block";
		
		document.forms[1].elements[0].value = tourCode;
		document.forms[1].elements[1].value = tourName;
		document.forms[1].elements[2].value = tourstartDate;
		document.forms[1].elements[3].value = tourstopDate;
		document.forms[1].elements[4].value = tourstartLoc;
		document.forms[1].elements[5].value = tourstopLoc;
		document.forms[1].elements[6].value = tourCost;
	}
	
	function getBookingForm(ele){
		
		var tourCode = document.getElementById("code"+ele).innerHTML;
		var tourName = document.getElementById("name"+ele).innerHTML;
		
		document.getElementById("formBook").style.display = "block";
		
		document.forms[2].elements[0].value = tourCode;
		document.forms[2].elements[1].value = tourName;
		document.forms[2].elements[1].focus;
	}
</script>

</head>
<body>
<jsp:include page="header.jsp"/>
<form action="Triplist" method="post">
	<label for="nameSearch">Search for tour: </label>
	<input type="text" name="nameSearch" placeholder="Search name of tour"/>
	<input type="submit" name="SearchBtn" value="Search" />
</form>
<p><c:out value="${requestScope.searchResult}"/></p>
<table id="TripTable">
	<tr>
		<th id="CodeHeader">Trip Code</th>
		<th id="NameHeader">Trip Name</th>
		<th id="StartHeader">Start Date</th>
		<th id="EndHeader">End Date</th>
		<th id="OrgHeader">Origin</th>
		<th id="DestHeader">Destination</th>
		<th id="CostHeader">Cost</th>
		<th></th>
	</tr>
	<c:forEach var="trip" items="${requestScope.TripList}">
	<tr>
		<td id="code${trip.code}"><c:out value="${trip.code}"/></td>
		<td id="name${trip.code}"><c:out value="${trip.tourName}"/></td>
		<td id="start${trip.code}"><c:out value="${trip.startDate}"/></td>
		<td id="end${trip.code}"><c:out value="${trip.stopDate}"/></td>
		<td id="src${trip.code}"><c:out value="${trip.strtLoc}"/></td>
		<td id="dest${trip.code}"><c:out value="${trip.stpLoc}"/></td>
		<td id="cost${trip.code}"><c:out value="${trip.cost}"/></td>
		<td>
			<c:if test="${sessionScope.Username != null }">
				<input type="button" value="Book" onClick="getBookingForm(${trip.code})"/>
			</c:if>
			&#160;&#160;&#160;
			<c:if test="${sessionScope.Emp == true }">
				<input type="button" value="Edit" onClick="getEditForm(${trip.code})"/>
			</c:if>
		</td>
	</tr>
	</c:forEach>
</table>

<br/>
<hr/>
<br/>

<div id="formEdit">
	
	<form action="UpdateTripList" method="post">
		<label for="tourCode">Trip Code:</label>
		<input type="text" name="tripCode" />
		<br/>
		<label for="tourName">Trip Name:</label>
		<input type="text" name="tourName"/>
		<br/>
		<label for="tourStart">Start Date:</label>
		<input type="Date" name="Startdate" />
		<br/>
		<label for="tourEnd">End Date:</label>
		<input type="Date" name="enddate"/>
		<br/>
		<label for="tourSrc">Origin:</label>
		<input type="text" name="origin"/>
		<br/>
		<label for="tourDest">Destination:</label>
		<input type="text" name="Destination"/>
		<br/>
		<label for="Cost">Trip Cost:</label>
		<input type="number"  name="Cost"/>
		<br/>
		<input type="submit" value="Edit"/>
	</form>
</div>

<div id="formBook">
	<h3>Booking Details</h3>
	<form action="booking" method="post">
		<label for="tours">Tour Code: </label>
		<input type="text" name="tours" readonly="readonly"/>
		<br/>
		<label for="tourName">Tour Name: </label>
		<input type="text" name="tourName"readonly="readonly"/>
		<br/>
		<label for="bookings">Number of bookings:</label>
		<input type="number" min="1" name="bookings" placeholder="Number of bookings"/>
		<br/>
		<input type="submit" value="Book"/>
	</form>
</div>

</body>
</html>