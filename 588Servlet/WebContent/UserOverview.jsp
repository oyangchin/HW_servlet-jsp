<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- *** 載入 ＪＳＴＬ .jar -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 遇到的問題：
https://stackoverflow.com/questions/21847117/jstl-cforeach-error-attribute-items-does-not-accept-any-expressions -->

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
		<jsp:include page="component/leftSidebar.jsp">
			<jsp:param value="userOverview" name="pageTitle" />
		</jsp:include>
		<!-- ====================== Left Sidebar ========================= -->


		<div class="page-wrapper">
			<!-- ========  Bread crumb and right sidebar toggle =============== -->
			<jsp:include page="component/breadcrumb.jsp">
				<jsp:param value="會員管理" name="pageTitle" />
			</jsp:include>
			<!-- ========  Bread crumb and right sidebar toggle =============== -->

			<div class="container-fluid">

				<div class="row">
					<div class="col-md-10">
						<div class="card">
							<form class="form-horizontal">
								<div class="card-body">
									<h4 class="card-title">會員列表</h4>
									<div class="form-group row">
										<label for="fname"
											class="col-sm-2 text-right control-label col-form-label">姓名</label>
										<div class="col-sm-6">
											<input type="text" class="form-control" id="fname"
												placeholder="First Name Here">
										</div>
									</div>

									<div class="form-group row">
										<label for="cono1"
											class="col-sm-2 text-right control-label col-form-label">電話</label>
										<div class="col-sm-6">
											<input type="text" class="form-control" id="cono1"
												placeholder="Contact No Here">
										</div>
										<div class="col-sm-3">
											<button type="button" class="btn btn-primary">搜尋</button>
										</div>
									</div>


									<!-- User Table -->
									<table class="table">
										<thead>
											<tr>
												<th scope="col">#</th>
												<th scope="col">姓名</th>
												<th scope="col">年齡</th>
												<th scope="col">電話</th>
												<th scope="col">編輯</th>
											</tr>
										</thead>
										<tbody>
										<%-- 	<c:if test="${user != null }"> --%>
												<c:forEach items="${userList}" var="user">
													<tr>
														<th scope="row">${user.id}</th>
														<td>${user.name}</td>
														<td>${user.age}</td>
														<td>${user.phone}</td>
														<td>編輯</td>
													</tr>
												</c:forEach>
											<%-- </c:if> --%>
											
											<!-- <tr>
												<th scope="row">1</th>
												<td>Mark</td>
												<td>Otto</td>
												<td>@mdo</td>
											</tr>
											<tr>
												<th scope="row">2</th>
												<td>Jacob</td>
												<td>Thornton</td>
												<td>@fat</td>
											</tr>
											<tr>
												<th scope="row">3</th>
												<td>Larry</td>
												<td>the Bird</td>
												<td>@twitter</td>
											</tr> -->
										</tbody>
									</table>
								</div>

							</form>
						</div>
					</div>
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