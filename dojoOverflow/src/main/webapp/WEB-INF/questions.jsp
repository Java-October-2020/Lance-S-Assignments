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
<title>Questions Dashboard</title>
</head>
<body>
	<div class="header">
		<h2>Dojo Overflow</h2>
	</div>
	
	<div class="container">
	
		<table class="table-dark">
			<thead>
				<th>Questions: </th>
				<th>Tags: </th>
			</thead>
			<tbody>
			<c:forEach items="${qList}" var="q">
				<tr>
					<td><a href="/questions/${q.id}">${q.text}</a></td>
					<td>
						<c:forEach items="${q.tags}" var="tag">
							${tag.name}
						</c:forEach>						
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
	
	<div class="contents">
		<a href="/questions/new">New Question</a>
	</div>
	
</body>
</html>