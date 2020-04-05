<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- *** 解決 include 傳遞 jsp:param 中文亂碼的問題 *** -->
<%
	request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE html>
<html dir="ltr" lang="en">

<jsp:include page="component/head.jsp"></jsp:include>

<body>
	<!-- ============================================================== -->
	<!-- Preloader - style you can find in spinners.css -->
	<!-- ============================================================== -->
	<div class="preloader">
		<div class="lds-ripple">
			<div class="lds-pos"></div>
			<div class="lds-pos"></div>
		</div>
	</div>

	<div id="main-wrapper">
		<!-- ====================== Topbar header ========================= -->
		<jsp:include page="component/topbar.jsp"></jsp:include>
		<!-- ====================== Topbar header ========================= -->
		
		<!-- ====================== Left Sidebar ========================= -->
		<jsp:include page="component/leftSidebar.jsp"><jsp:param value="imageUpload"
				name="pageTitle" /></jsp:include>
		<!-- ====================== Left Sidebar ========================= -->


		<div class="page-wrapper">
			<!-- ========  Bread crumb and right sidebar toggle =============== -->
			<jsp:include page="component/breadcrumb.jsp">
				<jsp:param value="上傳圖片" name="pageTitle" />
			</jsp:include>
			<!-- ========  Bread crumb and right sidebar toggle =============== -->

			<div class="container-fluid">

				<div class="row">
				</div>

			</div>

			<jsp:include page="component/footer.jsp"></jsp:include>
		</div>
	</div>
	<!-- ================ Jquery ================ -->
	<jsp:include page="component/script.jsp"></jsp:include>
	<!-- ================ Jquery ================ -->
</body>

</html>