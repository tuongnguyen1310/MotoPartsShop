<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/layouts/user/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thống kê hóa đơn</title>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@kurkle/color@0.1.9/dist/color.min.js"></script>
    <style>
        canvas {
            max-width: 700px;
            margin: 20px auto;
            display: block;
        }
        button {
            margin: 5px;
            padding: 10px 15px;
            border: none;
            background-color: #007bff;
            color: white;
            cursor: pointer;
            border-radius: 5px;
        }
        button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <h1 style="text-align: center;">Thống kê hóa đơn</h1>

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
            <c:forEach var="item" items="${statistics}">
                <tr>
                    <td>${item.month}</td>
                    <td>${item.year}</td>
                    <td>${item.billCount}</td>
                    <td><fmt:formatNumber value="${item.totalIncome}" type="number" groupingUsed="true"/> ₫</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <div>
        <h3>Số hóa đơn theo tháng</h3>
        <canvas id="billCountChart"></canvas>
    </div>

    <div>
        <h3>Thu nhập theo tháng</h3>
        <canvas id="incomeChart"></canvas>
    </div>

    <div style="text-align: center;">
        <h3>Đổi kiểu điểm</h3>
        <button onclick="applyPointStyle('circle')">Circle</button>
        <button onclick="applyPointStyle('cross')">Cross</button>
        <button onclick="applyPointStyle('star')">Star</button>
        <button onclick="applyPointStyle('triangle')">Triangle</button>
        <button onclick="applyPointStyle(false)">Default</button>
    </div>

    <script>
    // Chuyển đổi dữ liệu từ server thành JSON
    const statistics = JSON.parse('<c:out value="${statistics}" escapeXml="true"/>');
    
    // Debug: In ra console để kiểm tra dữ liệu
    console.log(statistics);

    // Dữ liệu cho biểu đồ
    const months = statistics.map(stat => `${stat.month}/${stat.year}`);
    const billCounts = statistics.map(stat => stat.billCount);
    const totalIncomes = statistics.map(stat => stat.totalIncome);

    // Biểu đồ số hóa đơn
    const billCountCtx = document.getElementById('billCountChart').getContext('2d');
    new Chart(billCountCtx, {
        type: 'line',
        data: {
            labels: months,
            datasets: [{
                label: 'Số hóa đơn',
                data: billCounts,
                borderColor: 'rgba(75, 192, 192, 1)',
                backgroundColor: 'rgba(75, 192, 192, 0.2)',
                pointStyle: 'circle',
                pointRadius: 6,
                pointHoverRadius: 10
            }]
        }
    });

    // Biểu đồ thu nhập
    const incomeCtx = document.getElementById('incomeChart').getContext('2d');
    new Chart(incomeCtx, {
        type: 'bar',
        data: {
            labels: months,
            datasets: [{
                label: 'Tổng thu nhập',
                data: totalIncomes,
                borderColor: 'rgba(255, 99, 132, 1)',
                backgroundColor: 'rgba(255, 99, 132, 0.2)',
                pointStyle: 'circle',
                pointRadius: 6,
                pointHoverRadius: 10
            }]
        }
    });
</script>

</body>
</html>
