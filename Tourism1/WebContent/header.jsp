<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
	header{
		text-align:center;
	}
	
	a{
		decoration:none;
	}
	
	nav{
		
		text-align:center;
		padding:10px;
		width:100%;
	}
	
	.btn{
		display:inline;
		padding:5px;
		border:1px solid #006600;
		border-radius:15px;
		margin-right:5px;
		margin-left:5px;
	}
	
</style>
</head>
<body>

<header>	<h1>Ha Ha Haaa Haa Tours</h1>	</header>

<nav>
	<div class="btn"><a href="header.jsp">Home</a></div>
	<div class="btn"><a href="TripList">View Trips</a></div>
	
	<c:if test="${sessionScope.Username == null }">
		<div class="btn">	<a href="register.jsp">Register</a>	</div>
		<div class="btn">	<a href="login.jsp">Login</a>	</div>
	</c:if>
	<c:if test="${sessionScope.Username != null }">
		<c:if test="${sessionScope.Emp == true }">
			<div class="btn">	<a href="BookingList"> Booking List</a>	</div>
		</c:if>
		
		<div class="btn">	<a href="logout.jsp">Logout</a>		</div>
	</c:if>
</nav>

<hr/>
</body>
</html>