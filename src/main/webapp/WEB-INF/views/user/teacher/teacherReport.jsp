<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
<%@include file="/WEB-INF/views/user/teacher/linkHeader.jsp"%>
</head>

<body style="overflow: visible;">

	<div class="header">
		<!-- -----------------HEADER-------------------- -->
		<%@include file="/WEB-INF/views/user/teacher/header.jsp"%>
		<!-- -----------------END OF HEADER-------------------- -->
		<!-- -----------------MENU BAR-------------------- -->
		<%@include file="/WEB-INF/views/user/teacher/menubar.jsp"%>
		<!-- -----------------END OF MENU BAR-------------------- -->
	</div>


<<<<<<< HEAD

=======
>>>>>>> 63a45f17d796caf98af160dff3e2b3447cfcab45
			<!-- partial -->
			<div class="main-panel">
				<div class="content-wrapper">
					<div class="row">
						<div class="col-lg-12 grid-margin stretch-card">
							<div class="card">
								<div class="card-body">


									<div class="table-responsive">
										

										<table class="table table-striped project-orders-table">
											<thead>
												<tr>
													<th>Report Name</th>

													<th>Time Submit</th>
													<th>Download</th>													
													<th>Group Name</th>
													<th>Status</th>
													<th>Action</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="report" items="${reportList}">
													<c:set var="group" value="${ report.group  }" />
													<tr>
														<td>${report.name }</td>

														<td>${report.timeSubmit}</td>
														<td><a
															href='<c:url value="/report_stogare/${report.urlReport}"/>'
															download>${report.urlReport}</a></td>														
														<td>${group.name}</td>
														<td>${report.convertedStatus}</td>
														<td>
															<!--khi da summit thi doi background khac  --> <c:if
																test="${report.status > 0}">

																<button>
																	<a class="btn btn-primary" href='<c:url  value="/grading_table/${report.id}"/>' >Grade</a>
																</button>
															</c:if> <!--khi chua summit thi doi background khac  -->
															 <c:if
																test="${report.status < 1}">
																<button disabled="disabled">
																	<a href="" class="btn btn-primary">Grade</a>
																</button>
															</c:if>
														</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>

									</div>
								</div>
<<<<<<< HEAD

	<!-- partial -->
	<div class="main-panel">
		<div class="content-wrapper">




			<div class="row">


				<div class="col-lg-12 grid-margin stretch-card">
					<div class="card">
						<div class="card-body">


							<div class="table-responsive">


								<table class="table table-striped project-orders-table">
									<thead>
										<tr>
											<th>Report Name</th>

											<th>Time Submit</th>
											<th>Download</th>
											<th>Group Name</th>
											<th>Status</th>
											<th>Action</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="report" items="${reportList}">
											<c:set var="group" value="${ report.group  }" />
											<tr>
												<td>${report.name }</td>

												<td>${report.timeSubmit}</td>
												<td><a
													href='<c:url value="/report_stogare/${report.urlReport}"/>'
													download>${report.urlReport}</a></td>
												<td>${group.name}</td>
												<td>${report.convertedStatus}</td>
												<td>
													<!--khi da summit thi doi background khac  --> <c:if
														test="${report.status > 0}">

														<button>
															<a href='<c:url value="/grading_table/${report.id}"/>'>Grade</a>
														</button>
													</c:if> <!--khi chua summit thi doi background khac  --> <c:if
														test="${report.status < 1}">
														<button disabled="disabled">
															<a href="">Grade</a>
														</button>
													</c:if>
												</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>


=======
>>>>>>> 63a45f17d796caf98af160dff3e2b3447cfcab45
							</div>
						</div>

					</div>
				</div>

			</div>

		</div>


	</div>


</body>

</html>

