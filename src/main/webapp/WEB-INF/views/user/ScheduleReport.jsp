<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Schedule Report</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
 

	<div class="container">
		<h2>Schedule Report </h2>

		<table class="table table-striped" border="1">


			<thead>
				<tr>
					<th>Code</th>
					<th>Time Create</th>
					<th>Code Report</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${ getAllScheduleReport }">
					<tr>
						<td>${ item.id }</td>

						<td>${ item.timeReport }</td>
						<td>${ item.report_id }</td>
						<td>
							<button type="button" class="btn btn-success">Edit</button> 
							<a href='<c:url value="/deleteScheduleReport/${ item.id }"/>' class="btn btn-danger">Delete</a>

						</td>
					</tr>
				</c:forEach>
			</tbody>

		</table>
		<button type="button" class="btn btn-primary" data-toggle="modal"
			data-target="#myModal">Add</button>
			
	
		<div class="modal" id="myModal" style="text-align: center">
			<div class="modal-dialog">
				<div class="modal-content">

					
					<div class="modal-header">
						<h4 class="modal-title">Add New Schedule Report</h4>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>

				
					<div class="modal-body">
					
							<form:form method="POST" action="addSchedule" modelAttribute="schedule" >
							<label for="email2" class="mb-2 mr-sm-2">Time Create</label> <br>
							 <form:input path="timeReport" type="date" class="form-control mb-2 mr-sm-2" value="2022-06-01" />
								 <br> <br>
								
								 
								 <label for="email2" class="mb-2 mr-sm-2">Schedule for Report</label> <br>
								  <form:input path="report_id" type="text" class="form-control mb-2 mr-sm-2"/>
							 <br> <br>
								
								<button type="submit" class="btn btn-primary mb-2">Submit</button>

						</form:form>

					</div>

				
					<div class="modal-footer">
						<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
					</div>

				</div>
			</div>
		</div>




	</div>


	<div class="container">
		<h2>Report</h2>

		<table class="table table-striped" border="1">


			<thead>
				<tr>
					<th>Code</th>
					<th>Name</th>
					<th>Point</th>
					<th>Comment</th>
					<th>Time Create</th>
					<th>Time Submit</th>
					<th>Code Project</th>
					<th></th>

				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${ getAllReport }">
					<tr>
						<td>${ item.id }</td>
						<td>${ item.name }</td>
						<td></td>
						<td></td>
						<td>${ item.timeCreate }</td>
						<td>${ item.timeSubmit }</td>
						<td>${ item.project_id  }</td>
						<td>
						<a class="btn btn-success" href='<c:url value="/editReport?id=${ item.id }"></c:url>'>Edit</a>
						
				

				
							
						
							<a href='<c:url value="/deleteReport/${ item.id }"/>' class="btn btn-danger">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>

		</table>
		<a class="btn btn-primary" data-toggle="modal"
			data-target="#myModal2">Add Report</a>
		
		
		<div class="modal" id="myModal2" >
			<div class="modal-dialog">
				<div class="modal-content">

					
					<div class="modal-header">
						<h4 class="modal-title">Add New Report</h4>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>

				
					<div class="modal-body">
							<form:form method="POST" action="addreport" modelAttribute="report" >
							
							<label for="email2" class="mb-2 mr-sm-2">Name Report</label> <br>
							<form:input path="name" type="text" class="form-control mb-2 mr-sm-2" placeholder="Name Report" />
							 <br><br> 
								
								<label for="pwd2" class="mb-2 mr-sm-2">Time Create</label> <br>
								<form:input path="timeCreate" type="date" class="form-control mb-2 mr-sm-2" value="2022-06-01" />
								 <br> <br>
								 
								 <label for="pwd2" class="mb-2 mr-sm-2">Time Submit</label> <br>
								 <form:input path="timeSubmit" type="date" class="form-control mb-2 mr-sm-2" value="2022-06-01" />
								 <br> <br>
								 
								 <label for="email2" class="mb-2 mr-sm-2">URL Report</label> <br>
								 <form:input path="urlReport" type="text" class="form-control mb-2 mr-sm-2" placeholder="Content Report" />
								 <br> <br> 
								
								 <label for="email2" class="mb-2 mr-sm-2">Project</label> <br>
								 <form:input path="project_id" type="text" class="form-control mb-2 mr-sm-2" placeholder="For Project" />
								 <br> <br> 
								
									
								<button type="submit" class="btn btn-primary mb-2">Submit</button>
								

						
						</form:form>
					</div>

				
					<div class="modal-footer">
						<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
					</div>

				</div>
			</div>
		</div>

	</div>


</body>
</html>