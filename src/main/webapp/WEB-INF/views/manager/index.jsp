<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<body class="sb-nav-fixed">
	<%@include file="/common/admin/header/header.jsp"%>

	<div id="layoutSidenav_content">
		<form action="/ASM_Java4/admin/index" method="post">
			<main>
				<div class="container-fluid px-4">
					<h1 class="mt-4">BÁO CÁO - THỐNG KÊ</h1>
					<ol class="breadcrumb mb-4">
						<li class="breadcrumb-item active">Báo cáo - Thống kê</li>
					</ol>
					<div id= "report" class="row">
						
						<div class="col-xl-3 col-md-6">
							<div class="card bg-primary text-white mb-4">
								<div class="card-body">Tổng số người dùng</div>
								<h2 class="ms-3">${countUser}<i
										class="fas fad fa-user float-end me-2"></i>
								</h2>
							</div>
						</div>
						<div class="col-xl-3 col-md-6">
							<div class="card bg-warning text-white mb-4">
								<div class="card-body">Tổng số Video</div>
								<h2 class="ms-3">${countVideo}<i
										class="fas fad fa-video float-end me-2"></i>
								</h2>
							</div>
						</div>
						<div class="col-xl-3 col-md-6">
							<div class="card bg-success text-white mb-4">
								<div class="card-body">Tổng lượt xem</div>
								<h2 class="ms-3">${countViews}<i
										class="fas fad fa-eye float-end me-2"></i>
								</h2>
							</div>
						</div>
						<div class="col-xl-3 col-md-6">
							<div class="card bg-danger text-white mb-4">
								<div class="card-body">Tổng lượt thích</div>
								<h2 class="ms-3">${countLike}<i
										class="fas fad fa-heart float-end me-2"></i>
								</h2>
							</div>
						</div>
					</div>

					
								
					<div class="card mb-4">
						<ul class="nav nav-tabs" id="myTab" role="tablist">
							<li class="nav-item" role="presentation">
								<button class="nav-link ${ms1}" id="home-tab"
									data-bs-toggle="tab" data-bs-target="#home" type="button"
									role="tab" aria-controls="home" aria-selected="true">FAVORITES</button>
							</li>
							<li class="nav-item" role="presentation">
								<button class="nav-link ${ms2}" id="profile-tab"
									data-bs-toggle="tab" data-bs-target="#profile" type="button"
									role="tab" aria-controls="profile" aria-selected="false">FAVORITES
									USERS</button>
							</li>
							<li class="nav-item" role="presentation">
								<button class="nav-link ${ms3}" id="contact-tab"
									data-bs-toggle="tab" data-bs-target="#contact" type="button"
									role="tab" aria-controls="contact" aria-selected="false">SHARE
									FRIENDS</button>
							</li>
						</ul>
						
						<!--Favorites-->
						<div class="tab-content" id="myTabContent">
							<!--Favorites-->
							<div class="tab-pane fade ${message} mt-2 p-3" id="home"
								role="tabpanel" aria-labelledby="home-tab">
								<button class="btn btn-primary" onclick="exportToExcel()" style="margin-right: 15px;">
									<svg xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 384 512">
										<style>svg{fill:#e8e8e8}</style><path d="M48 448V64c0-8.8 7.2-16 16-16H224v80c0 17.7 14.3 32 32 32h80V448c0 8.8-7.2 16-16 16H64c-8.8 0-16-7.2-16-16zM64 0C28.7 0 0 28.7 0 64V448c0 35.3 28.7 64 64 64H320c35.3 0 64-28.7 64-64V154.5c0-17-6.7-33.3-18.7-45.3L274.7 18.7C262.7 6.7 246.5 0 229.5 0H64zm90.9 233.3c-8.1-10.5-23.2-12.3-33.7-4.2s-12.3 23.2-4.2 33.7L161.6 320l-44.5 57.3c-8.1 10.5-6.3 25.5 4.2 33.7s25.5 6.3 33.7-4.2L192 359.1l37.1 47.6c8.1 10.5 23.2 12.3 33.7 4.2s12.3-23.2 4.2-33.7L222.4 320l44.5-57.3c8.1-10.5 6.3-25.5-4.2-33.7s-25.5-6.3-33.7 4.2L192 280.9l-37.1-47.6z"/>
									</svg>
									Xuất Excel
								</button>
								<button class="btn btn-success" onclick="exportToWord()" style="margin-right:15px">
									<svg xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 384 512">
										<style>svg{fill:#e8e8e8}</style><path d="M48 448V64c0-8.8 7.2-16 16-16H224v80c0 17.7 14.3 32 32 32h80V448c0 8.8-7.2 16-16 16H64c-8.8 0-16-7.2-16-16zM64 0C28.7 0 0 28.7 0 64V448c0 35.3 28.7 64 64 64H320c35.3 0 64-28.7 64-64V154.5c0-17-6.7-33.3-18.7-45.3L274.7 18.7C262.7 6.7 246.5 0 229.5 0H64zm55 241.1c-3.8-12.7-17.2-19.9-29.9-16.1s-19.9 17.2-16.1 29.9l48 160c3 10.2 12.4 17.1 23 17.1s19.9-7 23-17.1l25-83.4 25 83.4c3 10.2 12.4 17.1 23 17.1s19.9-7 23-17.1l48-160c3.8-12.7-3.4-26.1-16.1-29.9s-26.1 3.4-29.9 16.1l-25 83.4-25-83.4c-3-10.2-12.4-17.1-23-17.1s-19.9 7-23 17.1l-25 83.4-25-83.4z"/>
									</svg>
									Xuất Word
								</button>
								<table id="example1" class="table mt-2 table-bordered">
									<thead>
										<tr>
											<th>Video Title</th>
											<th>Favorite Count</th>
											<th>Latest Date</th>
											<th>Oldest Date</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="item" items="${videos}">
											<tr>
												<td>${item.group}</td>
												<td>${item.likes}</td>
												<td>
													<fmt:formatDate value="${item.newest}" pattern="yyyy-MM-dd" />
												</td>
												<td>
													<fmt:formatDate value="${item.oldest}" pattern="yyyy-MM-dd" />
												</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
							
							<!--Favorites User-->
							<div class="tab-pane fade ${message1} mt-2 p-3" id="profile"
								role="tabpanel" aria-labelledby="profile-tab">
								<div class="row">
									<h4 class="col-2">Video Title?</h4>
									<select name="title1" class="col-8 form-select pe-2"
										aria-label="Default select example" style="width: 70%;">
										<option selected></option>
										<c:forEach var="sel1" items="${sel1}">
											<option value="${sel1}">${sel1}</option>
										</c:forEach>
									</select>
									<button type="submit" class="ms-1 col-2 btn btn-primary"
										formaction="/ASM_Java4/admin/index/report1"
										style="width: 80px;">Tìm</button>
								</div>
								<button class="btn btn-primary" onclick="exportToExcelUsers()" style="margin-right: 15px;margin-top:15px">
									<svg xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 384 512">
										<style>svg{fill:#e8e8e8}</style><path d="M48 448V64c0-8.8 7.2-16 16-16H224v80c0 17.7 14.3 32 32 32h80V448c0 8.8-7.2 16-16 16H64c-8.8 0-16-7.2-16-16zM64 0C28.7 0 0 28.7 0 64V448c0 35.3 28.7 64 64 64H320c35.3 0 64-28.7 64-64V154.5c0-17-6.7-33.3-18.7-45.3L274.7 18.7C262.7 6.7 246.5 0 229.5 0H64zm90.9 233.3c-8.1-10.5-23.2-12.3-33.7-4.2s-12.3 23.2-4.2 33.7L161.6 320l-44.5 57.3c-8.1 10.5-6.3 25.5 4.2 33.7s25.5 6.3 33.7-4.2L192 359.1l37.1 47.6c8.1 10.5 23.2 12.3 33.7 4.2s12.3-23.2 4.2-33.7L222.4 320l44.5-57.3c8.1-10.5 6.3-25.5-4.2-33.7s-25.5-6.3-33.7 4.2L192 280.9l-37.1-47.6z"/>
									</svg>
									Xuất Excel
								</button>
								<button class="btn btn-success" onclick="exportToWordUsers()"style="margin-top:15px">
									<svg xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 384 512">
										<style>svg{fill:#e8e8e8}</style><path d="M48 448V64c0-8.8 7.2-16 16-16H224v80c0 17.7 14.3 32 32 32h80V448c0 8.8-7.2 16-16 16H64c-8.8 0-16-7.2-16-16zM64 0C28.7 0 0 28.7 0 64V448c0 35.3 28.7 64 64 64H320c35.3 0 64-28.7 64-64V154.5c0-17-6.7-33.3-18.7-45.3L274.7 18.7C262.7 6.7 246.5 0 229.5 0H64zm55 241.1c-3.8-12.7-17.2-19.9-29.9-16.1s-19.9 17.2-16.1 29.9l48 160c3 10.2 12.4 17.1 23 17.1s19.9-7 23-17.1l25-83.4 25 83.4c3 10.2 12.4 17.1 23 17.1s19.9-7 23-17.1l48-160c3.8-12.7-3.4-26.1-16.1-29.9s-26.1 3.4-29.9 16.1l-25 83.4-25-83.4c-3-10.2-12.4-17.1-23-17.1s-19.9 7-23 17.1l-25 83.4-25-83.4z"/>
									</svg>
									Xuất Word
								</button>
								<table id="example2" class="table mt-2 table-bordered">
									<thead>
										<tr>
											<th>Username</th>
											<th>Fullname</th>
											<th>Email</th>
											<th>Favorite Date</th>
											<th>Video Like</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="user" items="${user}">
											<tr>
												<td>${user.user.id}</td>
												<td>${user.user.fullname}</td>
												<td>${user.user.email}</td>
												<td>
													<fmt:formatDate value="${user.likeDate}" pattern="yyyy-MM-dd" />
												</td>
												<td>${user.video.id}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
							
							<!--Share Friends-->
							<div class="tab-pane fade ${message2} mt-2 p-3" id="contact"
								role="tabpanel" aria-labelledby="contact-tab">
								<div class="row">
									<h4 class="col-2">Video Title?</h4>
									<select name="title2" class="col-8 form-select pe-2"
										aria-label="Default select example" style="width: 70%;">
										<option selected></option>
										<c:forEach var="sel1" items="${sel1}">
											<option value="${sel1}">${sel1}</option>
										</c:forEach>
									</select>
									<button type="submit" class="ms-1 col-2 btn btn-primary"
										formaction="/ASM_Java4/admin/index/report2"
										style="width: 80px;">Tìm</button>
								</div>
								<button class="btn btn-primary" onclick="exportToExcelShares()"
									style="margin-right: 15px;margin-top:15px">
									<svg xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 384 512">
										<style>svg{fill:#e8e8e8}</style><path d="M48 448V64c0-8.8 7.2-16 16-16H224v80c0 17.7 14.3 32 32 32h80V448c0 8.8-7.2 16-16 16H64c-8.8 0-16-7.2-16-16zM64 0C28.7 0 0 28.7 0 64V448c0 35.3 28.7 64 64 64H320c35.3 0 64-28.7 64-64V154.5c0-17-6.7-33.3-18.7-45.3L274.7 18.7C262.7 6.7 246.5 0 229.5 0H64zm90.9 233.3c-8.1-10.5-23.2-12.3-33.7-4.2s-12.3 23.2-4.2 33.7L161.6 320l-44.5 57.3c-8.1 10.5-6.3 25.5 4.2 33.7s25.5 6.3 33.7-4.2L192 359.1l37.1 47.6c8.1 10.5 23.2 12.3 33.7 4.2s12.3-23.2 4.2-33.7L222.4 320l44.5-57.3c8.1-10.5 6.3-25.5-4.2-33.7s-25.5-6.3-33.7 4.2L192 280.9l-37.1-47.6z"/>
									</svg>
									Xuất Excel</button>
								<button class="btn btn-success" onclick="exportToWordShares()"style="margin-top:15px">
									<svg xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 384 512">
										<style>svg{fill:#e8e8e8}</style><path d="M48 448V64c0-8.8 7.2-16 16-16H224v80c0 17.7 14.3 32 32 32h80V448c0 8.8-7.2 16-16 16H64c-8.8 0-16-7.2-16-16zM64 0C28.7 0 0 28.7 0 64V448c0 35.3 28.7 64 64 64H320c35.3 0 64-28.7 64-64V154.5c0-17-6.7-33.3-18.7-45.3L274.7 18.7C262.7 6.7 246.5 0 229.5 0H64zm55 241.1c-3.8-12.7-17.2-19.9-29.9-16.1s-19.9 17.2-16.1 29.9l48 160c3 10.2 12.4 17.1 23 17.1s19.9-7 23-17.1l25-83.4 25 83.4c3 10.2 12.4 17.1 23 17.1s19.9-7 23-17.1l48-160c3.8-12.7-3.4-26.1-16.1-29.9s-26.1 3.4-29.9 16.1l-25 83.4-25-83.4c-3-10.2-12.4-17.1-23-17.1s-19.9 7-23 17.1l-25 83.4-25-83.4z"/>
									</svg>	
									Xuất Word
								</button>
								<table id="example3" class="table mt-2 table-bordered">
									<thead>
										<tr>
											<th>Sender Name</th>
											<th>Sender Email</th>
											<th>Receiver Email</th>
											<th>Sent Date</th>
											<th>Video Share</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="sha" items="${share}">
											<tr>
												<td>${sha.user.fullname}</td>
												<td>${sha.user.email}</td>
												<td>${sha.email}</td>
												<td>
													<fmt:formatDate value="${sha.shareDate}" pattern="yyyy-MM-dd" />
												</td>
												<td>${sha.video.id}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
							<!--Share Friends-->
						</div>
					</div>
				</div>
			</main>
		</form>
	</div>
	<script>
		function exportToExcel() {
			var tableClone = $('#example1').clone();
			var wb = XLSX.utils.table_to_book(tableClone[0], {
				sheet : "Sheet JS"
			});
			XLSX.writeFile(wb, "Danh Sách Video Được Yêu Thích.xlsx");
		}
		function exportToWord() {
			var tableClone = $('#example1').clone();
			var newHtml = tableClone.prop('outerHTML');
			var blob = new Blob([ '\ufeff', newHtml ], {
				type : 'application/msword'
			});
			var url = URL.createObjectURL(blob);
			var a = document.createElement('a');
			a.href = url;
			a.download = 'Danh Sách Video Được Yêu Thích.doc';
			document.body.appendChild(a);
			a.click();
			document.body.removeChild(a);
		}
		function exportToExcelUsers() {
			var tableClone = $('#example2').clone();
			var wb = XLSX.utils.table_to_book(tableClone[0], {
				sheet : "Sheet JS"
			});
			XLSX.writeFile(wb, "Danh Sách Người Dùng Yêu Thích.xlsx");
		}
		function exportToWordUsers() {
			var tableClone = $('#example2').clone();
			var newHtml = tableClone.prop('outerHTML');
			var blob = new Blob([ '\ufeff', newHtml ], {
				type : 'application/msword'
			});
			var url = URL.createObjectURL(blob);
			var a = document.createElement('a');
			a.href = url;
			a.download = 'Danh Sách Người Dùng Yêu Thích.doc';
			document.body.appendChild(a);
			a.click();
			document.body.removeChild(a);
		}

		function exportToExcelShares() {
			var tableClone = $('#example3').clone();
			var wb = XLSX.utils.table_to_book(tableClone[0], {
				sheet : "Sheet JS"
			});
			XLSX.writeFile(wb, "Danh Sách Người Dùng Chia Sẻ Video.xlsx");
		}
		function exportToWordShares() {
			var tableClone = $('#example3').clone();
			var newHtml = tableClone.prop('outerHTML');
			var blob = new Blob([ '\ufeff', newHtml ], {
				type : 'application/msword'
			});
			var url = URL.createObjectURL(blob);
			var a = document.createElement('a');
			a.href = url;
			a.download = 'Danh Sách Người Dùng Chia Sẻ Video.doc';
			document.body.appendChild(a);
			a.click();
			document.body.removeChild(a);
		}
	</script>
</body>

</html>
