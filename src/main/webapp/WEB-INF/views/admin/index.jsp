<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<body class="sb-nav-fixed">
	<%@include file="/common/admin/header/header.jsp"%>

	<div id="layoutSidenav_content">
		<main>
		    <div class="container-fluid px-4">
		        <h1 class="mt-4">BÁO CÁO - THỐNG KÊ</h1>
		        <ol class="breadcrumb mb-4">
		            <li class="breadcrumb-item active">Báo cáo - Thống kê</li>
		        </ol>
		        <div id= "report" class="row">
		            
		            <div class="col-xl-4 col-md-6">
		                <div class="card bg-primary text-white mb-4">
		                    <div class="card-body">Tổng số người dùng</div>
		                    <h2 class="ms-3">${countUser}<i
		                            class="fas fad fa-user float-end me-2"></i>
		                    </h2>
		                </div>
		            </div>
		            <div class="col-xl-4 col-md-6">
		                <div class="card bg-warning text-white mb-4">
		                    <div class="card-body">Tổng số đơn hàng</div>
		                    <h2 class="ms-3">${countOrder}<i
		                            class="fas fad fa-shopping-cart float-end me-2"></i>
		                    </h2>
		                </div>
		            </div>
		            <div class="col-xl-4 col-md-6">
		                <div class="card bg-success text-white mb-4">
		                    <div class="card-body">Tổng số sản phẩm</div>
		                    <h2 class="ms-3">${countProduct}<i
		                            class="fas fad fa-glass-martini float-end me-2"></i>
		                    </h2>
		                </div>
		            </div>
		        </div>
		        <div class="col-xl-12">
				    <div class="card mb-4">
				        <div class="card-header">
				            <h5 class="card-title">Doanh thu theo ngày trong tháng này</h5>
				        </div>
				        <div class="card-body">
				            <canvas id="revenueChartByDay" width="400" height="200"></canvas>
				        </div>
				    </div>
				</div>	
				<div class="col-xl-12">
				    <div class="card mb-4">
				        <div class="card-header">
				            <h5 class="card-title">Doanh thu theo tháng trong năm nay</h5>
				        </div>
				        <div class="card-body">
				            <canvas id="revenueChartByMonth" width="400" height="200"></canvas>
				        </div>
				    </div>
				</div>						        
		    </div>
		</main>
	</div>	
	
	<script>
		function createChart(revenueData, chartId) {
		    var labels = revenueData.map(function(item) {
		    	if(chartId == 'revenueChartByMonth') 
		    		return 'Tháng ' + item[0];
		        return 'Ngày ' + item[0].join('-');
		    });
	
		    var data = revenueData.map(function(item) {
		        return item[1];
		    });
	
		    var ctx = document.getElementById(chartId).getContext('2d');
		    var myChart = new Chart(ctx, {
		        type: 'bar',
		        data: {
		            labels: labels,
		            datasets: [{
		                label: 'Doanh thu',
		                data: data,
		                backgroundColor: 'rgba(75, 192, 192, 0.2)',
		                borderColor: 'rgba(75, 192, 192, 1)',
		                borderWidth: 1
		            }]
		        },
		        options: {
		            scales: {
		                y: {
		                    beginAtZero: true
		                }
		            }
		        }
		    });
		}
	
		var revenueDataByDay = <c:out value="${revenueDataByDayJson}" />;
		createChart(revenueDataByDay, 'revenueChartByDay');
	
		var revenueDataByMonth = <c:out value="${revenueDataByMonthJson}" />;
		createChart(revenueDataByMonth, 'revenueChartByMonth');
	</script>	
</body>

</html>
