<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<%@include file="/WEB-INF/views/user/teacher/linkHeader.jsp"%>
<head>
<style type="text/css">
.error{
font-size: 12px;
color:red;
}
</style>
</head>
<body>

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
							<c:set var="group" value="${group}" />
							<c:set var="report" value="${report}" />
							<h1 style="text-align: center;">GRADING FOR REPORT</h1>
							<h4>Grading for report:${report.name}</h4>
							<h4>Group:${group.name}</h4>
							<form:form action="${pageContext.request.contextPath}/saveReportComment" method="POST" modelAttribute="report">
							<form:hidden path="name"/>
							<form:hidden path="id"/>
							<label>Comment:</label>
							<form:textarea  path="comment"/>
								<label>Total Point:</label>
							<form:input  path="point"/>				
							<input type="submit" value="save" />
							</form:form>
							<p class="error">${error}</p>
							<table class="table table-striped project-orders-table">
								<thead>
									<tr>
										<td>Name</td>
										<td>Email</td>
										<td>Phone</td>
										<td>Role</td>
										<td>Point</td>
										<td>Action</td>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="member" items="${members}">
									<c:set var="pointObject" value="${member.pointDetailForReport}" />
										<tr>
											<td>${member.name}</td>
											<td>${member.mail}</td>
											<td>${member.phone}</td>
											<c:if test="${member.isLeader==true}">
												<td>Leader</td>
											</c:if>
											<c:if test="${member.isLeader==false}">
												<td>Member</td>
											</c:if>
											<td>${pointObject.point}</td>
											<c:if test="${member.statusPoint == 0}">
											<td><a href='<c:url value="/teacher_grade/${report.id}/${member.id}"/>'>Grade</a></td>
											</c:if>
											<c:if test="${member.statusPoint == 1}">
											<td><a href='<c:url value="/teacher_editPoint/${report.id}/${member.id}"/>'>Edit</a></td>
											</c:if>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>

					</div>
				</div>

			</div>

		</div>


	</div>



</body>

</html>

