<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>


<head>
<meta charset="UTF-8">
<title>Đăng ký</title>
</head>
<body>
	<div class="row">
		<div id="sidebar" class="span3">
			<div class="well well-small">
				<ul class="nav nav-list">

					<c:forEach var="item" items="${ categories }">
						<li><a href="<c:url value="/san-pham/${ item.id }"/>"><span
								class="icon-chevron-right"></span> ${ item.name }</a></li>
						<li>
					</c:forEach>

					<li><a class="totalInCart" href="<c:url value="/gio-hang"/>"><strong>Đã
								mua <span class="badge badge-warning pull-right"
								style="line-height: 18px;"><fmt:formatNumber
										type="number" groupingUsed="true" value="${ totalPriceCart }" />₫</span>
						</strong></a></li>
				</ul>
			</div>

			<div class="well well-small alert alert-warning cntr">
				<h2>50% Discount</h2>
				<p>
					only valid for online order. <br> <br> <a
						class="defaultBtn" href="#">Click here </a>
				</p>
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
							title="add to cart"><span class="icon-search"></span> QUICK
							VIEW</a> <img
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
							title="add to cart"><span class="icon-search"></span> QUICK
							VIEW</a> <img
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
							title="add to cart"><span class="icon-search"></span> QUICK
							VIEW</a> <img
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
				<li class="active">Người dùng</li>
			</ul>
			<h3>Người dùng</h3>
			<hr class="soft" />

			<div class="row">
				<div class="span4">
					<div class="well">
						<h5>ĐĂNG KÝ TÀI KHOẢN</h5>

						<br />
						<c:if test="${not empty status}">
							<div class="alert alert-info">${status}</div>
						</c:if>
						

						<!-- Form đăng ký người dùng -->
						<form:form action="dang-ky" method="POST" modelAttribute="user">
							<div class="control-group">
								<label class="control-label" for="inputEmail">E-mail:</label>
								<div class="controls">
									<form:input type="email" class="span3"
										placeholder="Mời nhập email" path="user" />
								</div>
							</div>

							<div class="control-group">
								<label class="control-label" for="inputPassword">Mật
									khẩu:</label>
								<div class="controls">
									<form:input type="password" class="span3"
										placeholder="Mời nhập mật khẩu" path="password" />
								</div>
							</div>

							<div class="control-group">
								<label class="control-label" for="inputFullName">Họ và
									tên:</label>
								<div class="controls">
									<form:input type="text" class="span3"
										placeholder="Mời nhập họ và tên" path="display_name" />
								</div>
							</div>

							<div class="control-group">
								<label class="control-label" for="inputAddress">Địa chỉ:</label>
								<div class="controls">
									<form:input type="text" class="span3"
										placeholder="Mời nhập địa chỉ" path="address" />
								</div>
							</div>

							<div class="controls">
								<button type="submit" class="defaultBtn">Tạo tài khoản</button>
							</div>
						</form:form>
					</div>
				</div>
				<div class="span1">&nbsp;</div>
				<div class="span4">
					<div class="well">
						<h5>BẠN ĐÃ CÓ TÀI KHOẢN ?</h5>
						<c:if test="${not empty statusLogin}">
							<div class="alert alert-info">${statusLogin}</div>
						</c:if>
						<form:form action="dang-nhap" method="POST" modelAttribute="user">
							<br />
							<div class="control-group">
								<label class="control-label" for="inputEmail">E-mail:</label>
								<div class="controls">
									<form:input type="email" class="span3"
										placeholder="Mời nhập email" path="user" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputPassword">Mật
									khẩu</label>
								<div class="controls">
									<form:input type="password" class="span3"
										placeholder="Mời nhập mật khẩu" path="password" />
								</div>
							</div>
							<div class="control-group">
								<div class="controls">
									<button type="submit" class="defaultBtn">Đăng nhập</button>
									<a href="#">Quên mật khẩu?</a>
								</div>
							</div>
						</form:form>
					</div>
				</div>
			</div>

		</div>
	</div>
</body>