
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<header id="header">
	<div class="row">
		<div class="span4">
			<h1>
				<a class="logo" href="<c:url value="/home"/>"><span>MotoPartShop</span> <img
					src="<c:url value="/assets/user/img/logo-shop-moto-parts.png"/>"
					alt="Shop Phu Tung"> </a>
			</h1>
		</div>
		<div class="span4">
			<div class="offerNoteWrapper">
				<h1 class="dotmark">
					<i class="icon-cut"></i> Phụ tùng & Đồ chơi xe máy cao cấp. Làm từ:
					8h - 18h (T2-CN)
				</h1>
			</div>
		</div>
		<div class="span4 alignR">
			<p>
				<br> <strong> Tổng đài hỗ trợ (24/7) : 0345 517 135 </strong><br>
				<br>
			</p>

		</div>
	</div>
</header>

<!--
Navigation Bar Section 
-->


<div class="navbar">
	<div class="navbar-inner">
		<div class="container">
			<a data-target=".nav-collapse" data-toggle="collapse"
				class="btn btn-navbar"> <span class="icon-bar"></span> <span
				class="icon-bar"></span> <span class="icon-bar"></span>
			</a>
			<div class="nav-collapse">
				<ul class="nav">

					<li class="active"><a href="<c:url value="/admin/usermanager"/>">Người dùng</a></li>
					<li class=""><a href="<c:url value="/admin/all-san-pham/1"/>">Sản phẩm</a></li>
					<li class=""><a href="<c:url value="/admin/gio-hang"/>">Đơn hàng</a></li>
					<li class=""><a href="<c:url value="/admin/category"/>">Danh mục</a></li>
					<li class=""><a href="<c:url value="/admin/liet-ke"/>">Thống kê</a></li>



				</ul>
				<form action="#" class="navbar-search pull-right">
					<input type="text" placeholder="Search" class="search-query span2">
				</form>
				
				</ul>
			</div>
		</div>
	</div>
</div>