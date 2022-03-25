<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta http-equiv="x-ua-compatible" content="ie=edge" />
<title>Registration</title>
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.11.2/css/all.css" />
<!-- Google Fonts Roboto -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap" />
<!-- MDB -->
<link href="<c:url value="/assets/css/mdb.min.css"/> " rel="stylesheet" />

<!-- Custom styles -->
<link href="<c:url value="/assets/css/style.css"/> " rel="stylesheet" />

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
					href="loginpage.html"> <strong>FPT University</strong>
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


							<form:form method="POST" action="dang-ky"
								modelAttribute="account"
								class="bg-white  rounded-5 shadow-5-strong p-5">

								<h1>
									<center>Sign up for an account</center>
								</h1>

								<!-- Name input -->
								<div class="form-outline mb-4">
									<form:input path="name" type="text" class="form-control" />

									<label class="form-label" for="form1Example1">Name</label>
								</div>

								<!-- Email input -->
								<div class="form-outline mb-4">

									<form:input path="mail" placeholder="@fpt.edu.vn" type="email"
										class="form-control" />

									<label class="form-label" for="form1Example1">Email</label>
								</div>

								<!-- MSSV input -->
								<div class="form-outline mb-4">

									<input type="text" class="form-control" />
									<!-- chưa có path  -->

									<label class="form-label" for="form1Example1">Student
										code</label>
								</div>

								<!-- Password input -->
								<div class="form-outline mb-4">
									<form:input path="password" type="text" class="form-control" />

									<label class="form-label" for="form1Example2">Password</label>
								</div>

								<!-- Confirm password input -->
								<div class="form-outline mb-4">
									<input type="text" class="form-control" /> <label
										class="form-label" for="form1Example2"> Confirm
										password</label>
								</div>


								<!-- Phone number input -->
								<div class="form-outline mb-4">
									<form:input path="phone" type="text" placeholder="+84"
										class="form-control" />
									<label class="form-label" for="form1Example2">Phone</label>
								</div>

								<!-- Role input -->
								<div class="form-outline mb-4">
									<label class="form-label" for="form1Example1">Role</label>

									<form:select path="role">
										<option value="student">student</option>
										<option value="teacher">teacher</option>
									</form:select>
								</div>

								<div class="form-outline mb-4">
									<label class="form-label" for="form1Example1">Leader</label>
									<form:select path="isLeader">
										<option value="1">true</option>
										<option value="0">false</option>
									</form:select>


								</div>

								<!-- Submit button -->
								<button type="submit" class="btn btn-primary btn-block">
									Registration</button>
								</br>

								<div class="col text-center">
									<!-- Simple link -->
									<a href='<c:url value="/"></c:url>'>Do you already have an
										account ?</a>
									<h3 style="color: black; text-align: center;">${ statusRegister }</h3>
								</div>
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
	<script type="text/javascript"
		src='<c:url value="/assets/js/mdb.min.js"></c:url>'></script>


	<!-- Custom scripts -->
	<script type="text/javascript"
		src='<c:url value="/assets/js/script.js"></c:url>'></script>

</body>
</html>

