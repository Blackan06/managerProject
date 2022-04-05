


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
<%@include file="/WEB-INF/views/user/student/linkHeader.jsp"%>
</head>

<body style="overflow: visible;">
	<%-- 	<c:set var="message" value="${message}" />
	<c:if test="${message!=''}">
		<script type="text/javascript">
			var Msg = "${message}";
			window.alert(Msg);
		</script>
	</c:if> --%>

	<div class="header" th:fragment="headerfrag">
		<!-- -----------------HEADER-------------------- -->
		<%@include file="/WEB-INF/views/user/student/header.jsp"%>
		<!-- -----------------END OF HEADER-------------------- -->
		<!-- -----------------MENU BAR-------------------- -->
		<%@include file="/WEB-INF/views/user/student/menubar.jsp"%>
		<!-- -----------------END OF MENU BAR-------------------- -->
	</div>


	<!-- ---------------------CONTENT--------------------- -->


	<div class="content-wrapper">

		<div class="row">
			<div class="col-lg-4 grid-margin stretch-card ">
				<h1 style="color: red;">${ statusuploadReport }</h1>
			</div>
			<div class="col-lg-12 grid-margin stretch-card">
				<div class="card">
					<div class="card-body">
						
						<div class="">
							<!-- Simple link -->
							<span style="color: red">${ errorPoint }</span>

						</div>
						<div class="">
							<!-- Simple link -->
							<span style="color: red">${ errorTimeReport }</span>

						</div>
						<c:forEach var="project" items="${ listReport }">
							<c:set var="Report" value="${ project.report }" />

							<div class="table table-striped project-orders-table">


								<table class="table">
									<thead>
										<tr>
											<th>Name Report</th>
											<th>Point</th>
											<th>Comment</th>
											<!--<th>Time Create</th>  -->
											<th>Time Submit</th>
											<th>URL report</th>
											<th>Action</th>

										</tr>
									</thead>
									<tbody>

										<c:forEach var="item" items="${ Report }">
											<tr>
												<td>${ item.name }</td>

												<td><a
													href='<c:url value="/viewPointDetails/${ item.id }"/>'>View
														Point</a></td>




												<td>${ item.comment }</td>
												<!--<td>${ item.timeCreate }</td>-->
												<td>${ item.timeSubmit }</td>


												<td><a download
													href='<c:url value="/report_stogare/${ item.urlReport }"/>'>${ item.urlReport }</a></td>
												<td><a class=""
													href="${pageContext.request.contextPath}/upload_report/${item.id}"
													role="button">Upload</a></td>

											</tr>

										</c:forEach>

									</tbody>
								</table>


							</div>
						</c:forEach>
					</div>

				</div>

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


</html>
