<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product</title>
</head>
<body>
	<div class="products">
		<div class="row gx-2">
			<div class="col-3 p-3 ps-4" style="border-right: 1px solid #ccc">
				<div class="products-category">
					<c:set var="index" value="0"></c:set>
					<c:forEach var="category" items="${categories}">
						<span>${category.name}</span>
						<ul>
							<c:forEach var="type" items="${types[index]}">
								<li><a href="/products/type/${type.idType}">${type.name}</a></li>
							</c:forEach>
						</ul>
						<c:set var="index" value="${index + 1 }"></c:set>
					</c:forEach>
				</div>
			</div>

			<div class="col-9 products-item">
				<div class="row gx-4">
					<c:forEach var="milkTea" items="${milkTeas}">
						<div class="col-4"
							onclick="window.location.href='product_detail/${type.idType}';">
							<div class="card">
								<div class="img-container">
									<img
										src="https://i1.wp.com/talkboba.com/wp-content/uploads/2019/04/strawberry-milk-tea-tb.jpg?zoom=0.800000011920929&fit=1024%2C1024&ssl=1"
										class="card-image card-img-top" alt="...">
								</div>
								<div class="card-body">
									<h5 class="card-title">${milkTea.name}</h5>
									<p class="card-price">${milkTea.cost}</p>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
