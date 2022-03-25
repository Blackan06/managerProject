<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>student page</title>
<%@include file="/WEB-INF/views/admin/linkheader.jsp"%>
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

				<!-- Header -->
				<%@include file="/WEB-INF/views/admin/header.jsp"%>
				<!-- End of Header -->

				<!-- Begin Page Content -->
				<div class="container-fluid">
				
				<div class="card-header py-3">
							<!--	<h6 class="m-0 font-weight-bold text-primary">Search</h6> -->
							<!-- Load icon library -->
							<form:form method="POST" action="/BaoCaoDoAn/searchAcc"
								modelAttribute="accountSearch">
								<label for="email2" class="mb-2 mr-sm-2">Seach by Name </label>
								<br>
								<form:input path="name" type="text"
									class="form-control mb-2 mr-sm-2" />
								<button type="submit" class="btn btn-primary">Submit</button>
							</form:form>
						</div>
					<!-- DataTales Example -->
					<div class="card shadow mb-4">
					<div class="card-header py-3">
							<h4 class="m-0 font-weight-bold text-primary">Student Account Detail</h4>
						</div>
						<div class="card-body">
							<div class="table-responsive">
								<!-- Add Group Button -->
								<a class="nav-link" style="font-size: 18px;"
									href='<c:url value="addAccountStudent"></c:url>'> <i
									class="fa fa-plus-square"></i> <span>Add new account</span>
								</a>
								<!-- End of Add Group Button -->
								<table class="table table-striped" id="dataTable" width="100%"
									cellspacing="0">
									<thead>
										<tr>
											<th>ID</th>
											<th>Name</th>
											<th>Email</th>
											<th>Group Name</th>
											<th>Phone</th>
											<th>Role</th>
											<th>Is Leader</th>
											<th>Gender</th>
											<th>Action</th>
										</tr>

									</thead>

									<tbody>
										<c:forEach var="items" items="${ studentList }"
											varStatus="counter">
											<c:if test="${not empty items }" />
											<tr>
												<td>${ items.id }</td>
												<td>${ items.name }</td>
												<td>${ items.mail }</td>
												<td>${ items.group_name }</td>
												<td>${ items.phone }</td>
												<td>${ items.role }</td>
												<td>${ items.isLeader }</td>
												<td>${ items.gender }</td>
												<td><a
													href='<c:url value="/editStudentAccount?id=${items.id}"></c:url>'
													class="btn btn-success btn-circle btn-sm"> <i
														class="fas fa-edit"></i>
												</a> <a
													href='<c:url value="/deleteAccount?id=${items.id}"></c:url>'
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
				<!-- /.container-fluid -->
			</div>
			<!-- End of Main Content -->

			<!-- Footer -->
			<%@include file="/WEB-INF/views/admin/footer.jsp"%>
			<!-- End of Footer -->

		</div>
		<!-- End of Content Wrapper -->
	</div>
	<!-- End of Page Wrapper -->

	<!-- Logout Modal-->
	<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">Ã</span>
					</button>
				</div>
				<div class="modal-body">Select "Logout" below if you are ready
					to end your current session.</div>
				<div class="modal-footer">
					<button class="btn btn-secondary" type="button"
						data-dismiss="modal">Cancel</button>
					<a class="btn btn-primary" href="login.html">Logout</a>
				</div>
			</div>
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