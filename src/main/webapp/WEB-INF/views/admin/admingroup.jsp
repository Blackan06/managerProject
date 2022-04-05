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
<title>Group</title>
<!-- Custom fonts for this template-->
<%@include file="/WEB-INF/views/admin/linkheader.jsp"%>
<!-- Custom styles for this template-->
</head>

					<!-- 
					
						admin page group
						
						http://localhost:8080/BaoCaoDoAn/ListGroup
					
					 -->

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
				<!-- /.container-fluid -->

				
				<div class="container-fluid">
				<h4>${ statusGroupOfStudent }</h4>
				
					<!-- DataTales Example -->
					<div class="card shadow mb-4">
						<div class="card-header py-3">
							<h4 class="m-0 font-weight-bold text-primary">Group</h4>
						</div>
						<div class="card-body">
							<div class="table-responsive">
								<a class="nav-link" href="addGroup" style="font-size: 18px;">
									<i class="fa fa-plus-square"></i> <span>Add group</span>
								</a>

								<table class="table table-striped" id="dataTable" width="100%"
									cellspacing="0">
									<thead>
										<tr>
											<th>.NO</th>
										<!-- 	<th>ID</th> -->
											<th>Name</th>
											<th>ViewProject</th>
											<th>View Member</th>
											<th>Action</th>
										</tr>
									</thead>

									<tbody>
										<c:forEach var="items" items="${ group4 }" varStatus="counter">
											<c:if test="${not empty items }" />
											<tr>
												<td>${counter.index + 1 }</td>
												<%-- <td>${ items.id }</td> --%>
												<td>${ items.name }</td>
												<td><a
													href='<c:url value="Project/${ items.id }"></c:url>'>View Project</a></td>
												<td><a
													href='<c:url value="group/${ items.id }"></c:url>'>View Members</a></td>
												<td><a
													href='<c:url value="/editgroup/${items.id}"></c:url>'
													class="btn btn-success btn-circle btn-sm"><i
														class="fas fa-edit"></i> </a> <a
													href='<c:url value="/deleteGroup/${items.id}"></c:url>'
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
			<!-- End of Main Content -->

			<!-- Footer -->
			<%@include file="/WEB-INF/views/admin/footer.jsp"%>
			<!-- End of Footer -->
		</div>
	</div>

	<!-- Bootstrap core JavaScript-->
	<script src="/assets/vendor/jquery/jquery.min.js"></script>
	<script src="/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="/assets/vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="/assets/js/sb-admin-2.min.js"></script>

	<!-- Page level plugins -->
	<script src="/assets/vendor/chart.js/Chart.min.js"></script>

	<!-- Page level custom scripts -->
	<script src="/assets/js/demo/chart-area-demo.js"></script>
	<script src="/assets/js/demo/chart-pie-demo.js"></script>
</body>

</html>