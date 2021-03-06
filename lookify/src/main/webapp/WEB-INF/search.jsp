<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<title>Search Page</title>
</head>
<body>
	<div class= "container">
		<p>Songs by artist: <c:out value="${artist}"></c:out></p>
		<form action="/search">
			<input type="text" name="artist" value="${artist}"/>
			<button class="btn btn-primary">New Search</button>
		</form>
		<table class= "table-dark">
			<thead>
				<th>Name</th>
				<th>Rating</th>
				<th>Actions</th>
			</thead>
			<tbody>
				<c:forEach items="${songs}" var="song">
					<tr>
						<td><a href="/songs/${song.id}">${song.name}</a></td>
						<td>${song.rating}</td>
						<td><a href="/songs/delete/${song.id}">delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="/dashboard">Dashboard</a>
	</div>
</body>
</html>