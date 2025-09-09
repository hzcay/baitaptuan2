<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Dashboard</title>
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
                    <h2>👑 Admin Dashboard - Quản Lý Tất Cả Categories</h2>
                    <div>
                        <span class="badge badge-danger">Admin: ${sessionScope.account.username}</span>
                        <a href="${pageContext.request.contextPath}/logout" class="btn btn-danger btn-sm ml-2">Đăng xuất</a>
                    </div>
                </div>

                <div class="card">
                    <div class="card-header d-flex justify-content-between align-items-center">
                        <h5>📋 Tất Cả Categories</h5>
                        <a href="${pageContext.request.contextPath}/admin/category/add" class="btn btn-primary btn-sm">
                            ➕ Thêm Category
                        </a>
                    </div>
                    <div class="card-body">
                        <c:if test="${empty categories}">
                            <div class="alert alert-info">
                                <i class="fas fa-info-circle"></i> Chưa có category nào trong hệ thống.
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
                                                <td>
                                                    <span class="badge badge-info">${category.userId}</span>
                                                </td>
                                                <td>
                                                    <a href="${pageContext.request.contextPath}/admin/category/edit?id=${category.cateid}" 
                                                       class="btn btn-warning btn-sm">✏️ Sửa</a>
                                                    <a href="${pageContext.request.contextPath}/admin/category/delete?id=${category.cateid}" 
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