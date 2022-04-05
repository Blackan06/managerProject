
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
<%@include file="/WEB-INF/views/user/student/linkHeader.jsp"%>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css">
</head>

<body style="overflow: visible;">


	<%-- 	<c:if test="${pointDetails == null}">
		<c:set var="message" value="${message}" />
	<c:if test="${message!=''}">
	
		<script type="text/javascript">
			var Msg = "chua c� diem";
			window.alert(Msg);
		
		</script>
	

	</c:if>
	</c:if>
 --%>

	<div class="header" th:fragment="headerfrag">
		<!-- -----------------HEADER-------------------- -->
		<%@include file="/WEB-INF/views/user/student/header.jsp"%>
		<!-- -----------------END OF HEADER-------------------- -->
		<!-- -----------------MENU BAR-------------------- -->
		<%@include file="/WEB-INF/views/user/student/menubar.jsp"%>
		<!-- -----------------END OF MENU BAR-------------------- -->
	</div>


	<!-- ---------------------CONTENT--------------------- -->


	<a style="margin-left: 10px"
		href='<c:url value="/student_ViewReport"></c:url>'
		class="btn btn-primary btn-lg"><span
		class="glyphicon glyphicon-home"></span> Back </a>

	<div class="main-panel">

		<div class="content-wrapper">

			<div class="row" style="display: flex; align-items: center;justify-content: center;">



				<h1 class="list-group-item ">Your Point : ${pointDetails.point}</h1>


			</div>

		</div>
	</div>
	<!-- ---------------------END OF CONTENT--------------------- -->

	<!-- -----------------FOOTER-------------------- -->

	<!-- -----------------END OF FOOTER-------------------- -->

	<!-- Script-->
	<%@include file="/WEB-INF/views/user/student/studentscript.jsp"%>

</body>


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js"
	integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js"
	integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
	crossorigin="anonymous"></script>
</html>