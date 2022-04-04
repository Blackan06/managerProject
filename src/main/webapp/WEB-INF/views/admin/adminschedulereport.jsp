<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>Schedule Report</title>
<!-- Custom fonts for this template-->
<%@include file="/WEB-INF/views/admin/linkheader.jsp"%>
<!-- Custom styles for this template-->
</head>

<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- Sidebar -->
		<%@include file="/WEB-INF/views/admin/sidebar.jsp"%>
		<!-- End of Sidebar -->

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">
			<!-- Main Content -->
			<div id="content">
				<!-- Topbar -->
				<%@include file="/WEB-INF/views/admin/header.jsp"%>
				<!-- End of Topbar -->

				<!-- Begin Page Content -->
				<div class="container-fluid">
					<!-- DataTales Example -->
					<div class="card shadow mb-4">
						<div class="card-header py-3">
							<h4 class="m-0 font-weight-bold text-primary">Schedule
								Report Detail</h4>
						</div>
						</br> <a class="nav-link" style="font-size: 18px;"
							href='<c:url value="addScheduleReport"></c:url>'> <i
							class="fa fa-plus-square"></i> <span>Add new schedule</span>
						</a>
						<div class="card-body">
							<div class="table-responsive">
								<table class="table table-striped" id="dataTable" width="100%"
									cellspacing="0">
									<thead>
										<tr>
											<!-- 	<th>Code</th> -->
											<th>Code Report</th>
											<th>Name Report</th>
											<th>Name Project</th>
											<th>Time Created</th>
											
	
											<th>Date Submit</th>
											<th>Action</th>
										</tr>
									</thead>

									<tbody>
										<c:forEach var="item" items="${ getAllScheduleReport }">
											<tr>
												<%-- 	<td>${ item.id }</td> --%>
												<td>${ item.report_id }</td>
												<td>${ item.name }</td>
												<td>${ item.project_name }</td>
												<td>${ item.timeReport }</td>
												<%-- <td>${ item.account_id }</td> --%>

												<td>${ item.dateSubmit }</td>

												<td><a
													href='<c:url value="/editScheduleReport?id=${ item.id }"></c:url>'
													class="btn btn-success btn-circle btn-sm"> <i
														class="fas fa-edit"></i></a> <a
													href='<c:url value="/deleteScheduleReport/${ item.id }"/>'
													class="btn btn-danger btn-circle btn-sm"> <i
														class="fas fa-trash"></i>
												</a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>

				</div>
			</div>
			<!-- Footer -->
			<%@include file="/WEB-INF/views/admin/footer.jsp"%>
			<!-- End of Footer -->
		</div>



		<!-- Scripts -->
		<%@include file="/WEB-INF/views/admin/adminscript.jsp"%>
		<!-- End of Scripts -->
</body>

</html>