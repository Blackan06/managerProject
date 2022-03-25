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

<body id="page-top">
	<div id="wrapper">
	
		<!-- Sidebar -->
		<%@include file="/WEB-INF/views/admin/sidebar.jsp"%>
		<!-- End of Sidebar -->


		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">
			<div id="content" >
			
					<!-- Header Navbar -->
					<%@include file="/WEB-INF/views/admin/header.jsp"%>
					<!-- End of Header -->

					<!--  Main Content -->
					
					<!--  End of Main Content -->
					
			</div>
			<!-- End of Content Wrapper -->
			<!-- Footer -->
					<%@include file="/WEB-INF/views/admin/footer.jsp"%>
					<!-- End of Footer -->
		</div>
	</div>


	<!-- Scripts -->
	<%@include file="/WEB-INF/views/admin/adminscript.jsp"%>
	<!-- End of Scripts -->


	<script src="/assets/vendor/jquery/jquery.min.js"></script>
	<script src="/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="/assets/vendor/jquery-easing/jquery.easing.min.js"></script>
	<script src="/assets/js/sb-admin-2.min.js"></script>
	<script src="/assets/vendor/chart.js/Chart.min.js"></script>
	<script src="/assets/js/demo/chart-area-demo.js"></script>
	<script src="/assets/js/demo/chart-pie-demo.js"></script>

</body>

</html>