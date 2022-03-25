<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
<%@include file="/WEB-INF/views/user/student/linkHeader.jsp"%>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css">
</head>

<body style="overflow: visible;">

	<div class="header" th:fragment="headerfrag">
		<!-- -----------------HEADER-------------------- -->
		<%@include file="/WEB-INF/views/user/student/header.jsp"%>
		<!-- -----------------END OF HEADER-------------------- -->
		<!-- -----------------MENU BAR-------------------- -->
		<%@include file="/WEB-INF/views/user/student/menubar.jsp"%>
		<!-- -----------------END OF MENU BAR-------------------- -->
	</div>


	<!-- ---------------------CONTENT--------------------- -->
	<c:set var="project" value="${project}" />
	<c:set var="teacher" value="${teacher}" />
	<div class="main-panel">
		<div class="content-wrapper">
			<div class="row" style="display: flex; align-items: center;justify-content: center;">
				<ul class="list-group">
					<li class="list-group-item active"><h4>Your project</h4></li>
					<li class="list-group-item"><h6>Project Name:
							${project.name}</h6></li>
					<li class="list-group-item"><h6>Creating Time:
							${project.createTime}</h6></li>
					<li class="list-group-item"><h6>Teacher: ${teacher.name}</h6></li>
				</ul>
			</div>
		</div>
	</div>
	<!-- ---------------------END OF CONTENT--------------------- -->

	<!-- -----------------FOOTER-------------------- -->
	<!-- -----------------END OF FOOTER-------------------- -->

	<!-- Script-->
	<%@include file="/WEB-INF/views/user/student/studentscript.jsp"%>
</body>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js"
	integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js"
	integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
	crossorigin="anonymous"></script>
</html>