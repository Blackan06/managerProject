<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<ul
	class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
	id="accordionSidebar">
	<a
		class="sidebar-brand d-flex align-items-center justify-content-center"
		href="#">
		<div class="sidebar-brand-icon">
			<img src='<c:url value="/assets/img/FPT-logo.jpg" />'
				style="max-width: 140px;">
		</div>
	</a>
	<hr class="sidebar-divider my-0">
	<li class="nav-item active"><a class="nav-link" href="#">
			<i class="fas fa-fw fa-tachometer-alt"></i> <span>Dashboard</span>
	</a></li>
	<hr class="sidebar-divider">

	<div class="sidebar-heading">Website-Manager</div>
	<li class="nav-item">
	<li class="nav-item active"><a class="nav-link" 
		href='<c:url value="/studentList"></c:url>'> <i
			class="fas fa-fw fa-table"></i> <span>Student</span></a></li>
	<li class="nav-item active"><a class="nav-link"
		href='<c:url value="/getReport"></c:url>'> <i
			class="fas fa-fw fa-table"></i> <span>Report</span></a></li>
	<li class="nav-item active"><a class="nav-link"
		href='<c:url value="/ScheduleReport"></c:url>'> <i
			class="fas fa-fw fa-table"></i> <span>Schedule Report</span></a></li>

	<li class="nav-item active"><a class="nav-link"
		href='<c:url value="/ScheduleMeeting"></c:url>'> <i
			class="fas fa-fw fa-table"></i> <span>Schedule Meeting</span></a></li>

	<li class="nav-item active"><a class="nav-link"
		href='<c:url value="/AdminProject"></c:url>'> <i
			class="fas fa-fw fa-table"></i> <span>Project</span></a></li>

	<li class="nav-item active"><a class="nav-link"
		href='<c:url value="/ListGroup"></c:url>'> <i
			class="fas fa-fw fa-table"></i> <span>Group</span></a></li>

	<!-- Divider -->
	<hr class="sidebar-divider d-none d-md-block">
</ul>