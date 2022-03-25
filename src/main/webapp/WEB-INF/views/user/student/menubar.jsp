<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- MENU BAR -->
<div class="menubar">
	<div class="dropdown" style="margin-left: 50px;">
		<a href="<c:url value="/studenthome"/>" target="_top"><button
				class="dropbtn">
				<i class="fa fa-home"></i>
			</button></a>
	</div>

	<div class="dropdown">
		<button class="dropbtn">Report</button>
		<div class="dropdown-content">
			<a href="<c:url value="/student_ViewReport"/>">View Reports</a>
		</div>
	</div>

	<div class="dropdown">
		<button class="dropbtn">Group</button>
		<div class="dropdown-content">
			<a href="<c:url value="/studentGroupByteacher_id"/>">Group Information</a>
		</div>
	</div>

	<div class="dropdown">
		<button class="dropbtn">Schedule Report</button>
		<div class="dropdown-content">
			<a href="<c:url value="/student_ViewScheduleReport"/>">View Schedule</a>
		</div>
	</div>

	<div class="dropdown">
		<button class="dropbtn">Meeting</button>
		<div class="dropdown-content">
			<a
				href="<c:url value="/studentMeeting"/>">View Meeting Schedule</a>
		</div>
	</div>

	<div class="dropdown">
		<button class="dropbtn">Project</button>
		<div class="dropdown-content">
			<a href="<c:url value="/studentProject"/>">Project Detail</a>
		</div>
	</div>
	
</div>
<!-- end of MENU BAR -->