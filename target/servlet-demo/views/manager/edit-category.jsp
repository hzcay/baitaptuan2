<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sửa Category - Manager</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-6">
                <div class="card">
                    <div class="card-header">
                        <h4>✏️ Sửa Category</h4>
                    </div>
                    <div class="card-body">
                        <form action="${pageContext.request.contextPath}/manager/category/edit" method="post">
                            <input type="hidden" name="cateid" value="${category.cateid}">
                            
                            <div class="form-group">
                                <label for="catename">Tên Category:</label>
                                <input type="text" class="form-control" id="catename" name="catename" 
                                       value="${category.catename}" required>
                            </div>
                            
                            <div class="form-group">
                                <label for="icon">Icon (emoji hoặc URL):</label>
                                <input type="text" class="form-control" id="icon" name="icon" 
                                       value="${category.icon}" placeholder="🛍️ hoặc URL hình ảnh">
                                <small class="form-text text-muted">
                                    Bạn có thể sử dụng emoji hoặc URL hình ảnh
                                </small>
                            </div>
                            
                            <div class="form-group">
                                <button type="submit" class="btn btn-success">💾 Cập nhật</button>
                                <a href="${pageContext.request.contextPath}/manager/home" class="btn btn-secondary">🔙 Quay lại</a>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
