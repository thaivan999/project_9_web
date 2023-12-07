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
            <form action="/user_infor/${customer.idUser}/update" method="post">
                <input type="text" name="id_user" id="id_user" hidden="hidden">
                <div class = "user-infor user-name">Tên khách hàng</div>
                <div class ="user-infor user-name-textbox">
                <input type="text" class = "user-lastname-textbox textbox" value="${customer.name}" required placeholder="Tên khách hàng">
                <input type="text" class = "user-surname-textbox textbox" value="${customer.surname}" required placeholder="Họ khách hàng">
                </div>
    
                <div class = "user-infor user-phone">Số điện thoại</div>
                <input type="tel" name = "phone" id="phone" class = "user-phone-textbox textbox" value="${customer.phoneNumber}" readonly>
                <div class = "user-infor user-birthday">Sinh nhật</div>
                <input type="date" class = "user-birthday-textbox textbox" value="${customer.birthday}" required>
                <div class = "user-infor user-email">Email</div>
                <input type="email" class = "user-email-textbox textbox" value="${customer.email}" readonly>
                <input type="radio" name="sex" id="nam" ${customer.gender == 1 ? 'checked="checked"' : ""} required>Nam
                <input type="radio" name="sex" id="nu" ${customer.gender == 0 ? 'checked="checked"' : ""}>Nữ
                <input type="submit" class="user-update-button" value="Cập nhật" >
                
            </form>
        </div>
    </div>



</body>
</html>