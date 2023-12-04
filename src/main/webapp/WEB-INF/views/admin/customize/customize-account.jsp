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
    <title>QUẢN LÝ TÀI KHOẢN</title>
    <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
    <link href="<c:url value='/templates/admin/css/styles.css'/>" rel="stylesheet" />
    <link href="<c:url value='/templates/admin/css/my-style.css'/>" rel="stylesheet" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
</head>
<body class="sb-nav-fixed">
    <%@include file="/common/admin/header/header.jsp"%>
    <div id="layoutSidenav_content">
        <main>
            <div class="container-fluid px-4">
                <h1 class="mt-4">QUẢN LÝ TÀI KHOẢN</h1>
                <ol class="breadcrumb mb-4">
                    <li class="breadcrumb-item"><a style="text-decoration: none" href="/admin/index">Trang chủ</a></li>
                    <li class="breadcrumb-item active"><a style="text-decoration: none; color: black" href="/admin/account-update">Cập nhật tài khoản</a></li>
                </ol>
                <div class = "card-header">
                	<h2>${account.isEdit?'Edit Account':'Add Account'}</h2>
                </div>
                <div class="card mb-4">
                    <form class="mt-3 ms-3 me-3 mb-3" action="/admin/customize-account/saveOrUpdate" method="post">
                        <!-- ID Account -->
                        <div class="mb-3">
                            <label for="exampleInputAccountId" class="form-label">ID Account*</label> 
                            <input placeholder="Account ID" name="id_account" type="text" class="form-control" id="exampleInputAccountId" aria-describedby="accountIdHelp" value="${account.idAccount}" required="required" disabled>
                        </div>

                        <!-- ID User -->
                        <div class="mb-3">
                            <label for="exampleInputUserId" class="form-label">ID User*</label> 
                            <input placeholder="User ID" name="id_user" type="text" class="form-control" id="exampleInputUserId" aria-describedby="userIdHelp" value="${account.customerByAccount}" required="required" disabled>
                        </div>

                        <!-- Username -->
                        <div class="mb-3">
                            <label for="exampleInputUsername" class="form-label">Tên tài khoản*</label> 
                            <input placeholder="Username?" name="username" type="text" class="form-control" id="exampleInputUsername" aria-describedby="usernameHelp" value="${account.username}" required="required">
                        </div>

                        <!-- Password -->
                        <div class="mb-3">
                            <label for="exampleInputPassword" class="form-label">Mật khẩu*</label> 
                            <input placeholder="Password?" name="password" type="password" class="form-control" id="exampleInputPassword" value="${account.password}" required="required">
                        </div>

                        <!-- Create At -->
                        <div class="mb-3">
                            <label for="exampleInputCreateAt" class="form-label">Ngày tạo*</label> 
                            <input placeholder="Create At" name="create_at" type="text" class="form-control" id="exampleInputCreateAt" value="${account.createAt}" required="required" disabled>
                        </div>

                        <!-- ID Role -->
                        <div class="mb-3">
                            <label for="exampleInputRoleId" class="form-label">ID Role*</label> 
                            <input placeholder="Role ID" name="id_role" type="text" class="form-control" id="exampleInputRoleId" aria-describedby="roleIdHelp" value="${account.userRoleByAccount}"  required="required" disabled>
                        </div>

                        <!-- ID Branch -->
                        <div class="mb-3">
                            <label for="exampleInputBranchId" class="form-label">ID Branch*</label> 
                            <input placeholder="Branch ID" name="id_branch" type="text" class="form-control" id="exampleInputBranchId" aria-describedby="branchIdHelp" value="${account.branchByAccount}"  required="required" disabled>
                        </div>

                        <div class="text-end">
                            <button type="submit" class="btn btn-success">
                            	<c:if test="${account.isEdit}">
                            		<span>Update</span>
                            	</c:if>
                            	<c:if test="${!account.isEdit}">
                            		<span>Save</span>
                            	</c:if>
                            </button>
                        </div>
                    </form>
                    <h6 class="ms-3 text-primary">${message}</h6>
                </div>
            </div>
        </main>
    </div>
</body>
</html>
