<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<!DOCTYPE html>
<html>
<head>
<style>
	th, td{
	color:black;
	}
	tr{
	width: -webkit-fill-available;
	}
	td{
	margin: 50px;
	}
	a{
	margin: 10px;
	}

</style>
<meta charset="ISO-8859-1">
<title>Shopping Cart</title>
</head>
<body>

<section id="main-content"> 
	<h2 class="centered"> Solar System Geek Shopping Cart </h2>
	
	<table>
		<tr style="text-align:left"> 
			<th> </th> <th> Name </th> <th> Price </th> <th> Qty </th><th> Total </th>
		</tr>
		
	<c:forEach var="item" items="${items}">
	<tr>
			<td> <img src='<c:url value = "img/${item.imageName}"/>'/> </td>
			<td> ${item.name}</td>		
			<td> ${item.price} </td>
			<td> ${item.quantity}</td>
			<td> ${item.total} </td>	
		</tr>
	</c:forEach>
	<tr>
		<td></td><td></td><td></td>
		<td width="100px"> Grand Total: </td>
		<td> ${grandTotal} </td>
	</tr>
	
	</table>
	
	<div class="centered">
		<a href="<c:url value="/checkout"/>">  Place Order </a>
		<a href="<c:url value="/emptyCart"/>"> Empty Cart </a>
	</div>
	
	
</section>
</body>
</html>