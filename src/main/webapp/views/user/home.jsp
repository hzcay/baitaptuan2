<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Dashboard</title>
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
                    <h2>User Dashboard</h2>
                    <div>
                        <span class="badge badge-primary">User: ${sessionScope.account.username}</span>
                        <a href="${pageContext.request.contextPath}/logout" class="btn btn-danger btn-sm ml-2">Đăng xuất</a>
                    </div>
                </div>

                <div class="card">
                    <div class="card-header">
                        <h5>Categories Của Tôi</h5>
                    </div>
                    <div class="card-body">
                        <c:if test="${empty categories}">
                            <div class="alert alert-info">
                                <i class="fas fa-info-circle"></i> Bạn chưa có category nào được assign.
                            </div>
                        </c:if>
                        
                        <c:if test="${not empty categories}">
                            <div class="row">
                                <c:forEach var="category" items="${categories}">
                                    <div class="col-md-3 mb-3">
                                        <div class="card">
                                            <div class="card-body text-center">
                                                <div class="icon">
                                                    <c:choose>
                                                        <c:when test="${category.icon.startsWith('http')}">
                                                            <img src="${category.icon}" alt="Category Icon" style="width: 80px; height: 80px; object-fit: cover; border-radius: 10px; margin-bottom: 10px;">
                                                        </c:when>
                                                        <c:otherwise>
                                                            <span style="font-size: 2rem;">${category.icon}</span>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </div>
                                                <h6 class="card-title mt-2">${category.catename}</h6>
                                                <small class="text-muted">ID: ${category.cateid} | User: ${category.userId}</small>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
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
