<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
		rel="stylesheet" 
		integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
		crossorigin="anonymous">
<link rel="stylesheet" href="/css/stylesheet.css"/>
<meta charset="ISO-8859-1">
<title>Display</title>
</head>
<body>
	<div class="container">
		<div class="header">
			<h3>Drivers License Database</h3>
		</div>
		<div class="contents">
			<h1>${person.firstName} ${person.lastName}</h1>
			<h3><strong># : </strong>${person.license.getNumber()}</h3>
		    <h3><strong>State : </strong>${person.license.getState()}</h3>
			<a href="/persons/new">Back to create a Person</a>
		</div>
	</div>

</body>
</html>