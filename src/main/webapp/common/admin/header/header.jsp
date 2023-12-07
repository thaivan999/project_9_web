<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="loader-wrapper">
	<div id="loader"></div>
	<div class="loader-section section-left"></div>
	<div class="loader-section section-right"></div>
</div>
<nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">

	<a class="navbar-brand ps-3" href="/admin/index">MilkTea</a>

	<button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0"
		id="sidebarToggle" href="#!">
		<i class="fas fa-bars"></i>
	</button>

	<form
		class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
		<div class="input-group">
					</div>
	</form>

	<ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
		<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
			id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown"
			aria-expanded="false">Welcome ${account}<i
				class="fas fa-user fa-fw"></i></a>
			<ul class="dropdown-menu dropdown-menu-end"
				aria-labelledby="navbarDropdown">
				<li><a class="dropdown-item" href="/security/login"
					${login_pass}>Đăng nhập</a></li>
				<li><a class="dropdown-item" href="/security/register"
					${login_pass}>Đăng ký</a></li>
				<li><a class="dropdown-item" href="/security/logout"
					${login_no}>Đăng xuất</a></li>
				<li><hr class="dropdown-divider" ${login_no}></li>
				<li><a class="dropdown-item" href="/security/change-password"
					${login_no}>Đổi mật khẩu</a></li>
				<li><a class="dropdown-item" href="/security/forgot-password"
					${login_pass}>Quên mật khẩu</a></li>
				<li><hr class="dropdown-divider" ${login_admin}></li>
				<li><a class="dropdown-item" href="/home">Giao
						diện User</a></li>
			</ul></li>
	</ul>
