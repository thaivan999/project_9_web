<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User</title>
<link href='<c:url value="/user/css/header.css" />'rel="stylesheet" />
<link href='<c:url value="/user/css/footer.css" />'rel="stylesheet" />
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Open+Sans:400,300,600" rel="stylesheet" type="text/css">
<link href='<c:url value="/user/css/home.css" />'rel="stylesheet" />
<link href='<c:url value="/user/css/payment.css"/>' rel="stylesheet" type="text/css">
<link href='<c:url value="/user/css/product_detail.css"/>' rel="stylesheet" type="text/css">
<link href='<c:url value="/user/css/order.css"/>' rel="stylesheet" type="text/css">
<link href='<c:url value="/user/css/branches.css"/>' rel="stylesheet" type="text/css">
<link href='<c:url value="/user/css/branches_info.css"/>'rel="stylesheet" type="text/css">
<link href='<c:url value="/user/css/cart.css"/>' rel="stylesheet" type="text/css">
<link href='<c:url value="/user/css/user_infor.css"/>' rel="stylesheet" type="text/css">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"
	integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
	<%@ include file="/common/user/header/header.jsp"%>
	<sitemesh:write property='body'/>
	<%@ include file="/common/user/footer/footer.jsp"%>

	<!-- JS -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		type="text/javascript"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		type="text/javascript"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		type="text/javascript"></script>
</body>
</html>