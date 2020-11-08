<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
			<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
				rel="stylesheet" 
				integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
				crossorigin="anonymous">
			<link rel="stylesheet" href="/css/style.css">
<title>New Question Page</title>
</head>
<body>
	<div class="header">
		<h2>Dojo Overflow</h2>
	</div>
	<div class="container">
		<div class="center-form">
				<h1>What is your question?</h1>
				
				<form action ="/questions/new" method="POST">
				<div class="form-group">
					<label for="text">Question: </label>
					<input type="text" name="text" id="text"/>
				</div>
				<div class="form-group">
					<label for="tag">Tags:</label>
					<input type="text" name="formTag" id="tag"/>
					<p>*Must be all lowercase/maximum 3 tags*</p>
				</div>
					<button>Submit</button>
				</form>
		</div>	
	</div>
		<div class="center-contents">
			<a href="/questions">Go back</a>
			<br>
			<p class="errors">${errors}</p> 
		</div>
</body>
</html>