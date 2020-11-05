<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Page</title>
</head>
<body>
		<div id="form">
				<form:form method="POST" action="/languages/${language.id}" modelAttribute="language">
				<div class="form-group">
				<form:label path="name">Name:
				<form:errors path="name"/>
				<form:input path="name" value="${langVar.name}"/>
				</form:label>
				</div>
				<div class="form-group">
				<form:label path="creator">Creator:
				<form:errors path="creator"/>
				<form:input path="creator" value="${langVar.creator}"/>
				</form:label>
				</div>
				<div class="form-group">
				<form:label path="version">Version:
				<form:errors path="version"/>
				<form:input path="version" value="${langVar.version}"/>
				</form:label>
				</div>
				<button>Update Language</button>
			</form:form>
		</div>
		<a href="/languages">Dashboard</a>
		<a href="">Delete</a>
</body>
</html>