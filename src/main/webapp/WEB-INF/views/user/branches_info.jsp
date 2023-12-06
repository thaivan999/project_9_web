<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>

</head>
<body>
<div>
	<div class="container p-4" style="margin-top: 80px">
		<div class="row">
			<section class="col col-6">
				<img src="${branch.image}" class="store_image"/>
			</section>
			<section class="col col-6">
				<div class="branches_info_body">
					<h2 class="branches_info_name">${branch.name}</h2>
					<p class="branches_info_desc">${branch.description}</p>
					<div class="branches_info_address">
						<b>Địa chỉ</b>
						<p>${branch.addressDetail}</p>
					</div>
					<div class="branches_info_open">
						<b>Giờ mở cửa</b>
						<p>${branch.opentime}</p>
					</div>
					<div class="branches_info_btn">
						<span>Xem menu quán</span>
					</div>
				</div>

			</section>

		</div>
	</div>

</div>
</body>
</html>