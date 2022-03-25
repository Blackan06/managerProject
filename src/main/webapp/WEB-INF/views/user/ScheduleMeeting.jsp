<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Schedule Report</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>


	

	<div class="container">
		<h2>MEETING</h2>

		<table class="table table-striped" border="1">


			<thead>
				<tr>
					<th>ID</th>
					<th>TimeMeeting</th>
					<th>ProjectID</th>
					<th>AccountID</th>
					<th>ViewsMeeting</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
			</thead>
			<tbody>
				<a href="addScheduleMeeting">ADD MEETING</a>
				<c:forEach var="item" items="${ ScheduleMeeting }">
					<tr>
						<td>${ item.id }</td>
						<td>${ item.timeMeeting }</td>
						<td>${ item.project_id }</td>
						<td>${ item.account_id  }</td>
						<td>
							<a href='<c:url value="/ScheduleMeeting/${item.id}"></c:url>'>Views</a>
							
						</td>
						<td>
							<a href='<c:url value="/editScheduleMeeting?id=${ item.id }"></c:url>'>Edit</a>
						</td>
						<td>
							<a href='<c:url value="/deleteScheduleMeeting?id=${ item.id }"></c:url>'>Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>

		</table>
		

	</div>


</body>
</html>