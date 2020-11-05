<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Counter Page</title>
	</head>
	<body>
		<p>You have visited <a href= "http://localhost:8080/">http://localhost:8080/ </a> ${currCount} times.</p>
		<a href= "http://localhost:8080/">Test another visit?</a>
	</body>
</html>