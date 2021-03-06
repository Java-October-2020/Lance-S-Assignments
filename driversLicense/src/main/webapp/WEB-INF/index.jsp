<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
	<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
		rel="stylesheet" 
		integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
		crossorigin="anonymous">
		<link href="/css/stylesheet.css" rel="stylesheet" type="text/css"/>
<meta charset="ISO-8859-1">
<title>New Person</title>
</head>
<body>
	<div class="container">
		<div class="header">
			<h3>Drivers License Database</h3>
		</div>

		<div id="form">
				<h1>New Person</h1>
				<form:form action="/persons/new" method="POST" modelAttribute="person">
				<div class="form-group">
				<form:label path="firstName">First Name:
				<form:errors path="firstName"/>
				<form:input path="firstName"/>
				</form:label>
				</div>
				<div class="form-group">
				<form:label path="lastName">Last Name:
				<form:errors path="lastName"/>
				<form:input path="lastName"/>
				</form:label>
				</div>

				<button>Add Song</button>
				</form:form>
		</div>
		<div class="contents">
			<a href="/licenses/new">Create a new license</a>
		</div>
	</div>
</body>
</html>