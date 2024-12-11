<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sản phẩm</title>

<style>
.pagination {
	display: flex;
	justify-content: center;
}

.pagination a {
	color: black;
	float: left;
	padding: 8px 16px;
	text-decoration: none;
	transition: background-color .3s;
	border: 1px solid #ddd;
}

.pagination a.active {
	background-color: #4CAF50;
	color: white;
	border: 1px solid #4CAF50;
}

.pagination a:hover:not(.active) {
	background-color: #ddd;
}
</style>
</head>
<body>
	<h1>Quản lý sản phẩm</h1>
	<div class="well well-small">
		<div class="row">
			<span style="margin-left: 25px;">Danh sách sản phẩm</span> <select
				class="pull-right">
				<option>A - Z</option>
				<option>Cao - Thấp</option>
			</select>
		</div>




		<c:if test="${ productsPaginate.size() > 0 }">
			<div class="row-fluid">
				<ul class="thumbnails">
					<!-- Lặp qua các sản phẩm -->
					<c:forEach var="item" items="${ productsPaginate }"
						varStatus="loop">
						<li class="span4">
							<div class="thumbnail">
								<a
									href="<c:url value='/chi-tiet-san-pham/${ item.id_product }'/>"
									class="overlay"></a> <a class="zoomTool"
									href="product_details.html" title="add to cart"> <span
									class="icon-search"></span> Xem thêm
								</a> <a
									href="<c:url value='/chi-tiet-san-pham/${ item.id_product }'/>">
									<img src="<c:url value='/assets/user/img/${ item.img }'/>"
									alt="${ item.name }" />
								</a>
								<div class="caption cntr">
									<p>${ item.name }</p>
									<p>
										<strong><fmt:formatNumber type="number"
												groupingUsed="true" value="${ item.price }" /> ₫</strong>
									</p>
									
									
									<br class="clr">
								</div>
							</div>
						</li>

						<!-- Mở thẻ <ul> mới sau mỗi 3 sản phẩm (Không mở lại ul sau mỗi sản phẩm) -->
						<c:if
							test="${ (loop.index + 1) % 3 == 0 && (loop.index + 1) < productsPaginate.size() }">
			</div>
		</c:if>
		<c:if test="${ (loop.index + 1) < productsPaginate.size() }">
			<div class="row-fluid">
				<ul class="thumbnails">
		</c:if>
		</c:forEach>
		</ul>
	</div>
	</c:if>






	<div class="pagination">
		<c:forEach var="item" begin="1" end="${ paginateInfo.totalPage }"
			varStatus="loop">
			<c:if test="${ (loop.index) == paginateInfo.currentPage}">
				<a href="<c:url value='/admin/all-san-pham/${ loop.index }'/>"
					class="active">${ loop.index }</a>
			</c:if>
			<c:if test="${ (loop.index) != paginateInfo.currentPage}">
				<a href="<c:url value='/admin/all-san-pham/${ loop.index }'/>">${ loop.index }</a>
			</c:if>
		</c:forEach>
	</div>
</body>
</html>
