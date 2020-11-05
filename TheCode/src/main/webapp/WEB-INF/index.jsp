<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Index</title>
	</head>
	<body>
		<h2>What is the code?</h2>
		<form method="POST" action="/login">
	    <label>Username: <input type="text" name="username"></label>
	    <label>Password: <input type="password" name="password"></label>
	    <button>Login</button>
</form>
	</body>
</html>