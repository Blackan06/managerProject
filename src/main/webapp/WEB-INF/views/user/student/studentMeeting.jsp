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
	<c:set var="message" value="${message}" />
	<c:if test="${message!=''}">
		<script type="text/javascript">
			var Msg = "${message}";
			window.alert(Msg);
		</script>
	</c:if>
	<div class="header" th:fragment="headerfrag">
		<!-- -----------------HEADER-------------------- -->
		<%@include file="/WEB-INF/views/user/student/header.jsp"%>
		<!-- -----------------END OF HEADER-------------------- -->
		<!-- -----------------MENU BAR-------------------- -->
		<%@include file="/WEB-INF/views/user/student/menubar.jsp"%>
		<!-- -----------------END OF MENU BAR-------------------- -->
	</div>


	<!-- ---------------------CONTENT--------------------- -->



	<div class="main-panel">
		<div class="content-wrapper">
			<div class="row">
				<div class="col-lg-12 grid-margin stretch-card">
					<table class="table table-striped ">
						<thead>
							<tr>
								<!-- <th scope="col">#</th> -->
								<th scope="col">Name Meeting</th>
								<th scope="col">Date Meeting</th>
								<th scope="col">Time Meeting</th>
								<th scope="col">Link Meeting</th>
								<th scope="col">Upload Content</th>
							</tr>
						</thead>
						<tbody>
							<c:set var="count" value="1" scope="page" />
							<c:forEach var="scheduleMeeting" items="${scheduleMeetingList}">
								<tr>
									<!--	<th scope="row">${count}</th>-->
									<td>${scheduleMeeting.name }</td>
									<td>${scheduleMeeting.timeMeeting }</td>
									<td>${scheduleMeeting.time }</td>
									<td><a class="nav-link"
										href="${scheduleMeeting.link_meeting}" target="_blank">Meeting
											Url</a></td>
									<td><c:if test="${scheduleMeeting.up == 1}">
											<a class="btn btn-primary"
												href="${pageContext.request.contextPath}/uploadMeeting/${scheduleMeeting.id}"
												role="button">Edit</a>
										</c:if> <c:if test="${scheduleMeeting.up == 0}">
											<a class="btn btn-primary"
												href="${pageContext.request.contextPath}/uploadMeeting/${scheduleMeeting.id}"
												role="button">Upload</a>
										</c:if></td>
								</tr>
								<c:set var="count" value="${count + 1}" scope="page" />
							</c:forEach>
						</tbody>
					</table>
				</div>
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