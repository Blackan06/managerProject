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
								<div class="card-body">
									<div class="table table-striped project-orders-table">
							
										<c:forEach var="group" items="${teacherGroup}">
											<c:set var="account" value="${group.account}" />
											<h5 style="text-align: center; text-transform: uppercase;margin:16px;">${group.name}</h5>
											<table class="table">
												<thead>
													<tr>
														
													 <th>ID</th> 
														<th>Name</th>
														<th>Mail</th>
														<th>Role</th>
													<!-- 	<th>GroupID</th> -->
													</tr>
												</thead>
												<tbody>
												<c:forEach var="item" items="${account}">
													<tr>														
													<td>${ item.id }</td> 
														<td>${ item.name }</td>
														<td>${ item.mail }</td>
														<td>${ item.role }</td>
													<%-- 	<td>${ item.group_id }</td> --%>
													</tr>
												</tbody>
												</c:forEach>
											</table>
										</c:forEach>

									</div>
								</div>

							</div>
							
								
						</div>

					</div>

				</div>

				
			</div>
			


</body>

</html>