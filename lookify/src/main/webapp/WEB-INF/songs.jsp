<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Song Page</title>
</head>
<body>
	<h3>Title</h3>
	<c:out value="${song.name}"></c:out>
	<h3>Artist</h3>
	<c:out value="${song.artist}"></c:out>
	<h3>Rating (1-10)</h3>
	<c:out value="${song.rating}"></c:out>
	<br>
	<a href="/songs/delete/${song.id}">Delete</a>
	<br>
	<a href="/dashboard">Dashboard</a>
</body>
</html>