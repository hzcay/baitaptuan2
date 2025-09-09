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
                                    <label for="icon">Icon/Ảnh đại diện:</label>
                                    <input type="url" class="form-control" id="icon" name="icon" 
                                           placeholder="https://picsum.photos/200/200 hoặc images/icon.png">
                                    <small class="help-block">
                                        Có thể nhập:
                                        <br>• URL đầy đủ: https://example.com/image.jpg
                                        <br>• Đường dẫn local: images/icon.png
                                        <br>• Để trống nếu không có ảnh
                                    </small>
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
