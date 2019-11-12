<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<h2>Login</h2>
<form action="login" method="post">
	<label for="username">Username: </label>
	<input type="text" name="username" />
	<label for="password">Password: </label>
	<input type="password" name="password" />
	<input type="submit" value="Submit" />
</form>
</body>
</html>