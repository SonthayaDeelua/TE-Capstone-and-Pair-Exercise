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
	
		<h3 class = "centered"> New Geek Post </h3>
	
		<c:url var='surveyInputUrl' value='/postAForum'/>
		<form action='${surveyInputUrl}' method = 'POST'>
		<div>
			<label for="userName">Username</label>
			<input type="text" name="userName" id="username"/>
		</div>
		<div>
			<label for="subject">Subject</label>
			<input type="text" name="subject" id="username"/>
		</div>
		<div>
			<label for="message" > Message </label> 
			<textarea name ="message" id="message" rows="4" cols="30"></textarea>
		</div>
		<div>
			<input style="margin-left:224px" type="submit" value="Submit!"/>
		</div>
		</form>
	</section>

</body>
</html>