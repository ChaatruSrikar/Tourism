<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<script type="text/javascript">
	


</script>
</head>
<body>
<jsp:include page="header.jsp"/>
<h2>Register</h2>
<form action="register" method="post">
	<label for="username">Enter Username:</label>
	<input type="text" name="username" required/>
	<label for="password">Enter password:</label>
	<input type="password" name="password" required/>
	
	<label for="">Category:</label>
	<select name="usercategory" >
		<option value="Employee">Employee</option>
		<option value="Customer">Customer</option>
	</select>
	<input type="reset" value="Clear" />
	<input type="submit" value="Register" />
</form>
</body>
</html>