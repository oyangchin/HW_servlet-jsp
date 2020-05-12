<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- *** 解決 include 傳遞 jsp:param 中文亂碼的問題 *** -->
<%
	request.setCharacterEncoding("UTF-8");
%>

<!DOCTYPE html>
<html dir="ltr" lang="en">

<jsp:include page="../../component/head.jsp"></jsp:include>

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
		<jsp:include page="../../component/topbar.jsp"></jsp:include>
		<!-- ====================== Topbar header ========================= -->

		<!-- ====================== Left Sidebar ========================= -->
		<jsp:include page="../../component/leftSidebar.jsp"><jsp:param
				value="excelImport" name="pageTitle" /></jsp:include>
		<!-- ====================== Left Sidebar ========================= -->


		<div class="page-wrapper">
			<!-- ========  Bread crumb and right sidebar toggle =============== -->
			<jsp:include page="../../component/breadcrumb.jsp">
				<jsp:param value="匯入 Excel" name="pageTitle" />
			</jsp:include>
			<!-- ========  Bread crumb and right sidebar toggle =============== -->

			<div class="container-fluid">

				<div class="row">
					<div class="col-md-12">
						<form action="excelImport" method="POST" enctype="multipart/form-data">
							<div class="card">
								<div class="card-body">
									<h5 class="card-title">匯入 Excel 檔案</h5>
									<div class="row mb-3 align-items-center">
										<div class="col-lg-2 col-md-12 text-right">
											<span>檔案上傳</span>
										</div>
										<div class="col-lg-10 col-md-12">
											<div class="custom-file">
												<input name="excel" type="file" class="custom-file-input" id="validatedCustomFile" required> 
												<label class="custom-file-label" for="validatedCustomFile">Choose file...</label>
												<div class="invalid-feedback">Example invalid custom file feedback</div>
											</div>
										</div>
									</div>



								</div>
								<div class="border-top">
									<div class="card-body">
										<button type = "submit" class="btn btn-primary">匯入</button>
									</div>
								</div>
							</div>
						</form>
					</div>
				</div>

			</div>

			<jsp:include page="../../component/footer.jsp"></jsp:include>
		</div>
	</div>
	<!-- ================ Jquery ================ -->
	<jsp:include page="../../component/script.jsp"></jsp:include>
	<!-- ================ Jquery ================ -->
</body>

</html>