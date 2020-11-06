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
<title>New Category Page</title>
</head>

<body>
	<div class="header">

	</div>

	<div class="container">
		<div class="form">
			<h1>New Category</h1>
						
				<form:form action="/category/new" method="POST" modelAttribute="category">
				<div class="form-group">
					<form:label path="name">Name:
					<form:errors path="name"/>
					<form:input path="name"/>
				</form:label>
				</div>
					<button>Create Category</button>
				</form:form>
		</div>
	
	</div>
</body>
</html>