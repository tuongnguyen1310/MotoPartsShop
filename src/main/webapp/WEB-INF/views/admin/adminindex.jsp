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
</style>
</head>
<body>
	<div class="container">
		<h1>Quản lý người dùng</h1>

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
					<th>Password</th>
					<th>Tên người dùng</th>
					<th>Địa chỉ</th>
					<th>Vai trò</th>
					<th>Chức năng</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${users}">
					<tr>
						<td>${item.id}</td>
						<td>${item.user}</td>
						<td>******</td>
						<td>${item.display_name}</td>
						<td>${item.address}</td>
						<td><c:choose>
								<c:when test="${item.role == 0}">Người dùng</c:when>
								<c:when test="${item.role == 1}">Admin</c:when>
							</c:choose></td>
						<td>
							<!-- Nút Edit -->
							<button
								onclick="openEditModal(${item.id}, '${item.user}', '${item.display_name}', '${item.address}', ${item.role})">Edit</button>
							<!-- Nút Delete -->
							<form action="/MotoPartsShop/admin/delete" method="POST"
								style="display: inline;">
								<input type="hidden" name="id" value="${item.id}">
								<button type="submit"
									style="background-color: red; color: white; border: none; padding: 5px 10px;">Delete</button>
							</form>

						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<!-- Modal Edit -->
		<div id="editModal"
			style="display: none; position: fixed; top: 0; left: 0; width: 100%; height: 100%; background: rgba(0, 0, 0, 0.5); z-index: 999;">
			<div class="modal-content"
				style="position: absolute; top: 50%; left: 50%; transform: translate(-50%, -50%); width: 400px; background: #f9f9f9; border-radius: 10px; box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2); padding: 20px; animation: fadeIn 0.3s ease;">
				<span onclick="closeModal()"
					style="cursor: pointer; font-size: 20px; font-weight: bold; float: right; color: #666;">&times;</span>
				<h2
					style="margin-bottom: 20px; text-align: center; font-size: 20px; font-weight: bold; color: #333;">Chỉnh
					sửa thông tin người dùng</h2>
				<form id="editUserForm" action="/MotoPartsShop/admin/edit" method="POST">
					<input type="hidden" id="editUserId" name="id">

					<div style="margin-bottom: 15px;">
						<label for="editUsername"
							style="font-weight: bold; display: block; margin-bottom: 5px; color: #333;">Username:</label>
						<input type="text" id="editUsername" name="username"
							style="width: 95%; padding: 10px; border: 1px solid #ccc; border-radius: 5px; font-size: 14px;"
							required>
					</div>

					<div style="margin-bottom: 15px;">
						<label for="editDisplayName"
							style="font-weight: bold; display: block; margin-bottom: 5px; color: #333;">Tên
							người dùng:</label> <input type="text" id="editDisplayName"
							name="display_name"
							style="width: 95%; padding: 10px; border: 1px solid #ccc; border-radius: 5px; font-size: 14px;"
							required>
					</div>

					<div style="margin-bottom: 15px;">
						<label for="editAddress"
							style="font-weight: bold; display: block; margin-bottom: 5px; color: #333;">Địa
							chỉ:</label> <input type="text" id="editAddress" name="address"
							style="width: 95%; padding: 10px; border: 1px solid #ccc; border-radius: 5px; font-size: 14px;"
							required>
					</div>

					<div style="margin-bottom: 15px;">
						<label for="editRole"
							style="font-weight: bold; display: block; margin-bottom: 5px; color: #333;">Vai
							trò:</label> <select id="editRole" name="role"
							style="width: 100%; padding: 10px; border: 1px solid #ccc; border-radius: 5px; font-size: 14px;">
							<option value="0">Người dùng</option>
							<option value="1">Admin</option>
						</select>
					</div>

					<div style="text-align: center;">
						<button type="submit"
							style="background-color: #007bff; color: white; border: none; padding: 10px 20px; border-radius: 5px; font-size: 14px; cursor: pointer;">Lưu</button>
					</div>
				</form>
			</div>
		</div>


		<!-- Nút Thêm người dùng -->
		<button onclick="openAddModal()"
			style="margin-bottom: 40px; background-color: #007bff; color: white; border: none; padding: 10px 20px; border-radius: 5px; cursor: pointer;">Thêm
			người dùng</button>

		<!-- Modal Thêm -->
			<div id="addModal"
			style="display: none; position: fixed; top: 0; left: 0; width: 100%; height: 100%; background: rgba(0, 0, 0, 0.5); z-index: 999;">
			<div class="modal-content"
				style="position: absolute; top: 50%; left: 50%; transform: translate(-50%, -50%); width: 400px; background: #f9f9f9; border-radius: 10px; box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2); padding: 20px;">
				<span onclick="closeAddModal()"
					style="cursor: pointer; font-size: 20px; font-weight: bold; float: right; color: #666;">&times;</span>
				<h2
					style="margin-bottom: 20px; text-align: center; font-size: 20px; font-weight: bold; color: #333;">Thêm
					người dùng</h2>
				<form id="addUserForm" action="/MotoPartsShop/admin/add" method="POST">
					<div style="margin-bottom: 15px;">
						<label for="addUsername"
							style="font-weight: bold; display: block; margin-bottom: 5px; color: #333;">Username:</label>
						<input type="text" id="addUsername" name="username"
							style="width: 95%; padding: 10px; border: 1px solid #ccc; border-radius: 5px; font-size: 14px;"
							required>
					</div>

					<div style="margin-bottom: 15px;">
						<label for="addPassword"
							style="font-weight: bold; display: block; margin-bottom: 5px; color: #333;">Mật
							khẩu:</label> <input type="password" id="addPassword" name="password"
							style="width: 95%; padding: 10px; border: 1px solid #ccc; border-radius: 5px; font-size: 14px;"
							required>
					</div>

					<div style="margin-bottom: 15px;">
						<label for="addDisplayName"
							style="font-weight: bold; display: block; margin-bottom: 5px; color: #333;">Tên
							người dùng:</label> <input type="text" id="addDisplayName"
							name="display_name"
							style="width: 95%; padding: 10px; border: 1px solid #ccc; border-radius: 5px; font-size: 14px;"
							required>
					</div>

					<div style="margin-bottom: 15px;">
						<label for="addAddress"
							style="font-weight: bold; display: block; margin-bottom: 5px; color: #333;">Địa
							chỉ:</label> <input type="text" id="addAddress" name="address"
							style="width: 95%; padding: 10px; border: 1px solid #ccc; border-radius: 5px; font-size: 14px;"
							required>
					</div>

					<div style="margin-bottom: 15px;">
						<label for="addRole"
							style="font-weight: bold; display: block; margin-bottom: 5px; color: #333;">Vai
							trò:</label> <select id="addRole" name="role"
							style="width: 100%; padding: 10px; border: 1px solid #ccc; border-radius: 5px; font-size: 14px;">
							<option value="0">Người dùng</option>
							<option value="1">Admin</option>
						</select>
					</div>

					<div style="text-align: center;">
						<button type="submit"
							style="background-color: #007bff; color: white; border: none; padding: 10px 20px; border-radius: 5px; font-size: 14px; cursor: pointer;">Thêm</button>
					</div>
				</form>
			</div>
		</div>

	</div>

	<!-- JavaScript -->
	<script>
        function openEditModal(id, username, displayName, address, role) {
            // Điền thông tin vào modal
            document.getElementById("editUserId").value = id;
            document.getElementById("editUsername").value = username;
            document.getElementById("editDisplayName").value = displayName;
            document.getElementById("editAddress").value = address;
            document.getElementById("editRole").value = role;

            // Hiển thị modal
            document.getElementById("editModal").style.display = "block";
        }

        function closeModal() {
            // Ẩn modal
            document.getElementById("editModal").style.display = "none";
        }
        function openAddModal() {
            document.getElementById("addModal").style.display = "block";
        }

        function closeAddModal() {
            document.getElementById("addModal").style.display = "none";
        }
    </script>


</body>
</html>
