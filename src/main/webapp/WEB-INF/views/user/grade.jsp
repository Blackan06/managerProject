<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Grade</title>
<style>
.error {
	color: red;
}
</style>
</head>
<body>
	<h1 style="text-align: center;">GRADE FOR REPORT</h1>
	<form:form action="${pageContext.request.contextPath}/processGrade"
		method="POST" modelAttribute="report">
		<form:hidden path="id" />
		<form:input path="name" readonly="true" />
		<br>
		<form:input path="timeSubmit" readonly="true" />
		<br>
		<form:input path="point" />		
		<form:errors path="point" cssClass="error" />
		<br>
		<a href="#">Download</a>
		<br>
		<input type="submit" />
	</form:form>
</body>
</html>