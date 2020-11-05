<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="iso-8859-1">
		<title>Insert title here</title>
		<link rel= "stylesheet" href="style.css">
	</head>
	<body>
		<div id = divResult>
		<label>Name: </label> ${name}
		<br>
		<label>Location: </label> ${location}
		<br>
		<label>Language: </label> ${language}
		<br>
		<label>Comment: </label> ${textForm}
		<button onclick="/index.jsp">Go Back</button>
		</div>
	</body>
</html>