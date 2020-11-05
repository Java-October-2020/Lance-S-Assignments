<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Top Ten</title>
</head>
<body>
	<h3>Top 10 Songs: </h3>
		<table class= "table-dark">
			<thead>
				<th>Name</th>
				<th>Rating</th>
				<th>Actions</th>
			</thead>
			<tbody>
				<c:forEach items="${topTen}" var="song">
					<tr>
						<td><a href="/songs/${song.id}">${song.name}</a></td>
						<td>${song.rating}</td>
						<td><a href="/songs/delete/${song.id}">delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br>
		<a href="/dashboard">Dashboard</a>
	
</body>
</html>