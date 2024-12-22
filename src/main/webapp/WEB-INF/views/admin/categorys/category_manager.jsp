<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
<fmt:setLocale value="vi_VN" />
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Quản lý danh mục</title>
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
		<h1>Quản lý danh mục</h1>
		<hr></hr>

		<!-- Bảng hiển thị thông tin người dùng -->
		<table>
			<thead>
				<tr>
					<th>ID</th>
					<th>Tên danh mục</th>
					<th>Mô tả</th>
					<th>Chức năng</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${categories}">
					<tr>
						<td>${item.id}</td>
						<td>${item.name}</td>
						<td>${item.description}</td>
						<td>
							<!-- Nút Edit -->
							<button
								onclick="openEditCategoryModal('${item.id}', '${item.name}', '${item.description}')"
								style="background-color: #007bff; color: white; border: none; padding: 5px 10px; border-radius: 5px; cursor: pointer;">
								Sửa</button> <!-- Nút Delete -->
							<form action="danh-muc/delete" method="POST"
								style="display: inline;">
								<input type="hidden" name="id" value="${item.id}">
								<button type="submit"
									style="background-color: #dc3545; color: white; border: none; padding: 5px 10px; border-radius: 5px; cursor: pointer;">Xóa</button>
							</form>



						</td>
						<td><a
							href="<c:url value='/admin/danh-muc/${item.id}'/>">
								<button
									style="background-color: #28a745; color: white; border: none; padding: 5px 10px; border-radius: 5px; cursor: pointer;">
									Xem thêm</button>
						</a></td>

					</tr>
				</c:forEach>
			</tbody>
		</table>

		<!-- Modal Edit -->
		<div id="editCategoryModal" style="display: none;">
			<div class="modal-content">
				<span onclick="closeEditCategoryModal()" style="cursor: pointer;">&times;</span>
				<h3>Chỉnh sửa</h3>
				<form id="editCategoryForm" action="/MotoPartsShop/admin/danh-muc/edit"
					method="POST">
					<input type="hidden" id="editCategoryId" name="id">

					<div>
						<label for="editCategoryName">Tên danh mục:</label> <input
							type="text" id="editCategoryName" name="name" required>
					</div>

					<div>
						<label for="editCategoryDescription">Mô tả:</label>
						<textarea id="editCategoryDescription" name="description" ></textarea>
					</div>

					<div style="text-align: center;">
						<button type="submit"
							style="background-color: #007bff; color: white;">Lưu</button>
					</div>
				</form>
			</div>
		</div>

		<!-- Modal Confirm Delete -->
		<div id="deleteCategoryModal" style="display: none;">
			<div class="modal-content">
				<span onclick="closeDeleteCategoryModal()" style="cursor: pointer;">&times;</span>
				<h2>Xóa danh mục</h2>
				<p>Bạn có chắc chắn muốn xóa danh mục này không?</p>
				<form id="deleteCategoryForm" action="/MotoPartsShop/admin/danh-muc/delete"
					method="POST">
					<input type="hidden" id="deleteCategoryId" name="id">
					<div style="text-align: center;">
						<button type="submit"
							style="background-color: #dc3545; color: white;">Xóa</button>
						<button type="button" onclick="closeDeleteCategoryModal()"
							style="background-color: #6c757d; color: white;">Hủy</button>
					</div>
				</form>
			</div>
		</div>





		<script>
			// Open Edit Modal
			function openEditCategoryModal(id, name, description) {
				document.getElementById('editCategoryId').value = id;
				document.getElementById('editCategoryName').value = name;
				document.getElementById('editCategoryDescription').value = description;

				document.getElementById('editCategoryModal').style.display = 'block';
			}

			// Close Edit Modal
			function closeEditCategoryModal() {
				document.getElementById('editCategoryModal').style.display = 'none';
			}

			// Open Delete Modal
			function openDeleteCategoryModal(id) {
				document.getElementById('deleteCategoryId').value = id;
				document.getElementById('deleteCategoryModal').style.display = 'block';
			}

			// Close Delete Modal
			function closeDeleteCategoryModal() {
				document.getElementById('deleteCategoryModal').style.display = 'none';
			}
		</script>





	</div>
</body>
</html>
