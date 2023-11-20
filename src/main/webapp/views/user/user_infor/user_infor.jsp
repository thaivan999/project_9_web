<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thông tin tài khoản</title>
</head>
<body>

  <div class="content">
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
                <input type="button" class="user-update-button" value="Cập nhật">
            </div>
        </div>
    </div>


</body>
</html>