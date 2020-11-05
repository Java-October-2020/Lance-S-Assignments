<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Language Page</title>
</head>
<body>
	<h3>Name: </h3>
	<c:out value="${language.name}"/>
	<h3>Creator: </h3>
	<c:out value="${language.creator}"/>
	<h3>Version: </h3>
	<c:out value="${language.version}"/>
	<br>
	<br>
	<a href="/languages/${language.id}/edit">Edit</a>
	<a href="">Delete</a>
	<a href="/languages">Dashboard</a>
</body>
</html>