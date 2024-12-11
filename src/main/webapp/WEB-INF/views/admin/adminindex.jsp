<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Management</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f8f9fa;
            color: #212529;
        }
        .container {
            width: 90%;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }
        h1 {
            text-align: center;
            margin-bottom: 20px;
        }
        .action-buttons {
            display: flex;
            justify-content: center;
            gap: 15px;
            margin-bottom: 20px;
        }
        .action-buttons button {
            background-color: #007bff;
            color: white;
            border: none;
            padding: 10px 15px;
            font-size: 16px;
            cursor: pointer;
            border-radius: 5px;
            transition: background-color 0.3s;
        }
        .action-buttons button:hover {
            background-color: #0056b3;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin: 20px 0;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #007bff;
            color: white;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        tr:hover {
            background-color: #e9ecef;
        }
        .form-container {
            margin-top: 30px;
            padding: 20px;
            background-color: #f8f9fa;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }
        .form-container h2 {
            margin-bottom: 15px;
            color: #007bff;
        }
        .form-container label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }
        .form-container input {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ced4da;
            border-radius: 5px;
        }
        .form-container button {
            display: block;
            width: 100%;
            background-color: #28a745;
            color: white;
            border: none;
            padding: 10px;
            font-size: 16px;
            cursor: pointer;
            border-radius: 5px;
            transition: background-color 0.3s;
        }
        .form-container button:hover {
            background-color: #218838;
        }
    </style>
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
