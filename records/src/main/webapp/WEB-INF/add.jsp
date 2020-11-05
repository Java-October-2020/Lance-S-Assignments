<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add A Record</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
	<div class= "container">
	<c:forEach items= "${errors}" var="error">
		<p>${error}</p>
	</c:forEach>
	<!-- old form for non JPA validations  -->
		<!-- <form action= "/add" method= "POST">
			<div class= "form-group">
				<label for= "name">Name</label>
				<input type= "text" name= "name">
			</div>
			<div class= "form-group">
				<label for= "artistName">Artist Name</label>
				<input type= "text" name= "artistName">
			</div>
			<div class= "form-group">
				<label for= "year">Year</label>
				<input type= "text" name= "year">
			</div>
		<button>Add Album</button>
		</form> -->
	
		<form:form method="POST" action="/add" modelAttribute="record">
			<div class="form-group">
				<form:label path="artistName">Artist Name:
				<%-- <form:errors path="artistName"/> --%>
				<form:input path="artistName"/>
				</form:label>
			</div>
			<div class="form-group">
				<form:label path="albumName">Album Name:
				<%-- <form:errors path="albumName"/> --%>
				<form:input path="albumName"/>
				</form:label>
			</div>
			<div class="form-group">
				<form:label path="year">Year:
				<%-- <form:errors path="year"/> --%>
				<form:input path="year"/>
				</form:label>
			</div>
			<button>Add Record</button>
		</form:form>
	</div>

</body>
</html>