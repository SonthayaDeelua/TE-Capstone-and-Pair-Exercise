<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
	<tr>
	<td>
	
	<img  src='<c:url value = "img/${travelAgeCalculator.name}.jpg"/>'/>
	<c:set var="ageAtPlanet" value="${travelAgeCalculator.ageAtReached}"/>
	</td>
	<td valign="top">

	<h2> Traveling by ${travelAgeCalculator.travelMode} You will reach ${travelAgeCalculator.name} in	
	${travelAgeCalculator.yearsOfTravel} years. And you will be ${ageAtPlanet} years old.
	
	</h2>
	</td>
	</tr>
	</table>

</body>
</html>