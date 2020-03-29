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
	
	<img  src='<c:url value = "img/${weightCalculator.name}.jpg"/>'/>
	<c:set var="planetWeight" value="${weightCalculator.planetWeight}"/>
	</td>
	<td valign="top">

	<h2 class ="valign = top"> If you are ${weightCalculator.earthWeight} lbs on planet Earth, you would weight 	
	<fmt:formatNumber type="number" maxFractionDigits="2" value = "${planetWeight}" /> lbs on
	 ${weightCalculator.name}
	</h2>
	</td>
	</tr>
	</table>
	</section>

</body>
</html>