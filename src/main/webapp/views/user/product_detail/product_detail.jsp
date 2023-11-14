<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
	
</head>
<body>
	<!-- Breadcrumb -->
	<div class="container">
	    <div class="row">
	        <div class="col">
	            <nav aria-label="breadcrumb">
	                <ol class="breadcrumb">
	                    <li class="breadcrumb-item"><a class="black-text bold-text" href="">Menu</a></li>
	                    <!-- Sau này thay tên bằng các field cụ thể -->
	                    <li class="breadcrumb-item"><a class="black-text bold-text" href="">Trà Thảo Mộc</a></li>
	                    <li class="breadcrumb-item active bold-text" aria-current="page">Trà Xanh</li>
	                </ol>
	            </nav>
	        </div>
	    </div>
	</div>
	<!-- End: Breadcrumb -->
	
	<div class="container">
	    <div class="row">
	        <!-- Main product image -->
	        <div class="col-12 col-lg-6">
	            <div class="card mb-3 no-border">
	                <div class="card-body" style="padding: 0;">
	                    <a href="" data-toggle="modal" data-target="#productModal">
	                        <img class="img-fluid" style="border-radius: 10px;" src="https://dummyimage.com/500x500/d6d6d6"/>
	                    </a>
	                </div>
	            </div>
	        </div>
	
	        <!-- Add to cart -->
	        <div class="col-12 col-lg-6 add_to_cart_block">
	            <div class="card mb-3 no-border">
	                <div class="card-body">
	                    <p class="h3 bold-text">Trà Xanh</p>
	                    <p class="h4 price bold-text" style="color: #707070;">39.000đ</p>
	                    <form method="get" action="">
						    <div class="form-group">
						        <label class="mt-2 fs-18">Chọn size</label><br/>
						        <button type="button" class="btn btn-outline-dark">Vừa +0đ</button>
						        <button type="button" class="btn btn-outline-dark ml-1">Lớn +5.000đ</button>
						    </div>
						    <div class="form-group">
						        <label class="fs-18">Topping</label><br/>
						        <button type="button" class="btn btn-outline-dark">Kem phô mai +5000đ</button>
						        <button type="button" class="btn btn-outline-dark ml-1">Thạch cà phê +5000đ</button>
						    </div>
						    <div class="form-group">
						        <button type="button" class="btn btn-outline-dark btn-lg mt-2 black-text bold-text" style="width: 215px;">Thêm vào giỏ hàng</button>
						        <button type="button" class="btn btn-dark btn-lg ml-1 mt-2 bold-text" style="width: 215px;">Mua ngay</button>
						    </div>
						</form>
		            </div>
		        </div>
		    </div>
	
	    <div class="row">
	        <!-- Description -->
	        <div class="col-12">
	            <div class="card border-light mb-3">
	                <div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-align-justify"></i> Description</div>
	                <div class="card-body">
	                    <p class="card-text">
	                        Le Lorem Ipsum est simplement du faux texte employé dans la composition et la mise en page avant impression. Le Lorem Ipsum est le faux texte standard de l'imprimerie depuis les années 1500, quand un peintre anonyme assembla ensemble des morceaux de texte pour réaliser un livre spécimen de polices de texte. Il n'a pas fait que survivre cinq siècles, mais s'est aussi adapté à la bureautique informatique, sans que son contenu n'en soit modifié. Il a été popularisé dans les années 1960 grâce à la vente de feuilles Letraset contenant des passages du Lorem Ipsum, et, plus récemment, par son inclusion dans des applications de mise en page de texte, comme Aldus PageMaker.
	                    </p>
	                    <p class="card-text">
	                        Contrairement à une opinion répandue, le Lorem Ipsum n'est pas simplement du texte aléatoire. Il trouve ses racines dans une oeuvre de la littérature latine classique datant de 45 av. J.-C., le rendant vieux de 2000 ans. Un professeur du Hampden-Sydney College, en Virginie, s'est intéressé à un des mots latins les plus obscurs, consectetur, extrait d'un passage du Lorem Ipsum, et en étudiant tous les usages de ce mot dans la littérature classique, découvrit la source incontestable du Lorem Ipsum. Il provient en fait des sections 1.10.32 et 1.10.33 du "De Finibus Bonorum et Malorum" (Des Suprêmes Biens et des Suprêmes Maux) de Cicéron. Cet ouvrage, très populaire pendant la Renaissance, est un traité sur la théorie de l'éthique. Les premières lignes du Lorem Ipsum, "Lorem ipsum dolor sit amet...", proviennent de la section 1.10.32.
	                    </p>
	                </div>
	            </div>
	        </div>
	
	        <!-- Reviews -->
	        <div class="col-12" id="reviews">
	            <div class="card border-light mb-3">
	                <div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-comment"></i> Reviews</div>
	                <div class="card-body">
	                    <div class="review">
	                        <span class="glyphicon glyphicon-calendar" aria-hidden="true"></span>
	                        <meta itemprop="datePublished" content="01-01-2016">January 01, 2018
	
	                        <span class="fa fa-star"></span>
	                        <span class="fa fa-star"></span>
	                        <span class="fa fa-star"></span>
	                        <span class="fa fa-star"></span>
	                        <span class="fa fa-star"></span>
	                        by Paul Smith
	                        <p class="blockquote">
	                            <p class="mb-0">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.</p>
	                        </p>
	                        <hr>
	                    </div>
	                    <div class="review">
	                        <span class="glyphicon glyphicon-calendar" aria-hidden="true"></span>
	                        <meta itemprop="datePublished" content="01-01-2016">January 01, 2018
	
	                        <span class="fa fa-star" aria-hidden="true"></span>
	                        <span class="fa fa-star" aria-hidden="true"></span>
	                        <span class="fa fa-star" aria-hidden="true"></span>
	                        <span class="fa fa-star" aria-hidden="true"></span>
	                        <span class="fa fa-star" aria-hidden="true"></span>
	                        by Paul Smith
	                        <p class="blockquote">
	                            <p class="mb-0">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.</p>
	                        </p>
	                        <hr>
	                    </div>
	                </div>
	            </div>
	        </div>
	    </div>
	</div>
</body>
</html>