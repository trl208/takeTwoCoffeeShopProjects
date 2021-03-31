<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to TRL Coffee Shop</title>
</head>
<body>
<h1>Welcome to TRL Coffee House</h1>
<form action="./getCustomer" method="post">
	Enter Phone Number : <input type="text" name="custPhone"><br><br>
	<input type="submit" value="Search">
</form>


</body>
</html>