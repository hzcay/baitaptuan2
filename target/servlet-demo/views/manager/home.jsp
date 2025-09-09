<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Manager Dashboard</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <style>
        .card { margin-bottom: 20px; }
        .icon { font-size: 2rem; }
    </style>
</head>
<body>
    <div class="container mt-5">
        <div class="row">
            <div class="col-md-12">
                <div class="d-flex justify-content-between align-items-center mb-4">
                    <h2>👔 Manager Dashboard - Quản Lý Categories Của Tôi</h2>
                    <div>
                        <span class="badge badge-success">Manager: ${sessionScope.account.username}</span>
                        <a href="${pageContext.request.contextPath}/logout" class="btn btn-danger btn-sm ml-2">Đăng xuất</a>
                    </div>
                </div>

                <div class="card">
                    <div class="card-header">
                        <h5>📋 Quản Lý Categories Theo UserID</h5>
                        
                        <!-- Filter by UserID -->
                        <div class="row mt-3">
                            <div class="col-md-4">
                                <form method="get" action="${pageContext.request.contextPath}/manager/home">
                                    <div class="form-group">
                                        <label for="userId">Chọn User:</label>
                                        <select name="userId" id="userId" class="form-control" onchange="this.form.submit()">
                                            <option value="">-- Tất cả users --</option>
                                            <c:forEach var="user" items="${users}">
                                                <option value="${user.id}" 
                                                    <c:if test="${selectedUserId == user.id}">selected</c:if>>
                                                    ${user.username} (ID: ${user.id}) - 
                                                    <c:choose>
                                                        <c:when test="${user.roleid == 1}">User</c:when>
                                                        <c:when test="${user.roleid == 2}">Manager</c:when>
                                                        <c:when test="${user.roleid == 3}">Admin</c:when>
                                                    </c:choose>
                                                </option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="card-body">
                        <c:if test="${empty categories}">
                            <div class="alert alert-info">
                                <i class="fas fa-info-circle"></i> 
                                <c:choose>
                                    <c:when test="${not empty selectedUserId}">
                                        User này chưa có category nào.
                                    </c:when>
                                    <c:otherwise>
                                        Chưa có category nào trong hệ thống.
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </c:if>
                        
                        <c:if test="${not empty categories}">
                            <div class="table-responsive">
                                <table class="table table-striped table-hover">
                                    <thead class="thead-dark">
                                        <tr>
                                            <th>ID</th>
                                            <th>Icon</th>
                                            <th>Tên Category</th>
                                            <th>User ID</th>
                                            <th>Thao tác</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="category" items="${categories}">
                                            <tr>
                                                <td>${category.cateid}</td>
                                                <td>
                                                    <c:choose>
                                                        <c:when test="${category.icon.startsWith('http')}">
                                                            <img src="${category.icon}" alt="Category Icon" style="width: 50px; height: 50px; object-fit: cover; border-radius: 5px;">
                                                        </c:when>
                                                        <c:otherwise>
                                                            <span style="font-size: 1.5rem;">${category.icon}</span>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </td>
                                                <td>${category.catename}</td>
                                                <td>${category.userId}</td>
                                                <td>
                                                    <a href="${pageContext.request.contextPath}/manager/category/edit?id=${category.cateid}" 
                                                       class="btn btn-warning btn-sm">✏️ Sửa</a>
                                                    <a href="${pageContext.request.contextPath}/manager/category/delete?id=${category.cateid}" 
                                                       class="btn btn-danger btn-sm"
                                                       onclick="return confirm('Bạn có chắc muốn xóa category này?')">🗑️ Xóa</a>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
