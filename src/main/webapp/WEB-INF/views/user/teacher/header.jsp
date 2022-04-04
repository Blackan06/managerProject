<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- -----------------HEADER-------------------- -->

<div class="top-header"></div>
<div class="middle-header">
	<a href="#" target="_top"><img
		src="https://daihoc.fpt.edu.vn/media/2021/12/Logo-FU-01-200.png"
		alt="FPT"
		style="max-width: 160px; margin-top: -10px; margin-left: 50px; margin-top: 20px; margin-bottom: 20px;"></a>
	<div class="search-container">
		<!-- <input type="text" placeholder="Search.." name="search">
			<button type="submit" style="margin-left: -10px; margin-right: 20px;">
				<i class="fa fa-search"></i>
			</button> -->

		<!-- 			<!-- Nút Facebook -->
		<!-- 			<a href="https://www.facebook.com/FPTU.HCM" target="_blank"><button -->
		<!-- 					class="socialbtn"> -->
		<!-- 					<i class="fa fa-facebook" -->
		<!-- 						style="color: white; background-color: #00687c;"></i> -->
		<!-- 				</button></a> -->
		<!-- 			<!-- Nút Youtube -->
		<!-- 			<a href="https://www.youtube.com/channel/UCfNrlxNgcTZDJ3jZeSSSJxg" -->
		<!-- 				target="_blank"><button class="socialbtn"> -->
		<!-- 					<i class="fa fa-youtube" -->
		<!-- 						style="color: white; background-color: #00687c;"></i> -->
		<!-- 				</button></a> -->
		<!-- 			<!-- Nút Instagram -->
		<!-- 			<a -->
		<!-- 				href="https://www.instagram.com/accounts/login/?next=/fptuniversityhcm/" -->
		<!-- 				target="_blank"><button class="socialbtn"> -->
		<!-- 					<i class="fa fa-instagram" -->
		<!-- 						style="color: white; background-color: #00687c;"></i> -->
		<!-- 				</button></a> -->


		<!-- Nav Item - User Information -->
		<a class="nav-link" href="#" id="userDropdown" role="button"
			data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			<span class="mr-2 d-none d-lg-inline text-white medium">${ InforAccount.name }</span>
			<img class="img-profile rounded-circle" width="60" height="60"
			src='<c:url value="/assets/img/undraw_profile.svg" /> '>
		</a>
		<!-- Dropdown - User Information -->
		<div style="margin-left: 60px;">
			<a class="dropdown-item text-gray-400"
				href="<c:url value="/logout"/>"> <i
				class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
				Logout
			</a>
		</div>
		
	</div>
</div>
<style>
.table thead th {
	font-size: 1.3rem !important;
}
</style>
<!-- -----------------END OF HEADER-------------------- -->