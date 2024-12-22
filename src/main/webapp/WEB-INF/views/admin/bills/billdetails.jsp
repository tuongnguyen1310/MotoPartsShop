<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
<fmt:setLocale value="vi_VN" />
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Chi tiết hóa đơn</title>
<style>
/* CSS cho bảng */
table {
	width: 100%;
	border-collapse: collapse;
	margin-top: 20px;
}

table, th, td {
	border: 1px solid black;
}

th, td {
	padding: 10px;
	text-align: left;
}

th {
	background-color: #f2f2f2;
}

/* CSS cho modal */
.modal-content {
	position: fixed;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	background: white;
	padding: 20px;
	border-radius: 8px;
	box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
	z-index: 1000;
}

#editModal {
	display: none;
	position: fixed;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	background: rgba(0, 0, 0, 0.5);
	z-index: 999;
}

.alert {
	padding: 15px;
	margin-top: 10px;
	border-radius: 5px;
}

.alert-success {
	background-color: #d4edda;
	color: #155724;
}

.alert-danger {
	background-color: #f8d7da;
	color: #721c24;
}
</style>
</head>
<body>

	<div class="container">
		<h1>Chi tiết hóa đơn</h1>
		<h3>ID hóa đơn: ${billId}</h3>

		<table id="billDetailsTable"
			style="width: 100%; border-collapse: collapse; text-align: left;">
			<thead>
				<tr>
					<th>ID</th>
					<th>Sản phẩm</th>
					<th>Số lượng</th>
					<th>Tổng tiền</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="detail" items="${billDetails}">
					<tr>
						<td>${detail.bill_detail_id}</td>
						<td>${detail.product_name}</td>
						<td>${detail.quanty}</td>
						<td><fmt:formatNumber type="number" groupingUsed="true" value="${detail.total}" /> ₫</td>
					</tr>
				</c:forEach>
				<!-- Dòng hiển thị tổng -->
				<tr style="font-weight: bold; background-color: #f2f2f2;">
					<td colspan="2" style="text-align: right;">Tổng:</td>
					<td>${totalQuantity}</td>
					<td><fmt:formatNumber type="number" groupingUsed="true" value="${totalAmount}" /> ₫</td>
				</tr>
			</tbody>
		</table>


		<!-- Nút quay lại -->
		<a href="<c:url value='/admin/don-hang'/>">
			<button
				style="margin-top: 20px; background-color: #28a745; color: white; padding: 10px 20px; border: none; border-radius: 5px; cursor: pointer;">Quay
				lại</button>
		</a>
	</div>
</body>
</html>
