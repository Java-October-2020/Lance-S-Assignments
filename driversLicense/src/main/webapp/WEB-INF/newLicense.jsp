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
<link rel="stylesheet" href="/css/stylesheet.css"/>
<meta charset="ISO-8859-1">
<title>New License</title>
</head>
<body>
	<c:forEach items="${persons}" var="person">
		<p>${person.firstName}</p>
	</c:forEach>
	<div class="container">
		<div class="header">
			<h3>Drivers License Database</h3>
		</div>
		<div id="form">
				<h1>New Person</h1>
				<form:form action="/licenses/new" method="POST" modelAttribute="ninja">
				<div class="form-group">
					<form:label path="person">Person
					<form:errors path="person"/>
					<form:select path="person">
						<c:forEach items="${persons}" var="p">
							<form:option value="${p.id}">${p.firstName} ${p.lastName}</form:option>
						</c:forEach>
					</form:select>
					</form:label>
				</div>
				<div class="form-group">
					<form:label path="state">State
					<form:errors path="state"/>
					<form:input path="state"/>
					</form:label>
				</div>
				<div class="form-group">
					<form:label path="expiration_date">Expiration Date:
					<form:errors path="expiration_date"/>
					<form:input type="date" class="form-control" path="expiration_date"/>
					</form:label>
				</div>
				<button>Create License</button>
				</form:form>
		</div>
		<div class="contents">
			<a href="/persons/new">Back to create a Person</a>
		</div>
	</div>
</body>
</html>