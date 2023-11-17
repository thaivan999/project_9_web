<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Giỏ hàng</title>
</head>
<body>
	<!-- Content -->
	<div class="content">
		<!--  Title-->
		<div class="title">
			<h1>Giỏ hàng của tôi</h1>
		</div>

		<!-- List Cart -->
		<ul class="list-cart">
			<li class="cart-item">
				<div class="product-container">
					<input class="check-box-cart-item" type="checkbox"> <img
						class="image-cart" src="https://dummyimage.com/120x120/d6d6d6"
						alt="">
					<div class="product-cart">
						<span class="name-cart">Product Name</span> <span
							class="price-cart">35.000</span>
					</div>
				</div>

				<div class="counter">
					<span class="down" onClick='decreaseCount(event, this)'>-</span> <input
						type="text" value="1"> <span class="up"
						onClick='increaseCount(event, this)'>+</span>
				</div>
			</li>
			<li class="cart-item">
				<div class="product-container">
					<input class="check-box-cart-item" type="checkbox"> <img
						class="image-cart" src=https://dummyimage.com/120x120/d6d6d6
						alt="">
					<div class="product-cart">
						<span class="name-cart">Product Name</span> <span
							class="price-cart">35.000</span>
					</div>
				</div>

				<div class="counter">
					<span class="down" onClick='decreaseCount(event, this)'>-</span> <input
						type="text" value="1"> <span class="up"
						onClick='increaseCount(event, this)'>+</span>
				</div>
			</li>
			<li class="cart-item">
				<div class="product-container">
					<input class="check-box-cart-item" type="checkbox"> <img
						class="image-cart" src=https://dummyimage.com/120x120/d6d6d6
						alt="">
					<div class="product-cart">
						<span class="name-cart">Product Name</span> <span
							class="price-cart">35.000</span>
					</div>
				</div>

				<div class="counter">
					<span class="down" onClick='decreaseCount(event, this)'>-</span> <input
						type="text" value="1"> <span class="up"
						onClick='increaseCount(event, this)'>+</span>
				</div>
			</li>
			<li class="cart-item">
				<div class="product-container">
					<input class="check-box-cart-item" type="checkbox"> <img
						class="image-cart" src=https://dummyimage.com/120x120/d6d6d6
						alt="">
					<div class="product-cart">
						<span class="name-cart">Product Name</span> <span
							class="price-cart">35.000</span>
					</div>
				</div>

				<div class="counter">
					<span class="down" onClick='decreaseCount(event, this)'>-</span> <input
						type="text" value="1"> <span class="up"
						onClick='increaseCount(event, this)'>+</span>
				</div>
			</li>
			<!-- Add more list items as needed -->
		</ul>

		<!-- Total price -->
		<div class="order-container">
			<!-- Check box -->
			<div class="check-container">
				<input class="check-box-cart" type="checkbox"> <span
					class="all-order">Tất cả</span>
			</div>

			<!-- Total Price -->
			<div class="total-price">
				<span class="total-price-title">Tổng giá:</span> <span
					class="price-cart">35.000</span>
			</div>

			<!-- <button class="order-btn">Đặt hàng</button> -->
			<button class="btn btn-primary" type="submit">Đặt hàng</button>
		</div>
	</div>
</body>
</html>