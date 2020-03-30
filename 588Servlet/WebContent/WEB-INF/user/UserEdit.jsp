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
		<jsp:include page="../../component/leftSidebar.jsp">
			<jsp:param value="userEdit" name="pageTitle" /></jsp:include>
		<!-- ====================== Left Sidebar ========================= -->


		<div class="page-wrapper">
			<!-- ========  Bread crumb and right sidebar toggle =============== -->
			<jsp:include page="../../component/breadcrumb.jsp">
				<jsp:param value="會員新增/編輯" name="pageTitle" />
			</jsp:include>
			<!-- ========  Bread crumb and right sidebar toggle =============== -->

			<div class="container-fluid">

				<div class="row">
					<div class="col-md-6">
						<div class="card">
							<form class="form-horizontal" id="submitForm" action="UserAdd"
								method="POST">
								<div class="card-body">
									<h4 class="card-title">新增會員</h4>
									<div class="form-group row">
										<label for="name"
											class="col-sm-3 text-right control-label col-form-label">姓名</label>
										<div class="col-sm-9">
											<input type="text" class="form-control" id="name" name="name" value="${user.name}"
												placeholder="輸入姓名...">
										</div>
									</div>
									<div class="form-group row">
										<label for="userId"
											class="col-sm-3 text-right control-label col-form-label">帳號</label>
										<div class="col-sm-9">
											<input type="text" class="form-control" id="userId"
												name="userId" placeholder="輸入帳號...">
										</div>
									</div>
									<div class="form-group row">
										<label for="password"
											class="col-sm-3 text-right control-label col-form-label">密碼</label>
										<div class="col-sm-9">
											<input type="password" class="form-control" id="password"
												name="password" placeholder="輸入密碼...">
										</div>
									</div>
									<div class="form-group row">
										<label for="country"
											class="col-sm-3 text-right control-label col-form-label">年齡</label>
										<div class="col-sm-9">
											<input type="text" class="form-control" id="age"
												name="age" placeholder="輸入年齡...">
										</div>
									</div>
									<div class="form-group row">
										<label for="phone"
											class="col-sm-3 text-right control-label col-form-label">電話</label>
										<div class="col-sm-9">
											<input type="text" class="form-control" id="phone"
												name="phone" placeholder="輸入電話...">
										</div>
									</div>
									<div class="form-group row">
										<label for="country"
											class="col-sm-3 text-right control-label col-form-label">地址</label>
										<div class="col-sm-9">
											<input type="text" class="form-control" id="country"
												name="country" placeholder="輸入地址...">
										</div>
									</div>

								</div>
								<div class="border-top">
									<div class="card-body">
										<div class="row">
											<div class="col-sm-3"></div>
											<div class="col-sm-3">
												<button type="submit" class="btn btn-primary">確定送出</button>
											</div>
										</div>

									</div>
								</div>
							</form>
						</div>
					</div>
				</div>

			</div>

			<jsp:include page="../../component/footer.jsp"></jsp:include>
		</div>
	</div>
	<!-- ================ Jquery ================ -->
	<jsp:include page="../../component/script.jsp"></jsp:include>
	<!-- ================ Jquery ================ -->
	<!-- <script>
		$("#submitForm").submit(function(e) {

			var form = $(this);
			/* var url = form.attr('action'); */
			console.log("aaaa")
			$.ajax({
				type : "POST",
				url : "UserAdd",
				data : form.serialize(), // serializes the form's elements.
				success : function(data) {
					alert(data); // show response from the php script.
				}
			});

			e.preventDefault(); // avoid to execute the actual submit of the form.
		});
	</script> -->
</body>

</html>