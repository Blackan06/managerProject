<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<%@include file="/WEB-INF/views/user/teacher/linkHeader.jsp"%>

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
									<h1 style="text-align: center;">GRADE FOR REPORT</h1>
									<form:form
										action="${pageContext.request.contextPath}/processGrade"
										method="POST" modelAttribute="report">
										<form:hidden path="id" />
										<form:input path="name" readonly="true" />
										<br>
										<form:input path="timeSubmit" readonly="true" />
										<br>
										<form:input path="point" />
										<form:errors path="point" cssClass="error" />
										<br>
										<a href="#">Download</a>
										<br>
										<input type="submit" />
									</form:form>
								</div>

							</div>
						</div>

					</div>

				</div>


			</div>

		

</body>

</html>

