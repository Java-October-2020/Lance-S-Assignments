<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Languages Index</title>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
	</head>
	
	<body>
		<div class= "container">
			<div id = "table">
				<table class= "table-dark">
					<thead>
						<th>Name</th>
						<th>Creator</th>
						<th>Version</th>
						<th>Action</th>
					</thead>
					<tbody>
						<c:forEach items="${langs}" var="lang">
							<tr class="table-dark">
								<td><a href="languages/${lang.id}">${lang.name}</a></td>
								<td>${lang.creator}</td>
								<td>${lang.version}</td>
								<td>
									<form:form action="/languages/${lang.id}" method="DELETE">
									<button>Delete</button>
									</form:form>
									<a href="/languages/${lang.id}/edit">edit</a>
								</td>
							</tr>
						</c:forEach>	
					</tbody>
				</table>
			</div>
			<div id="form">
				<form:form action="/languages" method="POST" modelAttribute="language">
				<div class="form-group">
				<form:label path="name">Name:
				<form:errors path="name"/>
				<form:input path="name"/>
				</form:label>
				</div>
				<div class="form-group">
				<form:label path="creator">Creator:
				<form:errors path="creator"/>
				<form:input path="creator"/>
				</form:label>
				</div>
				<div class="form-group">
				<form:label path="version">Version:
				<form:errors path="version"/>
				<form:input path="version"/>
				</form:label>
				</div>
				<button>Add Language</button>
				</form:form>
			</div>
			
		</div>
	</body>
</html>