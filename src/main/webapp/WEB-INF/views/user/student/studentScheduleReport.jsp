
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
<%@include file="/WEB-INF/views/user/student/linkHeader.jsp"%>
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
	
	<div class="main-panel">
		<div class="content-wrapper">
			<div class="row">
				<div class="col-lg-12 grid-margin stretch-card">
					<div class="card">
								<div class="card-body">


									<div class="table table-striped project-orders-table">
							
											
											<table class="table">
										<thead>
											<tr>
												
												<th>Report Name</th>
												<th>Time Report</th>
											</tr>
										</thead>
										<tbody>
									
											<tr> 
											
										
										
										
											<c:forEach var="scheduleReport" items="${ StudentScheduleReports }">
													<c:set var="report" value="${scheduleReport.report}" />
													
												<tr> 
													<td>${report.name}</td>
													<td>${scheduleReport.timeReport}</td>
												
									
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
	</div>
	<!-- ---------------------END OF CONTENT--------------------- -->
	
	<!-- -----------------FOOTER-------------------- -->
	<!-- -----------------END OF FOOTER-------------------- -->
	
	<!-- Script-->
	<%@include file="/WEB-INF/views/user/student/studentscript.jsp"%>
</body>


</html>

