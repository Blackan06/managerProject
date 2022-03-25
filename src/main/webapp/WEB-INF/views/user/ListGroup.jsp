<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>KIET</h1>
	<a href="AddGroup">Add Group</a>
	<c:forEach var="items" items="${ group4 }" varStatus="counter">
		<c:if test="${not empty items }" />

		<table border="2" cellpadding="7">
			<thead>
				<tr>
					<th>.NO</th>
					<th>ID</th>
					<th>Name</th>
					<th>ViewProject</th>
					<th>ViewStudent</th>
					<th>DELETE</th>
					<th>Edit</th>
					
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${counter.index + 1 }</td>
					<td>${ items.id }</td>
					<td>${ items.name }</td>
					<td><a href='<c:url value="Project/${ items.id }"></c:url>'>ViewProject</a></td>
					<td><a href='<c:url value="group/${ items.id }"></c:url>'>ViewStudent</a></td>
					<td><a href='<c:url value="/deleteGroup?id=${items.id}"></c:url>'>DELETE</a></td>
					<td><a href='<c:url value="/editgroup?id=${items.id}"></c:url>'>Edit</a></td>
				</tr>
			</tbody>
		</table>
	
	</c:forEach>
	<h1 align="center">List Student</h1>
	<c:forEach var="item" items="${ group3 }" varStatus="counter">
		
		<c:if test="${not empty item }" />
		<div align="center">
			
			<table border="2" cellpadding="7">
				<thead>
					<tr>
						<th>.NO</th>
						<th>ID</th>
						<th>Name</th>
						<th>Mail</th>
						<th>Role</th>
						<th>GroupID</th>
						<th>DELETE</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>${counter.index + 1 }</td>
						<td>${ item.id }</td>
						<td>${ item.name }</td>
						<td>${ item.mail }</td>
						<td>${ item.role }</td>
						<td>${ item.group_id }</td>

						<td><a href='<c:url value="/editAccount?id=${item.id}"></c:url>'>Edit</a></td>
					</tr>
				</tbody>
			</table>
		</div>


	</c:forEach>

</body>
</html>