<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Book</title>
</head>
<body>
	<h1>Title: </h2>
	<p><c:out value="${book.title}"/></p>
	<h3>Description: </h3>
	<p><c:out value="${book.description}"/></p>
	<h3>Language: </h3>
	<p><c:out value="${book.language}"/></p>
	<h3>Pages: </h3>
	<p><c:out value="${book.pages}"/></p>
	<a href="">Edit Book</a>
</body>
</html>