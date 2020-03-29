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
	
	<div>
		<img src='<c:url value = "img/${product.imageName}"/>'/>
		<div style="display:inline-block; width:60%; position:relative; top:-26px">
			<p> ${product.name}</p>		
			<p style="color:blue"> ${product.price} </p>
			<p> ${product.description} </p>
			<c:url var="addToCart" value="/productDetail"/>
			<form action="${addToCart}" METHOD="POST">
				<div>
					<label for ="Quantity"> Quantity to buy</label>
					<input type = "text" name="quantity" id = "quantity"/>
					<input type="submit" value="Submit!"/>
				</div>
			</form>
		</div>	
	</div>

</section>

</body>
</html>