<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
<title>Trang chủ</title>
<body>

	<!-- 
	Body Section -->
	<div class="row">
		<div id="sidebar" class="span3">
			<div class="well well-small">
				<ul class="nav nav-list">

					<c:forEach var="item" items="${ categories }">
						<li><a href="<c:url value="/san-pham/${ item.id }"/>"><span
								class="icon-chevron-right"></span> ${ item.name }</a></li>
						<li>
					</c:forEach>

					
				</ul>
			</div>

			
			<div class="well well-small">
				<a href="#"><img
					src="<c:url value="/assets/user/img/paypal.jpg"/>"
					alt="payment method paypal"></a>
			</div>

			<a class="shopBtn btn-block" href="#">Upcoming products <br>
				<small>Click to view</small></a> <br> <br>
			<ul class="nav nav-list promowrapper">
				<li>
					<div class="thumbnail">
						<a class="zoomTool"
							href="<c:url value="/assets/user/html/product_details.html"/>"
							title="add to cart"><span class="icon-search"></span> Xem chi tiết</a> <img
							src="<c:url value="/assets/user/img/anh-minh-hoa-1.jpg"/>"
							alt="san pham tieu bieu 1">
						<div class="caption">
							<h4>
								<a class="defaultBtn"
									href="<c:url value="/assets/user/html/product_details.html"/>">VIEW</a>
								<span class="pull-right">535.000 đ</span>
							</h4>
						</div>
					</div>
				</li>
				<li style="border: 0">&nbsp;</li>
				<li>
					<div class="thumbnail">
						<a class="zoomTool"
							href="<c:url value="/assets/user/html/product_details.html"/>"
							title="add to cart"><span class="icon-search"></span> Xem chi tiết</a> <img
							src="<c:url value="/assets/user/img/anh-minh-hoa-2.jpg"/>"
							alt="san pham tieu bieu 2">
						<div class="caption">
							<h4>
								<a class="defaultBtn"
									href="<c:url value="/assets/user/html/product_details.html"/>">VIEW</a>
								<span class="pull-right">2.400.000 đ</span>
							</h4>
						</div>
					</div>
				</li>
				<li style="border: 0">&nbsp;</li>
				<li>
					<div class="thumbnail">
						<a class="zoomTool"
							href="<c:url value="/assets/user/html/product_details.html"/>"
							title="add to cart"><span class="icon-search"></span> Xem chi tiết</a> <img
							src="<c:url value="/assets/user/img/anh-minh-hoa-3.png"/>"
							alt="san pham tieu bieu 3">
						<div class="caption">
							<h4>
								<a class="defaultBtn"
									href="<c:url value="/assets/user/html/product_details.html"/>">VIEW</a>
								<span class="pull-right">129.000 đ</span>
							</h4>
						</div>
					</div>
				</li>
			</ul>

		</div>
		<div class="span9">
			<div class="well np">
				<div id="myCarousel" class="carousel slide homCar">
					<div class="carousel-inner">

						<c:forEach var="item" items="${ slides }" varStatus="index">

							<c:if test="${ index.first }">
								<div class="item active">
							</c:if>

							<c:if test="${ not index.first }">
								<div class="item">
							</c:if>

							<img style="width: 100%"
								src="<c:url value="/assets/user/img/${ item.img }"/>"
								alt="bootstrap ecommerce templates">
					</div>
					</c:forEach>


				</div>

				<a class="left carousel-control" href="#myCarousel"
					data-slide="prev">&lsaquo;</a> <a class="right carousel-control"
					href="#myCarousel" data-slide="next">&rsaquo;</a>
			</div>
		</div>
		<!--
New Products
-->
		<div class="well well-small">
			<h3>Sản phẩm mới</h3>
			<hr class="soften" />
			<div class="row-fluid">
				<div id="newProductCar" class="carousel slide">
					<div class="carousel-inner">
						<c:if test="${ new_products.size() > 0 }">
							<div class="item active">
								<ul class="thumbnails">
									<c:forEach var="item" items="${ new_products }" varStatus="loop">
										<li class="span3">
											<div class="thumbnail">
												<a class="zoomTool"
													href="<c:url value="/assets/user/html/product_details.html"/>"
													title="add to cart"><span class="icon-search"></span>
													Xem chi tiết</a> <a href="#" class="tag"></a> <a
													href="<c:url value="chi-tiet-san-pham/${ item.id_product }"/>"><img
													src="<c:url value='/assets/user/img/${ item.img }'/>" alt=""></a>
											</div>
										</li>
										<c:if test="${ (loop.index + 1) % 4 == 0 || (loop.index + 1) == new_products.size() }">
												</ul>
											</div>
											<c:if test="${ (loop.index + 1) < new_products.size() }">
												<div class="item">
													<ul class="thumbnails">
											</c:if>
										</c:if>
									</c:forEach>
						</c:if>

					</div>
					<a class="left carousel-control" href="#newProductCar"
						data-slide="prev">&lsaquo;</a> <a class="right carousel-control"
						href="#newProductCar" data-slide="next">&rsaquo;</a>
				</div>
			</div>
		</div>
		<!--
	Featured Products
	-->
		<div class="well well-small">
			<h3>
				<a class="btn btn-mini pull-right" href="products.html"
					title="View more">Xem thêm<span class="icon-plus"></span></a> Sản phẩm nối bật
			</h3>
			<hr class="soften" />
			<div class="row-fluid">

				<c:if test="${ highlight_products.size() > 0 }">
					<ul class="thumbnails">
						<c:forEach var="item" items="${ highlight_products }" varStatus="loop">
							<li class="span4">
								<div class="thumbnail">
									<a class="zoomTool" href="#" title="add to cart"> <span
										class="icon-search"></span> Xem chi tiết
									</a> <a href="chi-tiet-san-pham/${ item.id_product }"> <img
										src="<c:url value='/assets/user/img/${ item.img }'/>" alt="">
									</a>
									<div class="caption">
										<h5>${ item.name }</h5>
										<h4>
											<a class="defaultBtn"
												href="<c:url value='/assets/user/html/product_details.html'/>"
												title="Click to view"> <span class="icon-zoom-in"></span>
											</a> <a class="shopBtn" href="<c:url value="/AddCart/${ item.id_product }"/>" title="add to cart"> <span
												class="icon-plus"></span>
											</a> <span class="pull-right"><fmt:formatNumber
													type="number" groupingUsed="true" value="${ item.price }" />₫
											</span>
										</h4>
									</div>
								</div>
							</li>
							<!-- Đảm bảo rằng thẻ </ul> được đóng đúng sau mỗi nhóm 3 sản phẩm -->
							<c:if
								test="${ (loop.index + 1) % 3 == 0 || (loop.index + 1) == highlight_products.size() }">
					</ul>
					<c:if test="${ (loop.index + 1) < highlight_products.size() }">
						<ul class="thumbnails">
					</c:if>
				</c:if>
				</c:forEach>
				</ul>
				</c:if>




			</div>
		</div>
		<hr>
		<div class="well well-small">
			<a class="btn btn-mini pull-right" href="#">Xem thêm <span
				class="icon-plus"></span></a> Tất cả sản phẩm
		</div>


	</div>
	</div>




</body>
</html>

