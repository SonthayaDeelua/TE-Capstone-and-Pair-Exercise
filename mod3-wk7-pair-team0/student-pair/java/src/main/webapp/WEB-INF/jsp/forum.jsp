<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

    
<c:import url="/WEB-INF/jsp/common/header.jsp" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
	<section id="main-content"> 
	
		<h3 class = "centered"> Solar System Geek Forum </h3>
		<div class="posts">
		<c:url var="postAMessageHref" value="/postAForum"/>
		<a class="centered" href="${postAMessageHref}"> Post a message</a>
		<c:set var="x" value="0"/>
		<c:forEach var="post" items="${posts}">
			<div class="post">
		 		<h4><c:out value="${post.subject}"/></h4>
		 		<p><c:out value="by ${post.username} on ${post.postDate} at ${post.postTime}"/></p>
		 		<p class = "message"><c:out value="${post.message} "/></p>
		 	</div>
		</c:forEach>
		</div>
	</section>

</body>
</html>