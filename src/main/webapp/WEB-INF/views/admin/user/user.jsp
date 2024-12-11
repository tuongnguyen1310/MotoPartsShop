<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản lý người dùng</title>

    
</head>
<body>
	<div class="container">
        <h1>User Management</h1>

        <!-- Action buttons -->
        <div class="action-buttons">
            <button onclick="addUser()">Add User</button>
            <button onclick="editUser()">Edit User</button>
            <button onclick="deleteUser()">Delete User</button>
        </div>

        <!-- Table displaying user information -->
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Username</th>
                    <th>Password</th>
                    <th>Display Name</th>
                    <th>Address</th>
                    <th>Role</th>
                </tr>
            </thead>
            <tbody>
                <!-- Example data -->
                <tr>
                    <td>1</td>
                    <td>tuong1@gmail.com</td>
                    <td>$2a$12$...</td>
                    <td>tuong</td>
                    <td>hcm</td>
                    <td>0</td>
                </tr>
                <tr>
                    <td>2</td>
                    <td>tuong123@gmail.com</td>
                    <td>$2a$12$...</td>
                    <td>Nguyen Tan Tuong</td>
                    <td>hcm</td>
                    <td>0</td>
                </tr>
                <tr>
                    <td>5</td>
                    <td>admin@gmail.com</td>
                    <td>$2a$12$...</td>
                    <td>admin</td>
                    <td>admin</td>
                    <td>1</td>
                </tr>
            </tbody>
        </table>

        <!-- Form for adding or editing user information -->
        <div class="form-container">
            <h2>Add/Edit User</h2>
            <form action="/save-user" method="POST">
                <label for="id">ID</label>
                <input type="text" id="id" name="id" placeholder="Enter ID">

                <label for="username">Username</label>
                <input type="email" id="username" name="username" placeholder="Enter username">

                <label for="password">Password</label>
                <input type="password" id="password" name="password" placeholder="Enter password">

                <label for="display_name">Display Name</label>
                <input type="text" id="display_name" name="display_name" placeholder="Enter display name">

                <label for="address">Address</label>
                <input type="text" id="address" name="address" placeholder="Enter address">

                <label for="role">Role</label>
                <input type="number" id="role" name="role" placeholder="Enter role (0 for user, 1 for admin)" min="0" max="1">

                <button type="submit">Save User</button>
            </form>
        </div>
    </div>

    <script>
        function addUser() {
            alert('Add User functionality to be implemented.');
        }

        function editUser() {
            alert('Edit User functionality to be implemented.');
        }

        function deleteUser() {
            alert('Delete User functionality to be implemented.');
        }
    </script>
</body>
</html>