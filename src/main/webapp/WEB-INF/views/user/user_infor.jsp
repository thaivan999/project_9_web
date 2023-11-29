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
<link href='<c:url value="/css/user_info.css"/>' rel="stylesheet" type="text/css">
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

    <div class="content" style="margin-top: 80px">
        <div class="user-infor-title">Thông tin tài khoản</div>

        <div class = "user-infor-container">
            <div class = "user-infor user-name">Tên khách hàng</div>
            <div class ="user-infor user-name-textbox">
            <input type="text" class = "user-lastname-textbox textbox">
            <input type="text" class = "user-surname-textbox textbox">
            </div>

            <div class = "user-infor user-phone">Số điện thoại</div>
            <input type="text" class = "user-phone-textbox textbox">
            <div class = "user-infor user-birthday">Sinh nhật</div>
            <input type="text" class = "user-birthday-textbox textbox">
            <div class = "user-infor user-email">Email</div>
            <input type="email" class = "user-email-textbox textbox">
            <input type="radio" name="sex" id="check">Nam
            <input type="radio" name="sex" id="check">Nữ
            <div class = "user-infor user-update">
                <div class="branch_see_more">Cập nhật</div>
            </div>
        </div>
    </div>



</body>
</html>