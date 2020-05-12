<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- *** 載入 ＪＳＴＬ .jar -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- ============================================================== -->
<!-- Left Sidebar -->
<!-- ============================================================== -->
<aside class="left-sidebar" data-sidebarbg="skin5">
	<!-- Sidebar scroll-->
	<div class="scroll-sidebar">
		<!-- Sidebar navigation-->
		<nav class="sidebar-nav">
			<ul id="sidebarnav" class="p-t-30">
				<li
					class="sidebar-item 
				 <%if (request.getParameter("pageTitle").equals("home")) {
				out.print("selected");
			}%> 
				 "><a
					class="sidebar-link waves-effect waves-dark sidebar-link"
					href="<c:url value="index"/>" aria-expanded="false"><i
						class="mdi mdi-home-outline"></i><span class="hide-menu">首頁</span></a></li>

				<li
					class="sidebar-item 
				
				 <%if (request.getParameter("pageTitle").equals("userOverview")
					|| request.getParameter("pageTitle").equals("userEdit")) {
				out.print("selected");
			}%> 
			
				 ">
					<a href="<c:url value="UserQuery"/>"
					class="sidebar-link waves-effect waves-dark sidebar-link"
					aria-expanded="false"> <i class="mdi mdi-account"></i><span
						class="hide-menu">會員管理</span>
				</a>

				</li>
				<li
					class="sidebar-item 
				 <%if (request.getParameter("pageTitle").equals("imageUpload")
					|| request.getParameter("pageTitle").equals("excelImport")) {
				out.print("selected");
			}%>  "><a
					class="sidebar-link has-arrow waves-effect waves-dark"
					href="javascript:void(0)" aria-expanded="false"><i
						class="mdi mdi-checkerboard"></i><span class="hide-menu">功能
					</span></a>
					<ul aria-expanded="false" class="collapse  first-level">
						<li class="sidebar-item"><a href="<c:url value="imageUpload"/>"
							class="sidebar-link"><i class="mdi mdi-folder-image"></i><span
								class="hide-menu"> 上傳圖片 </span></a></li> 
						<li class="sidebar-item"><a href="<c:url value="excelImport"/>"
							class="sidebar-link"><i class="mdi mdi-file-excel"></i><span
								class="hide-menu"> 匯入 Excel </span></a></li>

					</ul></li>


			</ul>
		</nav>
		<!-- End Sidebar navigation -->
	</div>
	<!-- End Sidebar scroll-->
</aside>
<!-- ============================================================== -->
<!-- Left Sidebar -->
<!-- ============================================================== -->