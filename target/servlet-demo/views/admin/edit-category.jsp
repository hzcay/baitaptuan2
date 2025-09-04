<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sửa Category</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .container {
            margin-top: 20px;
        }
        .form-container {
            max-width: 600px;
            margin: 0 auto;
        }
        .current-icon {
            margin-bottom: 10px;
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
                            <h3 class="panel-title">Sửa Category</h3>
                        </div>
                        <div class="panel-body">
                            <form role="form" action="${pageContext.request.contextPath}/admin/category/edit" method="post">
                                <input type="hidden" name="cateid" value="${category.cateid}">
                                
                                <div class="form-group">
                                    <label for="catename">Tên Category:</label>
                                    <input type="text" class="form-control" id="catename" name="catename" 
                                           value="${category.catename}" placeholder="Nhập tên category" required>
                                </div>
                                
                                <div class="form-group">
                                    <label for="icon">Icon/Ảnh đại diện:</label>
                                    <c:if test="${category.icon != null && category.icon != ''}">
                                        <div class="current-icon">
                                            <strong>Icon hiện tại:</strong><br>
                                            <img src="${pageContext.request.contextPath}/${category.icon}" 
                                                 alt="${category.catename}" width="50" height="50" class="img-thumbnail">
                                        </div>
                                    </c:if>
                                    <input type="text" class="form-control" id="icon" name="icon" 
                                           value="${category.icon}" placeholder="Nhập đường dẫn icon (vd: images/icon.png)">
                                    <small class="help-block">Để trống nếu không có icon</small>
                                </div>
                                
                                <div class="form-group">
                                    <button type="submit" class="btn btn-primary">
                                        <i class="glyphicon glyphicon-save"></i> Cập nhật
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
