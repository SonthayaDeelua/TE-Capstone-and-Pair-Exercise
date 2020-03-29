<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>

<html>
<head>
<meta name="viewport" content="width=device-width" />
<title>Recipe Table View</title>
<link rel="stylesheet" href="css/site.css" />
<style>
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 80%;

}

tr:nth-child(even) {
	background-color: white;
}

td, th {
	border: collaps;
	text-align: center;
	background-color: white;

}

tr:top-of-type td:first-of-type {
	border-top-left-radius: 10px;
}

tr:top-of-type td:last-of-type {
	border-top-right-radius: 10px;
}

tr:last-of-type td:first-of-type {
	border-bottom-left-radius: 10px;
}

tr:last-of-type td:last-of-type {
	border-bottom-right-radius: 10px;
}
</style>

</head>
<body>

	<header>
		<h1>MVC Exercises - Views Part 2: Models</h1>
	</header>
	<nav>
		<ul>
			<li><a href="recipeTiles">Tile Layout</a></li>
			<li><a href="recipeTable">Table Layout</a></li>
		</ul>

	</nav>

	<table align="center">
		<tr>
			<td style="border-top-left-radius: 10px"></td>
			<td></td>
			<td style="font-size: 150%;"><b>recipes</b></td>
			<td style="border-top-right-radius: 10px"></td>

		</tr>

		<tr>
			<td style="width: 10%; background-color: white;"></td>
			<c:forEach var="recipe" items="${recipes}">
				<c:url value='/recipeDetails?recipeId=${recipe.recipeId}'
					var='recipeId' />
				<td style="width: 30%"><a href="${recipeId}"><img
						src='<c:url value="/img/recipe${recipe.recipeId}.jpg"></c:url>'
						height="110" /></a></td>
			</c:forEach>

		</tr>

		<tr>
			<td id="title" style="background-color: white;">Name</td>

			<c:forEach var="recipe" items="${recipes}">
				<td style="background-color: lightgray;"><c:out
						value="${recipe.name}" /></td>
			</c:forEach>
		</tr>


		<tr>
			<td id="title">Type</td>

			<c:forEach var="recipe" items="${recipes}">
				<td><c:out value="${recipe.recipeType}" /></td>
			</c:forEach>
		</tr>

		<tr>
			<td id="title" style="background-color: white;">Cook Time</td>

			<c:forEach var="recipe" items="${recipes}">
				<td style="background-color: lightgray;"><c:out
						value="${recipe.cookTimeInMinutes}" /></td>
			</c:forEach>
		</tr>

		<tr>
			<td id="title">Ingredients</td>

			<c:forEach var="recipe" items="${recipes}">
				<c:set var="numberOfIngredients"
					value="${fn:length(recipe.ingredients)}" />
				<td><c:out value="Ingredients: ${numberOfIngredients}" /></td>
			</c:forEach>
		</tr>

		<tr>
			<td id="title" style="background-color: white">Rating</td>

			<c:forEach var="recipe" items="${recipes}">

				<td style="background-color: lightgray;"><c:choose>
						<c:when test="${recipe.averageRating >= 5}">
							<img src='<c:url value="/img/5-star.png"></c:url>' height="25" />
						</c:when>
						<c:when test="${recipe.averageRating >= 4}">
							<img src='<c:url value="/img/4-star.png"></c:url>' height="25" />
						</c:when>
						<c:when test="${recipe.averageRating >= 3}">
							<img src='<c:url value="/img/3-star.png"></c:url>' height="25" />
						</c:when>
						<c:when test="${recipe.averageRating >= 2}">
							<img src='<c:url value="/img/2-star.png"></c:url>' height="25" />
						</c:when>
						<c:otherwise>
							<img src='<c:url value="/img/1-star.png"></c:url>' height="10" />
						</c:otherwise>
					</c:choose></td>
			</c:forEach>

		</tr>
		<tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>

	</table>