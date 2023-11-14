<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
 	<!-- Site meta -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<!-- CSS -->
    <link href='<c:url value="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"/>' rel="stylesheet" type="text/css">
	<link href='<c:url value="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"/>' rel="stylesheet" type="text/css">
	<link href='<c:url value="https://fonts.googleapis.com/css?family=Open+Sans:400,300,600"/>' rel="stylesheet" type="text/css">
</head>
<body>
	<%@ include file="/common/user/header.jsp"%>
	<decorator:body />
	<%@ include file="/common/user/footer.jsp"%>
	<!-- JS -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" type="text/javascript"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" type="text/javascript"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" type="text/javascript"></script>
</body>
</html>