</nav>
<div id="layoutSidenav">
	<div id="layoutSidenav_nav">
		<nav class="sb-sidenav accordion sb-sidenav-dark"
			id="sidenavAccordion">
			<div class="sb-sidenav-menu">
				<div class="nav">
					<div class="sb-sidenav-menu-heading">Trang tổng quan</div>
					<a class="nav-link" href="/admin/index">
						<div class="sb-nav-link-icon">
							<i class="fas fa-tachometer-alt"></i>
						</div> Báo cáo - Thống kê
					</a>


					<div class="sb-sidenav-menu-heading">Trang quản lý</div>
					<!-- Quản lý chi nhánh -->
					<a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseBranch" aria-expanded="false" aria-controls="collapseBranch">
						<div class="sb-nav-link-icon">
							
						</div> Quản lý chi nhánh
						<div class="sb-sidenav-collapse-arrow">
							<i class="fas fa-angle-down"></i>
						</div>
					</a>
					<div class="collapse" id="collapseBranch" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
						<nav class="sb-sidenav-menu-nested nav">
							<a class="nav-link" href="/admin/branch">Danh sách chi nhánh</a> 
							<a class="nav-link" href="/admin/branch/add">Cập nhật chi nhánh</a>
						</nav>
					</div>
					<!-- Quản lý giỏ hàng-->
					<a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseCart" aria-expanded="false" aria-controls="collapseCart">
						<div class="sb-nav-link-icon">
							
						</div> Quản lý giỏ hàng
						<div class="sb-sidenav-collapse-arrow">
							<i class="fas fa-angle-down"></i>
						</div>
					</a>
					<div class="collapse" id="collapseCart" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
						<nav class="sb-sidenav-menu-nested nav">
							<a class="nav-link" href="/admin/view-cart">Danh sách giỏ hàng</a> 
							<a class="nav-link" href="/admin/customize-cart">Cập nhật giỏ hàng</a>
						</nav>
					</div>
					<!-- Quản lý chi tiết giỏ hàng-->
					<a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseCartDetail" aria-expanded="false" aria-controls="collapseCartDetail">
						<div class="sb-nav-link-icon">
							
						</div> Quản lý chi tiết giỏ hàng
						<div class="sb-sidenav-collapse-arrow">
							<i class="fas fa-angle-down"></i>
						</div>
					</a>
					<div class="collapse" id="collapseCartDetail" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
						<nav class="sb-sidenav-menu-nested nav">
							<a class="nav-link" href="/admin/view-cart-detail">Danh sách chi tiết giỏ hàng</a> 
							<a class="nav-link" href="/admin/customize-cart-detail">Cập nhật chi tiết giỏ hàng</a>
						</nav>
					</div>
					<!-- Quản lý khách hàng -->
					<a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseCustomer" aria-expanded="false" aria-controls="collapseCustomer">
						<div class="sb-nav-link-icon">
							
						</div> Quản lý khách hàng
						<div class="sb-sidenav-collapse-arrow">
							<i class="fas fa-angle-down"></i>
						</div>
					</a>
					<div class="collapse" id="collapseCustomer" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
						<nav class="sb-sidenav-menu-nested nav">
							<a class="nav-link" href="/admin/view-customer">Danh sách khách hàng</a> 
							<a class="nav-link" href="/admin/customize-customer">Cập nhật khách hàng</a>
						</nav>
					</div>
					<!-- Quản lý loại trà sữa-->
					<a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseMilkTeaType" aria-expanded="false" aria-controls="collapseMilkTeaType">
						<div class="sb-nav-link-icon">
							
						</div> Quản lý loại trà sữa
						<div class="sb-sidenav-collapse-arrow">
							<i class="fas fa-angle-down"></i>
						</div>
					</a>
					<div class="collapse" id="collapseMilkTeaType" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
						<nav class="sb-sidenav-menu-nested nav">
							<a class="nav-link" href="/admin/view-milk-tea-type">Danh sách loại trà sữa</a> 
							<a class="nav-link" href="/admin/customize-milk-tea-type">Cập nhật loại trà sữa</a>
						</nav>
					</div>
					<!-- Quản lý trà sữa -->
					<a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseMilkTea" aria-expanded="false" aria-controls="collapseMilkTea">
						<div class="sb-nav-link-icon">
							
						</div> Quản lý trà sữa
						<div class="sb-sidenav-collapse-arrow">
							<i class="fas fa-angle-down"></i>
						</div>
					</a>
					<div class="collapse" id="collapseMilkTea" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
						<nav class="sb-sidenav-menu-nested nav">
							<a class="nav-link" href="/admin/view-milk-tea">Danh sách trà sữa</a> 
							<a class="nav-link" href="/admin/customize-milk-tea">Cập nhật trà sữa</a>
						</nav>
					</div>
					<!-- Quản lý danh mục trà sữa-->
					<a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseMilkTeaCategory" aria-expanded="false" aria-controls="collapseMilkTeaCategory">
						<div class="sb-nav-link-icon">
							
						</div> Quản lý danh mục trà sữa
						<div class="sb-sidenav-collapse-arrow">
							<i class="fas fa-angle-down"></i>
						</div>
					</a>
					<div class="collapse" id="collapseMilkTeaCategory" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
						<nav class="sb-sidenav-menu-nested nav">
							<a class="nav-link" href="/admin/view-milk-tea-category">Danh sách danh mục trà sữa</a> 
							<a class="nav-link" href="/admin/customize-milk-tea-category">Cập nhật danh mục trà sữa</a>
						</nav>
					</div>
					<!-- Quản lý chi tiết đơn hàng -->
					<a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseOrderDetail" aria-expanded="false" aria-controls="collapseOrderDetail">
						<div class="sb-nav-link-icon">
							
						</div> Quản lý chi tiết đơn hàng
						<div class="sb-sidenav-collapse-arrow">
							<i class="fas fa-angle-down"></i>
						</div>
					</a>
					<div class="collapse" id="collapseOrderDetail" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
						<nav class="sb-sidenav-menu-nested nav">
							<a class="nav-link" href="/admin/view-order-detail">Danh sách chi tiết đơn hàng</a> 
							<a class="nav-link" href="/admin/customize-order-detail">Cập nhật chi tiết đơn hàng</a>
						</nav>
					</div>
					<!-- Quản lý phương thức thanh toán-->
					<a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapsePaymethod" aria-expanded="false" aria-controls="collapsePaymethod">
						<div class="sb-nav-link-icon">
							
						</div> Quản lý phương thức thanh toán
						<div class="sb-sidenav-collapse-arrow">
							<i class="fas fa-angle-down"></i>
						</div>
					</a>
					<div class="collapse" id="collapsePaymethod" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
						<nav class="sb-sidenav-menu-nested nav">
							<a class="nav-link" href="/admin/view-paymethod">Danh sách phương thức thanh toán</a> 
							<a class="nav-link" href="/admin/customize-paymethod">Cập nhật phương thức thanh toán</a>
						</nav>
					</div>
					<!-- Quản lý đơn hàng người dùng-->
					<a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseUserOrder" aria-expanded="false" aria-controls="collapseUserOrder">
						<div class="sb-nav-link-icon">
							
						</div> Quản lý đơn hàng người dùng
						<div class="sb-sidenav-collapse-arrow">
							<i class="fas fa-angle-down"></i>
						</div>
					</a>
					<div class="collapse" id="collapseUserOrder" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
						<nav class="sb-sidenav-menu-nested nav">
							<a class="nav-link" href="/admin/view-user-order">Danh sách đơn hàng người dùng</a> 
							<a class="nav-link" href="/admin/customize-user-order">Cập nhật đơn hàng người dùng</a>
						</nav>
					</div>
					<!-- Quản lý vai trò người dùng-->
					<a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseUserRole" aria-expanded="false" aria-controls="collapseUserRole">
						<div class="sb-nav-link-icon">
							
						</div> Quản lý vai trò người dùng
						<div class="sb-sidenav-collapse-arrow">
							<i class="fas fa-angle-down"></i>
						</div>
					</a>
					<div class="collapse" id="collapseUserRole" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
						<nav class="sb-sidenav-menu-nested nav">
							<a class="nav-link" href="/admin/view-user-role">Danh sách vai trò người dùng</a> 
							<a class="nav-link" href="/admin/customize-user-role">Cập nhật vai trò người dùng</a>
						</nav>
					</div>

				</div>
			</div>
		</nav>
	</div>
	