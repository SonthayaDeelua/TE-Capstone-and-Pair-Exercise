<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
<section id="main-content"> 
	<h2 class="centered"> Solar System Geek Gift Shop </h2>
	
	<c:forEach var="product" items="${products}">
	<div>
		<c:url var="productDetail" value="/productDetail?productId=${product.id}"/>
		<a href="${productDetail}"> <img src='<c:url value = "img/${product.imageName}"/>'/> </a>
		<div style="display:inline-block; width:60%; position:relative; top:-105px">
			<p> ${product.name}</p>		
			<p style="color:blue"> ${product.price} </p>
		</div>	
	</div>
	</c:forEach>
	
	
</section>

</body>
</html>