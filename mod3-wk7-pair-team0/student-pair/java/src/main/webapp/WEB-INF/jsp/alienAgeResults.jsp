<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<c:import url="/WEB-INF/jsp/common/header.jsp" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<section id="main-content"> 
	<table>
	<tr>
	<td>
	
	<img  src='<c:url value = "img/${ageCalculator.name}.jpg"/>'/>
	<c:set var="planetAge" value="${(365.26*ageCalculator.age) / ageCalculator.planetEarthDays}"/>
	</td>
	<td valign="top">
	<h2 > If you are ${ageCalculator.age} years old on Earth, then your are 	
	<fmt:formatNumber type="number" maxFractionDigits="2" value="${planetAge}"/>
	 ${ageCalculator.name}
	years old. </h2>>
	</td>
	</tr>
	</table>
	</section>

</body>
</html>