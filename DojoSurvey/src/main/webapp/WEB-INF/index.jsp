<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Dojo Survey Index</title>
		<link rel= "stylesheet" href="style.css">
	</head>
	<body>
		<form method="POST" action="/login">
			<div id=divForm>
				<div id="name">
					<label>Your Name: <input type="text" name="name"></label>
				</div>
				<div id="location">
					<label>Dojo Location</label>
					<select name="location">
						<option value="SJ">SJ</option>
						<option value="Atlanta">Atlanta</option>
					</select>
				</div>
				<div id="language">
					<label>Favorite Language</label>	
					<select name="language">
						<option value="Python">Python</option>
						<option value="Java">Java</option>
					</select>
				</div>
				<div id="text">
					<textarea id="text" name="text" rows="4" cols="50"></textarea>
				</div>
				<button>Button</button>
			</div>	
		</form>
	</body>
</html>