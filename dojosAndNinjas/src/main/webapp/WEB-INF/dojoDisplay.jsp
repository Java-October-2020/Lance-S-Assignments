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
				
	<link href="/css/stylesheet.css" rel="stylesheet" type="text/css"/>
	
	<title>View Dojo</title>
</head>

<body>
	<div class="container">
		<div class="header">
			<h3>Dojos and Ninjas Database</h3>
		</div>
		<div class="contents">
			<h1>${dojo.name}</h1>
			<table>
				<thead>
					<th>First Name</th>
					<th>Last Name</th>
				</thead>
				<tbody>
				<c:forEach items="${ninjas}" var="ninja">
				<tr>
					<td>${ninja.firstName}</td>
					<td>${ninja.lastName}</td>
				</tr>
				</c:forEach>
				</tbody>
			</table>
			<a href="/dojo/new">Back to homepage</a>
		</div>
	</div>
</body>
</html>