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
	<title>Add a Dojo</title>
	</head>
<body>
	<div class="container">
		<div class="header">
			<h3>Dojos and Ninjas Database</h3>
		</div>
		<div class="form">
				<h1>New Dojo</h1>
				<form:form action="/dojo/new" method="POST" modelAttribute="dojo">
				<div class="form-group">
					<form:label path="name">Name:
					<form:errors path="name"/>
					<form:input path="name"/>
				</form:label>
				</div>
					<button>Create Dojo</button>
					</form:form>
		</div>	
		
		<div class="contents">
			<a href="/ninjas/new">Create a new Ninja</a>
			<table class="table-dark">
				<thead>
					<th>Dojo Name</th>
				</thead>
				<tbody>
					<c:forEach items="${dojos}" var="dojo">
						<tr>
							<td>
								<a href="/dojos/${dojo.id}">${dojo.name}</a> 
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>