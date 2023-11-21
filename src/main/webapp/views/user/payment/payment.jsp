<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<!-- Site meta -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
</head>
<body>
	<div class="payment">
		<div class="payment-content">
			<h1 style="margin-bottom: 46px; margin-top: 16px">Thanh toán đơn hàng</h1>
			<div class="row w-100">
				<div class="col-5">
					<div class="payment-container">
						<div class="mb-4">
							<h4>Giao hàng</h4>
							<div class="payment-info">
								<div class="mb-3">
									<label for="addressInp" class="form-label">Địa chỉ </label> <input
										id="addressInp" type="text" class="form-control"
										placeholder="Địa chỉ">
								</div>
								<div class="mb-3">
									<label for="surnameInp" class="form-label">Tên khách
										hàng </label>
									<div class="d-flex align-items-center">
										<input id="surnameInp" type="text" class="form-control me-3	"
											placeholder="Họ khách hàng"> <input type="text"
											class="form-control" placeholder="Tên khách hàng">
									</div>
								</div>
								<div class="mb-3">
									<label for="phoneNumberInp" class="form-label">Số điện
										thoại </label> <input id="phoneNumberInp" type="text"
										class="form-control" placeholder="Số điện thoại">
								</div>
							</div>
						</div>
						<div class="mb-4">
							<h4>Phương thức thanh toán</h4>
							<div class="form-check">
								<input class="form-check-input" type="radio"
									name="flexRadioDefault" id="flexRadioDefault1"> <label
									class="form-check-label" for="flexRadioDefault1"> Tiền
									mặt </label>
							</div>
							<div class="form-check">
								<input class="form-check-input" type="radio"
									name="flexRadioDefault" id="flexRadioDefault2" checked>
								<label class="form-check-label" for="flexRadioDefault2">
									Momo </label>
							</div>
							<div class="form-check">
								<input class="form-check-input" type="radio"
									name="flexRadioDefault" id="flexRadioDefault3" checked>
								<label class="form-check-label" for="flexRadioDefault3">
									Thẻ ngân hàng </label>
							</div>
						</div>
						<div>
							<div class="form-check">
								<input class="form-check-input" type="checkbox" value=""
									id="flexCheckDefault"> <label class="check-label"
									for="flexCheckDefault"> Tôi đồng ý với các điều khoản
									và điều kiện mua hàng của ALOTRA </label>
							</div>
						</div>
					</div>
				</div>
				<div class="col-7">
					<div class="products-choosen">
						<h4>Các món đã chọn</h4>
						<ul class="list-product-choosen">
							<li class="cart-item payment-item">
								<div class="cart-item-container">
									<img
										src="https://cdn.phonebooky.com/blog/wp-content/uploads/2020/04/07010330/Brown-Sugar.jpg"
										class="cart-product-image payment-product-image" />
									<div class="cart-item-info">
										<div class="d-flex align-items-center mb-2">
											<p class="cart-product-name m-0">Trà sữa trân châu</p>
											<p class="cart-quantity ms-2">x2</p>
										</div>
										<p class="product-size">Vừa</p>
									</div>
								</div>
								<p class="cart-price">25.000đ</p>
							</li>
							<li class="cart-item payment-item">
								<div class="cart-item-container">
									<img
										src="https://cdn.phonebooky.com/blog/wp-content/uploads/2020/04/07010330/Brown-Sugar.jpg"
										class="cart-product-image payment-product-image" />
									<div class="cart-item-info">
										<div class="d-flex align-items-center mb-2">
											<p class="cart-product-name m-0">Trà sữa trân châu</p>
											<p class="cart-quantity ms-2">x2</p>
										</div>
										<p class="product-size">Vừa</p>
									</div>
								</div>
								<p class="cart-price">25.000đ</p>
							</li>
							<li class="cart-item payment-item">
								<div class="cart-item-container">
									<img
										src="https://cdn.phonebooky.com/blog/wp-content/uploads/2020/04/07010330/Brown-Sugar.jpg"
										class="cart-product-image payment-product-image" />
									<div class="cart-item-info">
										<div class="d-flex align-items-center mb-2">
											<p class="cart-product-name m-0">Trà sữa trân châu</p>
											<p class="cart-quantity ms-2">x2</p>
										</div>
										<p class="product-size">Vừa</p>
									</div>
								</div>
								<p class="cart-price">25.000đ</p>
							</li>
							<li class="cart-item payment-item">
								<div class="cart-item-container">
									<img
										src="https://cdn.phonebooky.com/blog/wp-content/uploads/2020/04/07010330/Brown-Sugar.jpg"
										class="cart-product-image payment-product-image" />
									<div class="cart-item-info">
										<div class="d-flex align-items-center mb-2">
											<p class="cart-product-name m-0">Trà sữa trân châu</p>
											<p class="cart-quantity ms-2">x2</p>
										</div>
										<p class="product-size">Vừa</p>
									</div>
								</div>
								<p class="cart-price">25.000đ</p>
							</li>
							<li class="cart-item payment-item">
								<div class="cart-item-container">
									<img
										src="https://cdn.phonebooky.com/blog/wp-content/uploads/2020/04/07010330/Brown-Sugar.jpg"
										class="cart-product-image payment-product-image" />
									<div class="cart-item-info">
										<div class="d-flex align-items-center mb-2">
											<p class="cart-product-name m-0">Trà sữa trân châu</p>
											<p class="cart-quantity ms-2">x2</p>
										</div>
										<p class="product-size">Vừa</p>
									</div>
								</div>
								<p class="cart-price">25.000đ</p>
							</li>
						</ul>
					</div>
					<div class="payment-note">
						<div class="mb-3">
							<h4 for="exampleFormControlTextarea1" class="form-label">
								Ghi chú</h4>
							<textarea class="form-control" id="exampleFormControlTextarea1"
								rows="3"></textarea>
						</div>
					</div>
					<div class="payment-price">
						<h4>Tổng cộng</h4>
						<ul>
							<li>
								<p>Phí giao hàng</p>
								<p class="payment-price-value">12.000đ</p>
							</li>
							<li>
								<p>Thành tiền</p>
								<p class="payment-price-value">100.000đ</p>
							</li>
						</ul>
					</div>
					<button class="cart-btn-submit payment-btn" type="submit">Đặt hàng</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>