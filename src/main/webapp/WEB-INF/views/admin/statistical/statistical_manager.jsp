<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layouts/user/taglib.jsp"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thống kê hóa đơn</title>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <style>
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
            text-align: center;
        }
        th {
            background-color: #007bff;
            color: white;
        }
        h1, h3 {
            text-align: center;
        }
        canvas {
            margin: 20px auto;
            display: block;
            max-width: 80%;
        }
    </style>
</head>
<body>
    <h1>Thống kê hóa đơn</h1>
    <hr/>

    <!-- Bảng dữ liệu -->
    <table>
        <thead>
            <tr>
                <th>Tháng</th>
                <th>Năm</th>
                <th>Số lượng hóa đơn</th>
                <th>Tổng thu nhập</th>
            </tr>
        </thead>
        <tbody>
            <c:if test="${not empty statistics}">
                <c:forEach var="item" items="${statistics}">
                    <tr>
                        <td>${item.month}</td>
                        <td>${item.year}</td>
                        <td>${item.billCount}</td>
                        <td><fmt:formatNumber value="${item.totalIncome}" type="number" groupingUsed="true"/> ₫</td>
                    </tr>
                </c:forEach>
            </c:if>
        </tbody>
    </table>

    <!-- Biểu đồ -->
    <div>
        <h3>Số hóa đơn theo tháng</h3>
        <canvas id="billCountChart"></canvas>
    </div>
    <div>
        <h3>Thu nhập theo tháng</h3>
        <canvas id="incomeChart"></canvas>
    </div>

    <script>
        // Lấy dữ liệu JSON từ backend
        const statistics = ${statisticsJson};

        console.log("Dữ liệu JSON:", statistics);

        // Xử lý dữ liệu cho biểu đồ
        const months = statistics.map(stat => `${stat.month}/${stat.year}`);
        const billCounts = statistics.map(stat => stat.billCount);
        const totalIncomes = statistics.map(stat => stat.totalIncome);

        // Biểu đồ số hóa đơn
        const billCountCtx = document.getElementById('billCountChart').getContext('2d');
        new Chart(billCountCtx, {
            type: 'bar',
            data: {
                labels: months,
                datasets: [{
                    label: 'Số hóa đơn',
                    data: billCounts,
                    backgroundColor: 'rgba(54, 162, 235, 0.6)',
                    borderColor: 'rgba(54, 162, 235, 1)',
                    borderWidth: 1
                }]
            },
            options: {
                responsive: true,
                plugins: {
                    legend: { display: true },
                    tooltip: { enabled: true },
                },
            },
        });

        // Biểu đồ thu nhập
        const incomeCtx = document.getElementById('incomeChart').getContext('2d');
        new Chart(incomeCtx, {
            type: 'line',
            data: {
                labels: months,
                datasets: [{
                    label: 'Thu nhập',
                    data: totalIncomes,
                    borderColor: 'rgba(75, 192, 192, 1)',
                    backgroundColor: 'rgba(75, 192, 192, 0.2)',
                    borderWidth: 2,
                    fill: true,
                }]
            },
            options: {
                responsive: true,
                plugins: {
                    legend: { display: true },
                    tooltip: { enabled: true },
                },
                scales: {
                    y: {
                        beginAtZero: true,
                        ticks: {
                            callback: function(value) {
                                return new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(value);
                            }
                        }
                    }
                }
            },
        });
    </script>
</body>
</html>
