<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>Group Page</title>
<!-- Custom fonts for this template-->
<%@include file="/WEB-INF/views/admin/linkheader.jsp"%>
</head>

<body id="page-top">
	<%-- 	<c:set var="message" value="${message}" />
	<c:if test="${message!=''}">
		<script type="text/javascript">
			var Msg = "${message}";
			window.alert(Msg);
		</script>
	</c:if> --%>
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


				<div class="container-fluid">
					<div class="row justify-content-center">
						<div class="col-sm-8">
							<div class="card shadow mb-4">
								<div class="card-header py-3">
									<h4 style="text-align: center;"
										class="m-0 font-weight-bold text-primary">Edit Project</h4>
								</div>

								<div style="margin: 30px 200px">
									<form:form method="POST" action="/BaoCaoDoAn/editProject"
										modelAttribute="project">
										<form:hidden path="id" value="${ project.id}" />
										<label for="email2" class="mb-2 mr-sm-2">Name Project</label>
										<br>


										<form:input path="name" placeholder="abcdxyz" type="text"
											class="form-control mb-2 mr-sm-2" />
										<form:errors path="name" cssClass="error" />
										<br>




										<label for="email2" class="mb-2 mr-sm-2">Time Create </label>
										<br>
										<form:input path="createTime" type="date"
											class="form-control mb-2 mr-sm-2" />
										<br>


										<label for="email2" class="mb-2 mr-sm-2">Group : ${ project.group_id }
										</label>
										<br>

										<form:select path="group_id" class="form-control mb-2 mr-sm-2">
											<form:options items="${groups}" itemValue="id"
												itemLabel="name" />
										</form:select>

										<div class="">
											<!-- Simple link -->
											<span style="color: red">${ errorGroup }</span>
										</div>

										<p style="color: red">${ ValidationProject_Group }</p>

										<label for="cars">Teacher: ${ project.teacherId }</label>

										<br>
										<form:select path="teacherId"
											class="form-control mb-2 mr-sm-2">
											<form:options items="${teacher}" itemValue="id"
												itemLabel="name" />

										</form:select>

										<div class="">
											<!-- Simple link -->
											<span style="color: red">${ errorTeacher }</span>
										</div>


										<%-- <form:select path="teacherId">
											<c:forEach var="item" items="${ teacher }">
												<option value="${ item.id }">${ item.id }-${ item.name }</option>
											</c:forEach>
										</form:select>
 --%>

										<br>
										<br>
										<button type="submit" class="btn btn-primary mb-2">Submit</button>

									</form:form>

								</div>

							</div>

						</div>


					</div>


				</div>
				<!-- DataTales Example -->

			</div>

		</div>
		<!-- End of Main Content -->

		<!-- Footer -->
		<%@include file="/WEB-INF/views/admin/footer.jsp"%>
		<!-- End of Footer -->
	</div>
	</div>

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