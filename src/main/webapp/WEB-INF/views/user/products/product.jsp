<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
<head>
<meta charset="UTF-8">
<title>Chi tiết sản phẩm</title>
<style type="text/css">
.product-content {
	overflow-x: hidden;
}
</style>
</head>
<body>
	<!-- 
Body Section 
-->
	
	<div class="row product-content">
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
							title="add to cart"><span class="icon-search"></span> Xem chi
							tiết</a> <img
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
							title="add to cart"><span class="icon-search"></span> Xem chi
							tiết</a> <img
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
							title="add to cart"><span class="icon-search"></span> Xem chi
							tiết</a> <img
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
			<ul class="breadcrumb">
				<li><a href="index.html">Trang chủ</a> <span class="divider">/</span></li>
				<li><a href="products.html">Sản phẩm</a> <span class="divider">/</span></li>
				<li class="active">Chi tiết sản phẩm</li>
			</ul>
			<div class="well well-small">
				<div class="row-fluid">
					<div class="span5">
						<div id="myCarousel" class="carousel slide cntr">
							<div class="carousel-inner">
								<div class="item active">
									<a href="#"> <img
										src="<c:url value="/assets/user/img/${ product.img }"/>"
										alt="" style="width: 100%"></a>
								</div>

							</div>
							<a class="left carousel-control" href="#myCarousel"
								data-slide="prev">‹</a> <a class="right carousel-control"
								href="#myCarousel" data-slide="next">›</a>
						</div>
					</div>
					<div class="span7">
						<h3>${ product.name }</h3>
						<hr class="soft" />

						<form class="form-horizontal qtyFrm" method="get"
							action="<c:url value="/AddCart/${ product.id_product }"/>">
							<div class="control-group">
								<label class="control-label"><span><fmt:formatNumber
											type="number" groupingUsed="true" value="${ product.price }" />₫</span></label>
								<div class="controls">
									<input type="number" min="0" value="0" class="span6">
								</div>
							</div>

							<div class="control-group">
								<label class="control-label"><span>Color</span></label>
								<div class="controls">
									<select class="span11">
										<option>Red</option>
										<option>Purple</option>
										<option>Pink</option>
										<option>Red</option>
									</select>
								</div>
							</div>

							<h4></h4>
							<p>${ product.title }
							<p>
								<button type="submit" class="shopBtn">
									<span class=" icon-shopping-cart"></span> Thêm vào giỏ hàng
								</button>
						</form>
					</div>
				</div>
				<hr class="softn clr" />


				<ul id="productDetail" class="nav nav-tabs">
					<li class="active"><a href="#home" data-toggle="tab">Chi
							tiết sản phẩm</a></li>
					<li class=""><a href="#profile" data-toggle="tab">Sản phẩm
							liên quan </a></li>

				</ul>
				<div id="myTabContent" class="tab-content tabWrapper">
					<div class="tab-pane fade active in" id="home">
						<h4>${ product.name }</h4>

						<table class="table table-striped">
							<tbody>
								<tr class="techSpecRow">
									<td class="techSpecTD1">Màu sắc:</td>
									<td class="techSpecTD2">${ product.name_color }</td>
								</tr>
								<tr class="techSpecRow">
									<td class="techSpecTD1">Loại:</td>
									<td class="techSpecTD2">Motorbike spare parts,Sports</td>
								</tr>
							</tbody>
						</table>

						<p>${ product.detail }</p>

					</div>
					<div class="tab-pane fade" id="profile">
						<c:set var="countList" value="${ productByIDCategory.size() }"></c:set>
						<c:if test="${ productByIDCategory.size() > 5 }">
							<c:set var="countList" value="5"></c:set>
						</c:if>

						<c:forEach var="item" items="${ productByIDCategory }" begin="1"
							end="${ countList }" varStatus="loop">

							<div class="row-fluid">
								<div class="span2">
									<img src="<c:url value="/assets/user/img/${ item.img }"/>"
										alt="">
								</div>
								<div class="span6">
									<h5>${ item.name }</h5>
									<p>${ item.title }</p>
								</div>
								<div class="span4 alignR">
									<form class="form-horizontal qtyFrm">
										<h3>
											<fmt:formatNumber type="number" groupingUsed="true"
												value="${ item.price }" />
											₫
										</h3>
										<div class="btn-group">
											<a href="<c:url value="/AddCart/${ item.id_product }"/>" class="defaultBtn"><span
												class=" icon-shopping-cart"></span> Thêm vào giỏ</a> <a
												href="<c:url value='/chi-tiet-san-pham/${ item.id_product }'/>" class="shopBtn">Xem thêm</a>
										</div>
									</form>
								</div>
							</div>
							<hr class="soft">

						</c:forEach>




					</div>


				</div>

			</div>
		</div>
	</div>
	<!-- Body wrapper -->
</body>