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
<!-- ^ COPY HERE AND UP ^	 -->
			
<title>Sample HTML/JSP Page</title>
</head>
<body>

	<%-- <div class="form">
				<h1>New Form Item</h1>
				
				<form:form action="/ninjas/new" method="POST" modelAttribute="ninja">
				<div class="form-group">
					<form:label path="firstName">First Name:
					<form:errors path="firstName"/>
					<form:input path="firstName"/>
				</form:label>
				</div>
					<div class="form-group">
					<form:label path="lastName">Last Name:
					<form:errors path="lastName"/>
					<form:input path="lastName"/>
				</form:label>
				</div>
				<div class="form-group">
					<form:label path="dojo">Dojo:
					<form:errors path="dojo"/>
					<form:select path="dojo">		
						<c:forEach items="${dojos}" var="dojo">
							<form:option value="${dojo.id}">${dojo.name}</form:option>
						</c:forEach>
					</form:select>
					</form:label>
				</div> 
					<button>Create Ninja</button>
				</form:form>
		</div> --%>



</body>
</html>