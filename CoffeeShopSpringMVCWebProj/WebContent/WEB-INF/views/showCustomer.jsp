<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>${message}</h2>
<spring:form action="./saveCustomer" method="post" modelAttribute="customer">
	Enter Phone Number :  <spring:input path="custPhone" /><br><br>
     Enter Your Name     :<spring:input path="name" /> 
	<input type="submit" value="save">
	
</spring:form>
</body>
</html>