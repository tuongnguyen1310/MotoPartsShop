<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
<fmt:setLocale value="vi_VN" />
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Chi tiết danh mục ${ idCategory }</title>
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
private int id_product;
	private int id_category;
    private String name;
    private double price;
    private int sale;
    private String title;
    private boolean highlight;
    private boolean new_product;
    private String detail;
	private int id_color;
    private String name_color;
    private String code_color;
    private String img;
    private Date created_at;
    private Date updated_at;
	<div class="container">
		<h1>Chi tiết danh mục</h1>
		<h3>ID hóa đơn: ${idCategory} | Tổng: ${allProductsByIDCategory.size()} sản phẩm.</h3>

		<table id="billDetailsTable"
			style="width: 100%; border-collapse: collapse; text-align: left;">
			<thead>
				<tr>
					<th>ID</th>
					<th>Sản phẩm</th>
					<th>Tên Sản phẩm</th>
					<th>Đơn giá</th>
					<th>Highlight</th>
					<th>New</th>
					<th>Màu</th>
					<th>Chức năng</th>
					
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${allProductsByIDCategory}">
					<tr>
						<td>${item.id_product}</td>
						<td><img
					src="<c:url value="/assets/user/img/${item.img}"/>"
					alt="payment method paypal"></td>
						<td>${item.name}</td>
						<td><fmt:formatNumber type="number" groupingUsed="true"
								value="${item.price}" /> ₫</td>
						<td>${item.highlight}</td>
						<td>${item.new_product}</td>
						<td><span class="shopBtn"
								style="background-color: ${ item.code_color };"><span
									class="icon-ok"></span></span></td>
									
						<td><!-- Nút Edit -->
							<button
							
								onclick="openEditBillModal('${item.img}', '${item.id_product}', '${item.name}', '${item.price}', '${item.sale}', '${item.title}', '${item.highlight}', '${item.new_product}', ${item.detail}, ${item.name_color}, '${item.code_color}', '${item.created_at}')"
								style="background-color: #007bff; color: white; border: none; padding: 5px 10px; border-radius: 5px; cursor: pointer;">
								Sửa</button> <!-- Nút Delete -->
							<form action="don-hang/deleteBill" method="POST"
								style="display: inline;">
								<input type="hidden" name="id" value="${item.id_product}">
								<button type="submit"
									style="background-color: #dc3545; color: white; border: none; padding: 5px 10px; border-radius: 5px; cursor: pointer;">Xóa</button>
							</form></td>
						
					</tr>
				</c:forEach>
				<!-- Dòng hiển thị tổng -->
				
			</tbody>
		</table>


		<!-- Nút quay lại -->
		<a href="<c:url value='/admin/danh-muc'/>">
			<button
				style="margin-top: 20px; background-color: #28a745; color: white; padding: 10px 20px; border: none; border-radius: 5px; cursor: pointer;">Quay
				lại</button>
		</a>
	</div>
</body>
</html>
