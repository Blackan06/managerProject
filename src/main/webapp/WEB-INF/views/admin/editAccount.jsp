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
<title>Add Project</title>
<!-- Custom fonts for this template-->
<%@include file="/WEB-INF/views/admin/linkheader.jsp"%>
<style>
.error {
	color: red;
	font-size: 1rem;
}
</style>
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

				<div class="container-fluid">
					<div class="row justify-content-center">
						<div class="col-sm-8">
							<div class="card shadow mb-4">
								<div class="card-header py-3">
									<h4 style="text-align: center;"
										class="m-0 font-weight-bold text-primary">Student Account
										Details</h4>
								</div>

								<div style="margin: 30px 200px">
									<form:form action="addAccountStudent" method="POST"
										modelAttribute="studentAcc1">
										<form:hidden path="id" />

										<label for="email2" class="mb-2 mr-sm-2">Name:</label>
										<br>
										<form:input path="name" type="text"
											class="form-control mb-2 mr-sm-2" />
										<form:errors path="name" cssClass="error" />
										<br>

										<label for="email2" class="mb-2 mr-sm-2">Mail:</label>
										<br>

										<form:input path="mail" type="text"
											class="form-control mb-2 mr-sm-2" />
										<!-- 2 column grid layout for inline styling -->

										<div class="">
											<!-- Simple link -->
											<span style="color: red">${ emailExist }</span>


										</div>

										<form:errors path="mail" cssClass="error" />
										<br>

										<label for="email2" class="mb-2 mr-sm-2">Password:</label>
										<br>
										<form:input type="password" path="password"
											class="form-control mb-2 mr-sm-2" />
										<form:errors path="password" cssClass="error" />
										<br>

										<label for="cars">Group Name :</label>



										<%--	<form:select path="group_id"
											class="btn  dropdown-toggle">
											 <c:forEach var="item" items="${ groups }">

												<option value="${ item.id }">${ item.id }</option>
											</c:forEach> 
										</form:select>--%>

										<form:select path="group_id" class="form-control mb-2 mr-sm-2">
											<form:options items="${groups}" itemValue="id"
												itemLabel="name" />
										</form:select>
										<div class="">
											<!-- Simple link -->
											<span style="color: red">${ groupExist }</span>


										</div>

										<br>

										<label for="" class="mb-2 mr-sm-2">Phone:</label>
										<br>
										<form:input path="phone" class="form-control mb-2 mr-sm-2" />
										<form:errors path="phone" cssClass="error" />
										<br>
										<label for="role" class="mb-2 mr-sm-2">Role:</label>

										<form:select path="role" class="form-control mb-2 mr-sm-2"
											items="${listRole}" />
										<%-- <div class="">
											<!-- Simple link -->
											<span style="color: red">${ errorTeacher }</span>


										</div>
 --%>


										<%--  <form:select path="role"
											class="btn dropdown-toggle">
											<option items="${ item.role }" value="student">Student</option>
											<option items="${ item.role }" value="teacher">
												Teacher</option>
										</form:select>  --%>
										<br>
										<br>

										<label for="email2" class="mb-2 mr-sm-2">Leader:</label>
										<br>


										<form:select path="isLeader" class="form-control mb-2 mr-sm-2"
											items="${listLeader}" />
										<%-- <div class="">
											<!-- Simple link -->
											<span style="color: red">${ errorleader }</span>


										</div> --%>
										<br>
										<!-- 
										<form:input path="isLeader" class="form-control mb-2 mr-sm-2" />
										<form:errors path="isLeader" cssClass="error" />
										 -->
										<br>
										<label for="email2" class="mb-2 mr-sm-2">Gender:</label>
										<br>
										<form:select path="gender" class="form-control mb-2 mr-sm-2"
											items="${listGener}" />

											

										<br>


										<form:errors path="gender" cssClass="error" />
										<br>

										<button type="submit" class="btn btn-primary mb-2">Submit</button>

									</form:form>
									<h1></h1>
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
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>

</body>
<script src="./status.ajax"></script>
</html>

