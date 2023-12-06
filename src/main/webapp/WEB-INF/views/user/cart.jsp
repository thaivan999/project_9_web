<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
</head>
<body>
	<!-- Content -->
	<div class="content" style="margin-top: 80px">
		<!--  Title-->
		<p class="cart-title">Giỏ hàng của tôi</p>

		<c:if test="${message != null }">
			<c:if test="${'success' eq status }">
				<div class="alert alert-success" role="alert">${message }</div>
			</c:if>
			<c:if test="${'fail' eq status }">
				<div class="alert alert-danger" role="alert">${message }</div>
			</c:if>
		</c:if>
		<!-- List Cart -->
		<ul class="list-cart">
			<c:forEach var="milktea" items="${listmilkteas }">
				<li class="cart-item">
					<div class="cart-item-container">
						<div class="checkbox-wrapper-42">
							<input value="${milktea.idMilkTea }" type="checkbox"
								class="checkbox-element" /> <label class="cbx"></label>
						</div>
						<img
							src="https://cdn.phonebooky.com/blog/wp-content/uploads/2020/04/07010330/Brown-Sugar.jpg"
							class="cart-product-image" />
						<div class="cart-item-info">
							<p class="cart-product-name">${milktea.getName() }</p>
							<span data-name="${milktea.getSize() }" class="cart-size">${milktea.getSize() }</span>
							<p data-name="${milktea.getCost() }" class="cart-price">${milktea.getCost() }đ</p>
						</div>
					</div>
					<div class="cart-action">
						<div data-id="${milktea.idMilkTea }" class="cart-btn-delete"
							data-bs-toggle="modal" data-bs-target="#exampleModal">
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

		<!-- Modal -->
		<div class="modal fade" id="exampleModal" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Thông báo</h5>
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
					</div>
					<div class="modal-body">
						Bạn có muốn xóa sản phẩm <span class="modal-product-id">1</span> và size = <span class="modal-product-size">Lớn</span>?
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-bs-dismiss="modal">Close</button>
						<button type="button" class="btn btn-primary btn-yes">Yes</button>
					</div>
				</div>
			</div>
		</div>

		<!-- Total price -->
		<div class="order-container">
			<!-- Check box -->
			<div class="check-container">
				<div class="checkbox-wrapper-42">
					<input type="checkbox" class="checkbox-select-all" /> <label
						class="cbx"></label>
				</div>
				<label class="check-title">Chọn tất cả</label>
			</div>

			<!-- Total Price -->
			<div class="total-price">
				<span class="total-price-title">Tổng giá:</span> <span
					class="cart-sum-price" style="font-size: 30px;">0đ</span>
			</div>

			<!-- <button class="order-btn">Đặt hàng</button> -->
			<button class="cart-btn-submit" type="submit">Đặt hàng</button>
		</div>
	</div>

	<script type="text/javascript" src='<c:url value="/user/js/cart.js" />'></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
</body>
</html>