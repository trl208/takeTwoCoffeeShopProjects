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
	<h2>Your Order details</h2>
	<form action="./getCoffees" method="get">
<table><tr><td>
	<table border="1">
		<tr>
			<th>Coffee Type</th>
			<th>Coffee Size</th>
			<th>Price</th>
		</tr>
		<c:forEach items="${coffees.getCoffeeList()}" var="coffee">
			<tr>
				<td>${coffee.cType }</td>
				<td>${coffee.cSize }</td>
				<td>${coffee.cPrice }</td>

			</tr>
		</c:forEach>
	</table></td>
	<td>
	<table border="1">
		<tr>

			<th>AddOn Name</th>
			<th>Price</th>

		</tr>
		<c:forEach items="${selectedAddOns.getAddOnSelection()}" var="addOn">
			<tr>

				<td>${addOn.addOnName }</td>
				<td>${addOn.addOnPrice }</td>

			</tr>
		</c:forEach>

	</table></td></tr>
	
	</table>
	<br>


<table>
<tr><td>Final Bill Invoice</td>  </tr>
<tr><td>Total value: </td><td>${invoice.totalValue }</td> </tr>
<tr><td>Discount :  </td><td>${invoice.discount }</td> </tr>
<tr><td>Net value :  </td><td>${invoice.netValue }</td> </tr>
<tr><td>GST  : 18%   </td><td>${invoice.gst }</td> </tr>
<tr><td>Service Tax  :  8%   </td><td>${invoice.serviceTax }</td> </tr>
<tr><td> Total Bill :  </td><td>${invoice.totalBIllValue }</td> </tr>

</table>
Thank you  Visit Again !!!!!!!   <input type="submit" value=" Order more Coffee"> 
</form>
</body>
</html>