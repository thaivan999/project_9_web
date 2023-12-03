<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>

</head>
<body>
	<!-- Content -->
	<div class="content" style="margin-top: 80px">
		<!--  Title-->
		<p class="cart-title">Giỏ hàng của tôi</p>

		<!-- List Cart -->
		<ul class="list-cart">
			<c:forEach var="milktea" items="${listmilktea }">
				<li class="cart-item">
					<div class="cart-item-container">
						<div class="checkbox-wrapper-42">
							<input type="checkbox" class="checkbox-element"/> <label class="cbx"></label>
						</div>
						<img
							src="https://cdn.phonebooky.com/blog/wp-content/uploads/2020/04/07010330/Brown-Sugar.jpg"
							class="cart-product-image" />
						<div class="cart-item-info">
							<p class="cart-product-name">${milktea.getName() }</p>
							<p class="cart-price">${milktea.getCost() }đ</p>
							<span class="cart-size"></span>
						</div>
					</div>
					<div class="cart-action">
						<div class="cart-btn-delete">
							<i class="fa-solid fa-trash"></i>
						</div>
						<div class="cart-modify-quantity">
							<div class="cart-modify-quantity-desc">
								<i class="fa-solid fa-minus"></i>
							</div>
							<input value="1" class="cart-quantity-input" />
							<div class="cart-modify-quantity-asc">
								<i class="fa-solid fa-plus"></i>
							</div>
						</div>
					</div>
				</li>
			</c:forEach>
		</ul>

		<!-- Total price -->
		<div class="order-container">
			<!-- Check box -->
			<div class="check-container">
				<div class="checkbox-wrapper-42">
					<input type="checkbox" class="checkbox-select-all"/> <label class="cbx"></label>
				</div>
				<label class="check-title">Chọn tất cả</label>
			</div>

			<!-- Total Price -->
			<div class="total-price">
				<span class="total-price-title">Tổng giá:</span> <span
					class="cart-sum-price" style="font-size: 30px;">35.000đ</span>
			</div>

			<!-- <button class="order-btn">Đặt hàng</button> -->
			<button class="cart-btn-submit" type="submit">Đặt hàng</button>
		</div>
	</div>
	
	<script type="text/javascript" src='<c:url value="/user/js/cart.js" />'></script>
</body>
</html>