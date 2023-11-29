<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Open+Sans:400,300,600" rel="stylesheet" type="text/css">
<link href='<c:url value="/css/product_detail.css"/>' rel="stylesheet" type="text/css">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"
	integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" type="text/javascript"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" type="text/javascript"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" type="text/javascript"></script>
</head>
<body>
	<!-- Breadcrumb -->
	<div class="container" style="margin-top: 120px">
		<div class="row">
			<div class="col">
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a class="black-text bold-text"
							href="">Menu</a></li>
						<!-- Sau này thay tên bằng các field cụ thể -->
						<li class="breadcrumb-item"><a class="black-text bold-text"
							href="">Trà Thảo Mộc</a></li>
						<li class="breadcrumb-item active bold-text" aria-current="page">Trà
							Xanh</li>
					</ol>
				</nav>
			</div>
		</div>
	</div>
	<!-- End: Breadcrumb -->

	<!-- Main part -->
	<div class="container">
		<div class="row">
			<!-- Main product image -->
			<div class="col-12 col-lg-6">
				<div class="card mb-3 no-border">
					<div class="card-body" style="padding: 0;">
						<a href="" data-toggle="modal" data-target="#productModal"> <img
							class="img-fluid" style="border-radius: 10px;"
							src="https://eatbook.sg/wp-content/uploads/2020/09/Media-Kit-KOI-Biscuit-Milk-Tea-by-Qing-2.jpg" />
						</a>
					</div>
				</div>
			</div>

			<!-- Add to cart -->
			<div class="col-12 col-lg-6 add_to_cart_block">
				<div class="card mb-3 no-border">
					<div class="card-body">
						<p class="h3 bold-text">Trà Sữa</p>
						<p class="h4 price bold-text" style="color: #707070;">39.000đ</p>
						<form method="get" action="">
							<div class="form-group">
								<label class="mt-2 fs-18">Chọn size</label><br />
								<button type="button" class="btn btn-outline-dark">Vừa
									+0đ</button>
								<button type="button" class="btn btn-outline-dark ml-1">Lớn
									+5.000đ</button>
							</div>
							<div class="form-group">
								<label class="fs-18">Topping</label><br />
								<button type="button" class="btn btn-outline-dark">Kem
									phô mai +5000đ</button>
								<button type="button" class="btn btn-outline-dark ml-1">Thạch
									cà phê +5000đ</button>
							</div>
							<div class="form-group">
								<button type="button"
									class="btn btn-outline-dark btn-lg mt-2 bold-text"
									style="width: 215px;">Thêm vào giỏ hàng</button>
								<button type="button"
									class="btn btn-dark btn-lg ml-1 mt-2 bold-text"
									style="width: 215px;">Mua ngay</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<!-- End: Main part -->

		<!-- Description -->
		<div class="container">
			<div class="row">
				<div class="col-12">
					<hr style="border: thin solid black;">
					<h5 class="bold-text black-text mt-2">Mô tả sản phẩm</h5>
					<p style="font-weight: 500;">Thức uống mang hương vị của nhãn,
						của sen, của trà Oolong đầy thanh mát cho tất cả các thành viên
						trong dịp Tết này. An lành, thư thái và đậm đà chính là những gì
						The Coffee House mong muốn gửi trao đến bạn và gia đình.</p>
					<hr class="mt-2" style="border: thin solid #B6B6B6;">
				</div>
			</div>
		</div>
		<!-- End: Description -->

		<!-- Relevant products -->
		<div class="container">
			<div class="row">
				<div class="col-12">
					<h5 class="bold-text black-text mt-2">Sản phẩm liên quan</h5>
				</div>
				<!-- Product Card 1 -->
				<div class="col-sm-3 mt-2">
					<div class="card">
						<img class="card-img-top"
							src="https://eatbook.sg/wp-content/uploads/2020/09/Media-Kit-KOI-Biscuit-Milk-Tea-by-Qing-2.jpg"
							alt="Card image cap">
						<div class="card-body">
							<p class="card-title bold-text">Trà Sữa Truyền Thống</p>
							<p class="card-text">39.000đ</p>
						</div>
					</div>
				</div>
				<!-- Product Card 2 -->
				<div class="col-sm-3 mt-2">
					<div class="card">
						<img class="card-img-top"
							src="https://eatbook.sg/wp-content/uploads/2020/09/Media-Kit-KOI-Biscuit-Milk-Tea-by-Qing-2.jpg"
							alt="Card image cap">
						<div class="card-body">
							<p class="card-title bold-text">Trà Sữa Truyền Thống</p>
							<p class="card-text">39.000đ</p>
						</div>
					</div>
				</div>
				<!-- Product Card 3 -->
				<div class="col-sm-3 mt-2">
					<div class="card">
						<img class="card-img-top"
							src="https://eatbook.sg/wp-content/uploads/2020/09/Media-Kit-KOI-Biscuit-Milk-Tea-by-Qing-2.jpg"
							alt="Card image cap">
						<div class="card-body">
							<p class="card-title bold-text">Trà Sữa Truyền Thống</p>
							<p class="card-text">39.000đ</p>
						</div>
					</div>
				</div>
				<!-- Product Card 4 -->
				<div class="col-sm-3 mt-2">
					<div class="card">
						<img class="card-img-top"
							src="https://eatbook.sg/wp-content/uploads/2020/09/Media-Kit-KOI-Biscuit-Milk-Tea-by-Qing-2.jpg"
							alt="Card image cap">
						<div class="card-body">
							<p class="card-title bold-text">Trà Sữa Truyền Thống</p>
							<p class="card-text">39.000đ</p>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- End: Relevant products -->
	</div>
</body>
</html>