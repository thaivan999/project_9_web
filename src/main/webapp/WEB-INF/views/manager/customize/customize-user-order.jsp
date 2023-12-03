<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>QUẢN LÝ ĐƠN HÀNG</title>
    <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
    <link href="<c:url value='/templates/manager/css/styles.css'/>" rel="stylesheet" />
    <link href="<c:url value='/templates/manager/css/my-style.css'/>" rel="stylesheet" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
</head>
<body class="sb-nav-fixed">
    <%@include file="/common/manager/header/header.jsp"%>
    <div id="layoutSidenav_content">
        <main>
            <div class="container-fluid px-4">
                <h1 class="mt-4">QUẢN LÝ ĐƠN HÀNG</h1>
                <ol class="breadcrumb mb-4">
                    <li class="breadcrumb-item"><a style="text-decoration: none" href="/manager/index">Trang chủ</a></li>
                    <li class="breadcrumb-item active"><a style="text-decoration: none; color: black" href="/manager/user-order-update">Cập nhật đơn hàng</a></li>
                </ol>
                <div class="card mb-4">
                    <form class="mt-3 ms-3 me-3 mb-3" action="/manager/user-order-update/create" method="post">
                        <!-- ID Order -->
                        <div class="mb-3">
                            <label for="exampleInputOrderId" class="form-label">ID Order*</label> 
                            <input placeholder="Order ID" name="id_order" type="text" class="form-control" id="exampleInputOrderId" aria-describedby="orderIdHelp" value="${userOrder.id_order}" ${loguser} required="required">
                        </div>

                        <!-- ID User -->
                        <div class="mb-3">
                            <label for="exampleInputUserId" class="form-label">ID User*</label> 
                            <input placeholder="User ID" name="id_user" type="text" class="form-control" id="exampleInputUserId" aria-describedby="userIdHelp" value="${userOrder.id_user}" required="required">
                        </div>

                        <!-- Total Product -->
                        <div class="mb-3">
                            <label for="exampleInputTotalProduct" class="form-label">Tổng số sản phẩm*</label> 
                            <input placeholder="Total Product" name="total_product" type="text" class="form-control" id="exampleInputTotalProduct" aria-describedby="totalProductHelp" value="${userOrder.total_product}" required="required">
                        </div>

                        <!-- Total Price -->
                        <div class="mb-3">
                            <label for="exampleInputTotalPrice" class="form-label">Tổng giá*</label> 
                            <input placeholder="Total Price" name="total_price" type="text" class="form-control" id="exampleInputTotalPrice" aria-describedby="totalPriceHelp" value="${userOrder.total_price}" required="required">
                        </div>

                        <!-- Order Time -->
                        <div class="mb-3">
                            <label for="exampleInputOrderTime" class="form-label">Thời gian đặt hàng*</label> 
                            <input placeholder="Order Time" name="order_time" type="datetime-local" class="form-control" id="exampleInputOrderTime" aria-describedby="orderTimeHelp" value="${userOrder.order_time}" required="required">
                        </div>

                        <!-- ID Pay Method -->
                        <div class="mb-3">
                            <label for="exampleInputPayMethodId" class="form-label">ID Pay Method*</label> 
                            <input placeholder="Pay Method ID" name="id_pay_method" type="text" class="form-control" id="exampleInputPayMethodId" aria-describedby="payMethodIdHelp" value="${userOrder.id_pay_method}" required="required">
                        </div>

                        <!-- Order State -->
                        <div class="mb-3">
                            <label for="exampleInputOrderState" class="form-label">Trạng thái đơn hàng*</label> 
                            <input placeholder="Order State" name="order_state" type="text" class="form-control" id="exampleInputOrderState" aria-describedby="orderStateHelp" value="${userOrder.order_state}" required="required">
                        </div>

                        <!-- Tentative Time -->
                        <div class="mb-3">
                            <label for="exampleInputTentativeTime" class="form-label">Thời gian dự kiến*</label> 
                            <input placeholder="Tentative Time" name="tentative_time" type="datetime-local" class="form-control" id="exampleInputTentativeTime" aria-describedby="tentativeTimeHelp" value="${userOrder.tentative_time}" required="required">
                        </div>

                        <!-- Additional form fields go here -->

                        <div class="text-end">
                            <button type="submit" class="btn btn-primary" formaction="/manager/user-order-update/create" ${buttonnolog}>Thêm</button>
                            <button type="submit" class="btn btn-success" formaction="/manager/user-order-update/update" ${buttonlog}>Sửa</button>
                            <button type="submit" class="btn btn-danger" formaction="/manager/user-order-update/delete" ${buttonlog1} ${buttonxoa}>Xóa</button>
                        </div>
                    </form>
                    <h6 class="ms-3 text-primary">${message}</h6>
                </div>
            </div>
        </main>
    </div>
</body>
</html>
