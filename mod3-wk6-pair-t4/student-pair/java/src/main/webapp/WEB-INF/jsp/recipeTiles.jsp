<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>


<html>
<head>
<meta name="viewport" content="width=device-width" />
<title>Recipe List View</title>
<link rel="stylesheet" href="css/site.css" />
<style>
table {
	font-family: arial, sans-serif;
	width: 80%;
	border-collapse: separate;
 	margin: 25px
 	}


td, th {
	border: collaps;
	text-align: left;
	background-color: white;

}



</style>
</head>
<body>
	<header>
		<h1>MVC Exercises - Views Part 1: Models</h1>
	</header>
	<nav>
		<ul>
			<li><a href="recipeTiles">Tile Layout</a></li>
			<li><a href="recipeTable">Table Layout</a></li>
		</ul>

	</nav>
	<section>
	<h1 style="font-size: 150%;"><b>recipes</b></h1>
		<table>
			<c:forEach var="recipe" items="${recipes}">
			<td>
				<div class="tile">
					<div class="image">

						<c:url value='/recipeDetails?recipeId=${recipe.recipeId}'
							var='recipeId' />
						<a href="${recipeId}"> <img
							src='<c:url value="/img/recipe${recipe.recipeId}.jpg"></c:url>'
							height="190" width="320"/><br>
						</a>
					</div>
					<b><c:out value="${recipe.name}"/></b>
					<br><br>
					
						<c:choose>
							<c:when test="${recipe.averageRating >= 5}">
								<c:set var="numberOfIngredients"
								value="${fn:length(recipe.ingredients)}" />

								<h align ="right"><img align="left" src='<c:url value="/img/5-star.png"></c:url>' height="10" />
								<c:out  value="Ingredients: ${numberOfIngredients}" /></h>
							</c:when>
							
							<c:when test="${recipe.averageRating >= 4}">
								<c:set var="numberOfIngredients"
									value="${fn:length(recipe.ingredients)}" />
								<h align ="right"><img align="left" src='<c:url value="/img/4-star.png"></c:url>' height="10" />
							<c:out  value="Ingredients: ${numberOfIngredients}" /></h>
							</c:when>
							
							<c:when test="${recipe.averageRating >= 3}">
							<c:set var="numberOfIngredients"
								value="${fn:length(recipe.ingredients)}" />
								<h align ="right"><img align="left" src='<c:url value="/img/3-star.png"></c:url>' height="10" />
								<c:out  value="Ingredients: ${numberOfIngredients}" /></h>
							</c:when>
							
							<c:when test="${recipe.averageRating >= 2}">	
							<c:set var="numberOfIngredients"
								value="${fn:length(recipe.ingredients)}" />
								<h align ="right"><img align="left" src='<c:url value="/img/2-star.png"></c:url>' height="10" />
								<c:out  value="Ingredients: ${numberOfIngredients}" /></h>
							</c:when>
							
							<c:otherwise>
							<c:set var="numberOfIngredients"
								value="${fn:length(recipe.ingredients)}" />
								<h align ="right"><img align="left" src='<c:url value="/img/1-star.png"></c:url>' height="10" />
								
							<c:out  value="Ingredients: ${numberOfIngredients}" /></h>
							</c:otherwise>
						</c:choose>
			</div>
			</td>
			</c:forEach>
	</table>
	</section>
</body>
	
	
	
	</html>

