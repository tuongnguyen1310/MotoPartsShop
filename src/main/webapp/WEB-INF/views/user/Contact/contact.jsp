<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Liên Hệ</title>
<style>
body {
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
	background-color: #f4f4f4;
}

.header {
	background-color: #007bff;
	color: white;
	padding: 15px 20px;
	text-align: center;
}

.container {
	max-width: 1200px;
	margin: 20px auto;
	padding: 20px;
	background: white;
	border-radius: 5px;
	box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2);
}

h1 {
	text-align: center;
	margin-bottom: 20px;
	color: #333;
}

.form-group {
	margin-bottom: 15px;
}

.form-group label {
	display: block;
	font-weight: bold;
	margin-bottom: 5px;
}

.form-group input, .form-group textarea, .form-group select {
	width: 100%;
	padding: 10px;
	border: 1px solid #ccc;
	border-radius: 5px;
}

.form-group textarea {
	resize: none;
	height: 100px;
}

.form-group button {
	display: block;
	width: 100%;
	background-color: #007bff;
	color: white;
	font-size: 16px;
	padding: 10px;
	border: none;
	border-radius: 5px;
	cursor: pointer;
}

.form-group button:hover {
	background-color: #0056b3;
}

.contact-info {
	margin-top: 30px;
}

.contact-info h2 {
	margin-bottom: 10px;
}

.contact-info p {
	line-height: 1.8;
}

.map {
	text-align: center;
	margin-top: 30px;
}

iframe {
	width: 100%;
	height: 400px;
	border: none;
}
</style>
</head>
<body>

	<div class="header">
		<h1>Liên Hệ Với Chúng Tôi</h1>
	</div>

	<div class="container">



		<div class="contact-info">
			<h2>Thông Tin Liên Hệ</h2>
			<p>
				<strong>Địa chỉ:</strong> 22a đường số 147, phường Phước Long B, Tp.Thủ đức
			</p>
			<p>
				<strong>Số điện thoại:</strong> <a href="tel:0345517135">0345
					517 135</a>
			</p>
			<p>
				<strong>Email:</strong> <a
					href="mailto:tuongnguyen131020030000@gmail.com">tuongnguyen13102003@gmail.com</a>
			</p>
			<p>
				<strong>Thời gian làm việc:</strong> Thứ 2 - Thứ 7 (8:00 - 18:00),
				Chủ Nhật (8:00 - 17:30)
			</p>
		</div>

		<div class="map">
			<h2>Bản Đồ</h2>
			<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3918.727568491671!2d106.7740108!3d10.8321483!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x317527011c9cbf75%3A0x1a87a367e66a8c0e!2zMjIgxJAuU-G7kSAxNDcsIFBoxrDhu5tjIExvbmcgQiwgUXXhuq1uIDksIEjhu5MgQ2jDrSBNaW5o!5e0!3m2!1sen!2s!4v1734858076588!5m2!1sen!2s" width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>

		</div>

		<a href="<c:url value='/home'/>">
			<button
				style="margin-top: 20px; background-color: #28a745; color: white; padding: 10px 20px; border: none; border-radius: 5px; cursor: pointer;">Quay
				lại</button>
		</a>
	</div>

</body>
</html>
