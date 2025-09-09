<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thêm Category</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .container {
            margin-top: 20px;
        }
        .form-container {
            max-width: 600px;
            margin: 0 auto;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="form-container">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">Thêm Category Mới</h3>
                        </div>
                        <div class="panel-body">
                            <form role="form" action="${pageContext.request.contextPath}/admin/category/add" method="post">
                                <div class="form-group">
                                    <label for="catename">Tên Category:</label>
                                    <input type="text" class="form-control" id="catename" name="catename" 
                                           placeholder="Nhập tên category" required>
                                </div>
                                
                                <div class="form-group">
                                    <label for="icon">Icon (emoji hoặc URL):</label>
                                    <input type="text" class="form-control" id="icon" name="icon" 
                                           placeholder="🛍️ hoặc https://example.com/image.jpg">
                                    <small class="help-block">
                                        Bạn có thể sử dụng emoji hoặc URL hình ảnh
                                    </small>
                                </div>
                                
                                <!-- ✅ Dropdown chọn user -->
                                <div class="form-group">
                                    <label for="userId">Assign cho User:</label>
                                    <select name="userId" id="userId" class="form-control" required>
                                        <option value="">-- Chọn User --</option>
                                        <c:forEach var="user" items="${users}">
                                            <option value="${user.id}">
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
                                
                                <div class="form-group">
                                    <button type="submit" class="btn btn-primary">
                                        <i class="glyphicon glyphicon-plus"></i> Thêm Category
                                    </button>
                                    <a href="${pageContext.request.contextPath}/admin/category/list" class="btn btn-default">
                                        <i class="glyphicon glyphicon-arrow-left"></i> Quay lại
                                    </a>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
