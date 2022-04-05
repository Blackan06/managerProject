<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html >
<html lang="en" xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta charset="UTF-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta http-equiv="x-ua-compatible" content="ie=edge" />
<title>Material Design for Bootstrap</title>
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.11.2/css/all.css" />
<!-- Google Fonts Roboto -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap" />
<!-- MDB -->

<link href="<c:url value="/assets/css/mdb.min.css" /> " rel="stylesheet" />
<!-- Custom styles -->
<link href="<c:url value="/assets/css/style.css" /> " rel="stylesheet" />

</head>

<body>
	<!--Main Navigation-->
	<header>
		<style>
#intro {
	background-image:
		url(https://mdbootstrap.com/img/new/fluid/city/008.jpg);
	height: 100vh;
}

/* Height for devices larger than 576px */
@media ( min-width : 992px) {
	#intro {
		margin-top: -58.59px;
	}
}

.navbar .nav-link {
	color: #fff !important;
}
</style>
		<!-- Navbar -->
		<nav class="navbar navbar-expand-lg navbar-dark d-none d-lg-block"
			style="z-index: 2000;">
			<div class="container-fluid">
				<!-- Navbar brand -->
				<a class="navbar-brand nav-link" target="_blank"
					href="Loginpage.html"> <strong>FPT University</strong>
				</a>
			</div>
		</nav>
		<!-- Navbar -->
		<!-- Background image -->

		<div id="intro" class="bg-image shadow-2-strong">
			<div class="mask d-flex align-items-center h-100"
				style="background-color: rgba(0, 0, 0, 0.8);">
				<div class="container">
					<div class="row justify-content-center">
						<div class="col-xl-5 col-md-8">

					


							<form:form method="POST" action="/BaoCaoDoAn/dang-nhap" name="form1"
								modelAttribute="account" class="bg-white  rounded-5 shadow-5-strong p-5">

								<h1>
									<center>LOGIN</center>
								</h1>
								<!-- Email input -->
								<div class="form-outline mb-4">
								<form:input path="mail" type="email" name="uname" class="form-control"  value="${cookieValue.value}" />
								
									

									<label class="form-label" for="form1Example1">Email
										</label>
								</div>

								<!-- Password input -->
								<div class="form-outline mb-4">
								<form:input path="password" name="email" type="password" placeholder="Enter Password" class="form-control" />
								
						

									<label class="form-label" for="form1Example2">Password</label>
								</div>

								<!-- 2 column grid layout for inline styling -->
								<div class="row mb-4">
									<div class="col text-center">
										<!-- Simple link -->
										<h5 style="color: red">${ statusLogin }</h5>
									</div>
								</div>
										<button onclick="return email()"
										 class="btn btn-primary btn-block" type="submit">Login</button>
								



								<%-- <div class="col text-center">
									<!-- Simple link -->
									Do not have an account? <a
										href='<c:url value="/dang-ky"></c:url>'>Register</a>
								</div> --%>
							</form:form>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- Background image -->
	</header>
	<!--Main Navigation-->

	<!--Footer-->

	<!--Footer-->
	<!-- MDB -->

	<script language = "Javascript">
function email(){
	var email = document.forms["form1"]["email"].value;
	
	if(email==""){
		alert("Please Enter valid Mobile no. with country code ");
		return false;
	}
	return true;
	}
</script>
	<script type="text/javascript"
		src='<c:url value="/assets/js/mdb.min.js"></c:url>'></script>


	<!-- Custom scripts -->
	<script type="text/javascript"
		src='<c:url value="/assets/js/script.js"></c:url>'></script>

</body>

</html>