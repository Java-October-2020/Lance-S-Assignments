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
<title>View Product</title>
</head>
<body>
<div class="container">
	<h1>${product.name}</h1>
	<h3>${product.description}</h3>
	
	<ul>
		
	</ul>
	
				<form action="/product/${id}" method="POST">
				<div class="form-group">
					<select name="categories">		
						<c:forEach items="${categories}" var="c">
							<option value="${c.id}">${c.name}</option>
						</c:forEach>
					<select>
				</div>
				<button>Submit</button>
				</form>
				
</div>
</body>
</html>