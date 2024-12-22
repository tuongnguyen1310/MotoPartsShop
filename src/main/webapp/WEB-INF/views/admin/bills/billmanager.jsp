<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Quản lý người dùng</title>
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

#billDetailsModal {
	display: none; /* Mặc định ẩn */
	position: fixed;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	background: rgba(0, 0, 0, 0.5);
	z-index: 999;
}

.modal-content {
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	width: 600px;
	background: #f9f9f9;
	border-radius: 10px;
	box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
	padding: 20px;
}
</style>
</head>
<body>
	<div class="container">
		<h1>Quản lý hóa đơn</h1>
		<hr></hr>
		<!-- Hiển thị thông báo -->
		<c:if test="${not empty successMessage}">
			<div class="alert alert-success">${successMessage}</div>
		</c:if>
		<c:if test="${not empty errorMessage}">
			<div class="alert alert-danger">${errorMessage}</div>
		</c:if>

		<!-- Bảng hiển thị thông tin người dùng -->
		<table>
			<thead>
				<tr>
					<th>ID</th>
					<th>Username</th>
					<th>Số điện thoại</th>
					<th>Tên người dùng</th>
					<th>Địa chỉ</th>
					<th>Tổng tiền</th>
					<th>Số lượng</th>
					<th>Trạng thái</th>
					<th>Chức năng</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${bills}">
					<tr>
						<td>${item.id}</td>
						<td>${item.user}</td>
						<td>${item.phone}</td>
						<td>${item.display_name}</td>
						<td>${item.address}</td>
						<td><fmt:formatNumber type="number" groupingUsed="true"
								value="${item.total}" /> ₫</td>
						<td>${item.quanty}</td>
						<td>${item.note}</td>
						<td>
							<!-- Nút Edit -->
							<button
								onclick="openEditBillModal('${item.id}', '${item.user}', '${item.phone}', '${item.display_name}', '${item.address}', ${item.total}, ${item.quanty}, '${item.note}')"
								style="background-color: #007bff; color: white; border: none; padding: 5px 10px; border-radius: 5px; cursor: pointer;">
								Sửa</button> <!-- Nút Delete -->
							<form action="don-hang/deleteBill" method="POST"
								style="display: inline;">
								<input type="hidden" name="id" value="${item.id}">
								<button type="submit"
									style="background-color: #dc3545; color: white; border: none; padding: 5px 10px; border-radius: 5px; cursor: pointer;">Xóa</button>
							</form>



						</td>
						<td><a
							href="<c:url value='/admin/don-hang/chi-tiet/${item.id}'/>">
								<button
									style="background-color: #28a745; color: white; border: none; padding: 5px 10px; border-radius: 5px; cursor: pointer;">
									Xem thêm</button>
						</a></td>

					</tr>
				</c:forEach>
			</tbody>
		</table>

		<!-- Modal Edit -->
		<div id="editBillModal"
			style="display: none; position: fixed; top: 0; left: 0; width: 100%; height: 100%; background: rgba(0, 0, 0, 0.5); z-index: 999;">
			<div class="modal-content"
				style="position: absolute; top: 50%; left: 50%; transform: translate(-50%, -50%); width: 400px; background: #f9f9f9; border-radius: 10px; box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2); padding: 20px; animation: fadeIn 0.3s ease;">
				<span onclick="closeBillModal()"
					style="cursor: pointer; font-size: 20px; font-weight: bold; float: right; color: #666;">&times;</span>
				<h2
					style="margin-bottom: 20px; text-align: center; font-size: 20px; font-weight: bold; color: #333;">
					Chỉnh sửa thông tin hóa đơn</h2>
				<form id="editBillForm" action="don-hang/editBill" method="POST">
					<!-- Trường ID (ẩn) -->
					<input type="hidden" id="editId" name="id">

					<!-- Trường User -->
					<div style="margin-bottom: 15px;">
						<label for="editUser"
							style="font-weight: bold; display: block; margin-bottom: 5px; color: #333;">User:</label>
						<input type="text" id="editUser" name="user"
							style="width: 95%; padding: 10px; border: 1px solid #ccc; border-radius: 5px; font-size: 14px;"
							required>
					</div>

					<!-- Trường Phone -->
					<div style="margin-bottom: 15px;">
						<label for="editPhone"
							style="font-weight: bold; display: block; margin-bottom: 5px; color: #333;">Phone:</label>
						<input type="text" id="editPhone" name="phone"
							style="width: 95%; padding: 10px; border: 1px solid #ccc; border-radius: 5px; font-size: 14px;"
							required>
					</div>

					<!-- Trường Display Name -->
					<div style="margin-bottom: 15px;">
						<label for="editDisplayName"
							style="font-weight: bold; display: block; margin-bottom: 5px; color: #333;">Display
							Name:</label> <input type="text" id="editDisplayName" name="display_name"
							style="width: 95%; padding: 10px; border: 1px solid #ccc; border-radius: 5px; font-size: 14px;"
							required>
					</div>

					<!-- Trường Address -->
					<div style="margin-bottom: 15px;">
						<label for="editAddress"
							style="font-weight: bold; display: block; margin-bottom: 5px; color: #333;">Address:</label>
						<input type="text" id="editAddress" name="address"
							style="width: 95%; padding: 10px; border: 1px solid #ccc; border-radius: 5px; font-size: 14px;"
							required>
					</div>

					<!-- Trường Total -->
					<div style="margin-bottom: 15px;">
						<label for="editTotal"
							style="font-weight: bold; display: block; margin-bottom: 5px; color: #333;">Total:</label>
						<input type="number" id="editTotal" name="total"
							style="width: 95%; padding: 10px; border: 1px solid #ccc; border-radius: 5px; font-size: 14px;"
							required>
					</div>

					<!-- Trường Quantity -->
					<div style="margin-bottom: 15px;">
						<label for="editQuantity"
							style="font-weight: bold; display: block; margin-bottom: 5px; color: #333;">Quantity:</label>
						<input type="number" id="editQuantity" name="quanty"
							style="width: 95%; padding: 10px; border: 1px solid #ccc; border-radius: 5px; font-size: 14px;"
							required>
					</div>

					<div style="margin-bottom: 15px;">
						<label for="editQuantity"
							style="font-weight: bold; display: block; margin-bottom: 5px; color: #333;">Trạng
							thái:</label> <select id="editNote" name="note"
							style="width: 100%; padding: 10px; border: 1px solid #ccc; border-radius: 5px; font-size: 14px;">
							<option value="Pending Payment">Pending Payment</option>
							<option value="Success">Success</option>
						</select>
					</div>
					<!-- Nút Lưu -->
					<div style="text-align: center;">
						<button type="submit"
							style="background-color: #007bff; color: white; border: none; padding: 10px 20px; border-radius: 5px; font-size: 14px; cursor: pointer;">
							Lưu</button>
					</div>
				</form>
			</div>
		</div>









	</div>

	<!-- JavaScript -->
	<script>
	function openEditBillModal(id, user, phone, displayName, address, total, quanty, note) {
	    // Điền thông tin vào các trường trong modal
	    document.getElementById("editId").value = id;
	    document.getElementById("editUser").value = user;
	    document.getElementById("editPhone").value = phone;
	    document.getElementById("editDisplayName").value = displayName;
	    document.getElementById("editAddress").value = address;
	    document.getElementById("editTotal").value = total;
	    document.getElementById("editQuantity").value = quanty;
	    document.getElementById("editNote").value = note;

	    // Hiển thị modal
	    document.getElementById("editBillModal").style.display = "block"; // Đúng modal ID
	}

	function closeBillModal() {
	    // Ẩn modal
	    document.getElementById("editBillModal").style.display = "none"; // Đúng modal ID
	}
	
	


        
    </script>


</body>
</html>
