<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="search.css" />
</head>
<body>
	<p class="search-content">Kết quả tìm kiếm cho từ khóa xxx</p>
	<div style="margin-top: 20px; margin-left: 50px;">
		<button type="button" class="btn btn-success">bán chạy</button>
		<div class="btn-group">
			<button type="button" class="btn btn-warning dropdown-toggle"
				data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				Giá</button>
			<div class="dropdown-menu">
				<script>
					function redirectToNewUrl(url) {
						window.location.href = url;
					}
				</script>

				<a class="dropdown-item" href="javascript:void(0);"
					onclick="redirectToNewUrl('${newUrlLowToHigh}')">Giá: Thấp đến cao
				</a> 
				<a class="dropdown-item" href="javascript:void(0);"
					onclick="redirectToNewUrl('${newUrlHighToLow}')">Giá: Cao đến thấp
				</a>
			</div>
		</div>
	</div>

	<div class="products">
		<div class="col-9 products-item">
			<div class="row gx-4">
				<c:forEach var="milkTea" items="${milkTeas}">
					<div class="col-4">
						<a href="/product_detail/${milkTea.idMilkTea}" class="card">
							<div class="img-container">
								<img
									src="https://i1.wp.com/talkboba.com/wp-content/uploads/2019/04/strawberry-milk-tea-tb.jpg?zoom=0.800000011920929&fit=1024%2C1024&ssl=1"
									class="card-image card-img-top" alt="...">
							</div>
							<div class="card-body">
								<h5 class="card-title">${milkTea.name}</h5>
								<p class="card-price">${milkTea.cost}</p>
							</div>
						</a>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>
