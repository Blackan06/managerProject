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
			<!-- partial -->
			<div class="main-panel">
				<div class="content-wrapper">

					<div class="row">

						<div class="col-lg-12 grid-margin stretch-card">
							<div class="card">
								<div class="table-responsive pt-3">
								
									<table class="table table-striped project-orders-table">
										<thead>
											<tr>
												<th>Report Name</th>
												<th>Time Report</th>
												<th>Group Name</th>
											
											</tr>
										</thead>
										<tbody>
											<c:forEach var="scheduleReport" items="${scheduleReports}">
											<tr> 
												<c:set var="report" value="${scheduleReport.report}" />
												<c:set var="group" value="${scheduleReport.group}" />
													<td>${report.name}</td>
												<td>${scheduleReport.timeReport }</td>
											
												<td>${group.name}</td>
											
												</tr>
											</c:forEach>

										</tbody>
									</table>
								</div>
							</div>

						</div>

					</div>

				</div>


			</div>


</body>

</html>

