<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	<h2 class="centered"> Alien Travel Calculator</h2>
		
		<c:url var='surveyInputUrl' value='/driveTimeResults' />	
		<form action='${surveyInputUrl}' method='GET'>
		
		<div class="formInputGroup">
			<label for="planet"> Choose a Planet </label>
			<select name="name" id="planet">
				<option value="mercury"> Mercury </option>
				<option value="venus"> Venus </option>
				<option value="earth"> Earth </option>
				<option value="mars"> Mars </option>
				<option value="jupitor"> Jupitor </option>
				<option value="saturn"> Saturn </option>
				<option value="uranus"> Uranus </option>
				<option value="neptune"> Neptune </option>
				
			</select>
			<br>
			<br>
			<label for="travelMode"> Choose Travel Mode </label>
			<select name="travelMode" id="travelMode">
				<option value="walking"> Walking </option>
				<option value="car"> Car </option>
				<option value="bulletTrain"> Bullet Train </option>
				<option value="boeing"> Boeing </option>
				<option value="concorde"> Concorde </option>
			</select>
			<br>			
			<br>
			<label for="age"> Enter Your Earth Age: </label>
			<input type="text" name="age" id="age"/>
			<br>
			<br>
			<input style="margin-left:224px" type="submit" value="Check Your Alien Age"/>
		
		</div>
	</form>
	</section>


</body>
</html>