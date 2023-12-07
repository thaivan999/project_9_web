<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href='<c:url value="/user/css/header.css" />' rel="stylesheet" />
</head>
<body>
	<header class="header">
		<div class="container-left">
			<a class="d-block" href="/home"> <img
				src="https://png.pngtree.com/png-clipart/20200701/original/pngtree-milk-tea-logo-png-image_5405468.jpg"
				class="logo" />
			</a>
			<ul class="nav-list">
				<li class="nav-item"><a class="nav-item-link" href="/products">
						Menu </a>
					<div class="header-menu">
						<div class="row">
							<c:set var="index" value="0"></c:set>
							<c:forEach var="category" items="${categories}">
								<div class="col">
									<p class="header-category">${category.name}</p>
									<ul class="type-product-list">
										<c:forEach var="type" items="${types[index]}">
											<li class="type-product-item"><a
												href="/products/type/${type.idType}"
												class="type-product-link">${type.name}</a></li>
										</c:forEach>
									</ul>
								</div>
								<c:set var="index" value="${index + 1 }"></c:set>
							</c:forEach>
						</div>
					</div></li>
				<li class="nav-item"><a class="nav-item-link" href="/branches">Cửa
						hàng</a></li>
			</ul>
		</div>

		<form action="/header/moveToSearchPage" method="get"
			accept-charset="UTF-8">
			<div class="search-container">
				<input type="text" class="search-inp" name="content" />
				<button class="search-btn" type="submit">
					<i class="fa-solid fa-magnifying-glass"></i>
				</button>
			</div>
		</form>
		<div class="container-right">
			<!-- <button class="btn btn-outline-warning btn-signup">Đăng ký</button> -->
			<!--<button class="btn btn-info btn-login">Đăng nhập</button>  -->
			<div class="header-info">
				<img
					src="https://scontent.fsgn7-1.fna.fbcdn.net/v/t39.30808-6/241464176_1242056446291086_5810272849317935739_n.jpg?_nc_cat=111&ccb=1-7&_nc_sid=5f2048&_nc_eui2=AeEvXXHV2qYOwuZ1Ler5Oz3GHNzvHW711J0c3O8dbvXUnZK01qMq-02S7vfQK1uJFJvsm4u8tTMtyDFv9wnqoDzk&_nc_ohc=m5Y76dkiCxwAX81owvC&_nc_ht=scontent.fsgn7-1.fna&oh=00_AfBWc4lElhsgkNiEwMjcu3LVqNk275LrwcJZv9AjP74S2w&oe=6560930D"
					class="avatar" />
				<p class="username">Nguyễn Thái Văn</p>
				<ul class="header-action">
					<li class="header-action-item"><a class="header-action-link"
						href="#">Quản lý tài khoản</a></li>
					<li class="header-action-item"><a class="header-action-link"
						href="/cart">Giỏ hàng của tôi</a></li>
					<li class="header-action-item"><a class="header-action-link"
						href="/order">Đơn hàng của tôi</a></li>
					<li class="header-action-item"><a class="header-action-link"
						href="#">Trợ giúp</a></li>
					<li class="header-action-item"><a class="header-action-link"
						href="#">Đăng xuất</a></li>
				</ul>
			</div>
		</div>
	</header>
</body>
</html>