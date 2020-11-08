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
<title>View Question Page</title>
</head>
<body>
	<div class="header">
		<h2>Dojo Overflow</h2>	
	</div>
	
	<div class="container">
		<h1>${question.text}</h1>
		<label for="tags">Tags: </label>
			<c:forEach items="${question.tags}" var="tag">
				${tag.name}
			</c:forEach>
		
		<table class="table">
			<thead>
				<th>Answers:</th>
			</thead>
			
			<tbody>
			<c:forEach items="${question.answers}" var="answer">
				<tr>
					<td>${answer.text}</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		
		<div id="right-form">
			<form action="/questions/${question.id}" method="POST">
			<div class="form-group" id="left-table">
				<label for="answer">Answer question: </label>
				<input type="text" name="answer" id="answer">
			</div>
					<button>Submit</button>
			</form>
		<a href="/questions">Go back</a>
		</div>
	</div>
</body>
</html>