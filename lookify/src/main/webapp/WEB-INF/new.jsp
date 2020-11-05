<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add a song</title>
</head>
<body>
 			<div id="form">
				<form:form action="/songs/new" method="POST" modelAttribute="song">
				<div class="form-group">
				<form:label path="name">Name:
				<form:errors path="name"/>
				<form:input path="name"/>
				</form:label>
				</div>
				<div class="form-group">
				<form:label path="artist">Artist:
				<form:errors path="artist"/>
				<form:input path="artist"/>
				</form:label>
				</div>
				<div class="form-group">
				<form:label path="rating">Rating:
				<form:errors path="rating"/>
				<form:input path="rating"/>
				</form:label>
				</div>
				<button>Add Song</button>
				</form:form>
			</div>
			<br>
			<a href="/dashboard">Dashboard</a>
</body>
</html>