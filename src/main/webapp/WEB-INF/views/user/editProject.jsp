
    <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Edit Project</h1>


		
					<c:forEach var="item" items="${ getProjectByid }">
				
					
							<form:form method="POST" action="/BaoCaoDoAn/edit-Project" modelAttribute="project" >
							<label for="email2" class="mb-2 mr-sm-2">Name Project</label> <br>
							 <form:input path="name" type="text" class="form-control mb-2 mr-sm-2" value="${ item.name }" />
								 <br>
								
								 
								 <label for="email2" class="mb-2 mr-sm-2">UrL Porject</label> <br>
								<form:input path="urlProject" type="text" class="form-control mb-2 mr-sm-2"  value="${ item.urlProject }" />
							 <br> 
								
								
								 <label for="email2" class="mb-2 mr-sm-2">Time Create </label> <br>
								<form:input path="createTime" type="date" class="form-control mb-2 mr-sm-2" value="${ item.createTime }" />
							 <br>
							 
							 	 <label for="email2" class="mb-2 mr-sm-2">Group</label> <br>
								<form:input path="group_id" type="text" class="form-control mb-2 mr-sm-2" value="${ item.group_id }" />
							 <br> 
							 
							 
								<button type="submit" class="btn btn-primary mb-2">Submit</button>

						</form:form>
				</c:forEach>
					


</body>
</html>