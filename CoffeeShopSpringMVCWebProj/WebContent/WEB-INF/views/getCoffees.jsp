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
	<h2>Coffee Menu</h2>
	<h2>${message}</h2>
<form action="./getAddOns" method="post" >	
	<table border="1">
		<tr>
		     <th>select</th>
			<th>Coffee Type</th>
			<th>Coffee Size</th>
			<th>Price</th>
			

		</tr>
		<c:forEach items="${coffeeList }" var="coffee" varStatus="myIndex" >
			<tr>
			  <td> <input type="checkbox" name="cid" value="${coffee.cId}"> </td>
			  	<!-- <td>${coffee.cId }</td> -->
				<td>${coffee.cType }</td>
				<td>${coffee.cSize }</td>
				<td>${coffee.cPrice }</td>

			</tr>
		</c:forEach>
	</table>
	<br>
	<br>


  Do you want to have AddOns?     <input type="submit" value="Submit" />     
                                  <!--  <input type="url" value="No" onclick="./saveOrder/"/>  -->   
                  
</form>



</body>

</html>