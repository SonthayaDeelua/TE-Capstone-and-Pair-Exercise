<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>


<html>
<head>
<meta name="viewport" content="width=device-width" />
<title>Recipe Detail View</title>
<link rel="stylesheet" href="css/site.css" />
<style>
table {
	font-family: arial, sans-serif;
	border-collapse:separate;
	width: 80%;
	font-size:small;
}
td, th {
	border: collaps;
	text-align: left;
	margin: 10px;

</style>
</head>
<body>
	<header>
		<h1>MVC Exercises - Views Part 2: Models</h1>
	</header>

	<section id="main-content">
	<table>
		<tr>
		<td><img src='<c:url value="/img/recipe${recipe.recipeId}.jpg"></c:url>'
			height="130" /> 
		</td>
		<td>
		<b>${recipe.name}</b><br> 
		${recipe.recipeType}<br><br>
		<b>Cook Time</b>&nbsp;${recipe.cookTimeInMinutes}&nbsp;<h>minute</h><br><br>
		${recipe.description}<br>
		</td>
		</tr>	
	</table>
	
	<table>
		<tr>
		<td style="width: 100%;">
			<b>Ingredients</b><br>
		<ul>
			<c:forEach var="ingredient" items="${recipe.ingredients}">
				<li><c:out value="${ingredient.quantity}" />
					<c:out value="${ingredient.name}" />
				</li>
			</c:forEach>
		</ul>
		</td>
		</tr>
		</table>
		<hr>
		<table>
		<tr>
		<td style="width: 100%;">
		<b>Preparation</b>
		<ol>
			<c:forEach var="steps" items="${recipe.preparationSteps}">
				<li><c:out value="${steps}" /></li>

			</c:forEach>
		</ol>
		</td>
		</tr>
	</table>
	</section>
</body>
</html>