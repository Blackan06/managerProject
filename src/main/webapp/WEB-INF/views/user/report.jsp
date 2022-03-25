<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Report</h1>
	<c:forEach var="item" items="${ getReport }">
			<h1>Group: ${ item.id }</h1>
			<h1>Project Name : ${ item.name }</h1>
			<h1>Created Time : ${ item.timeCreate }</h1>
			<h1>Submmit Time : ${ item.timeSubmit }</h1>
	
	</c:forEach>
</body>
</html>