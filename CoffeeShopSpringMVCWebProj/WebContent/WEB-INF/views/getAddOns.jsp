<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

     <h2>AddOn Menu</h2>
	<h2>${message}</h2>
	<form action="./generateOrder" method="post" >
	<table border="1">
		<tr>
		     <th>select</th>
			
			<th>AddOn Name</th>
			<th>Price</th>

		</tr>
		<c:forEach items="${addOnsList }"  var="addOn">
			<tr>
			<td> <input type="checkbox" name="aid" value="${addOn.addOnId}"> </td>
				
				<td>${addOn.addOnName }</td>
				<td>${addOn.addOnPrice }</td>
				
			</tr>
		</c:forEach>
	  
	</table>
	<br>
	
	<br>Do you have a voucher for discount? If yes please enter the voucher number:
	<input type="text" name="voucher" >	


  <input type="submit" value="Add ADDON" />  

</form>
	
	    
		    
	
</body>
</html>