<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quên mật khẩu</title>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .forgot-container {
            max-width: 400px;
            margin: 50px auto;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        .alert-danger {
            color: #721c24;
            background-color: #f8d7da;
            border-color: #f5c6cb;
            padding: 10px;
            border-radius: 4px;
            margin-bottom: 15px;
        }
        .alert-success {
            color: #155724;
            background-color: #d4edda;
            border-color: #c3e6cb;
            padding: 10px;
            border-radius: 4px;
            margin-bottom: 15px;
        }
        .forgot-input {
            margin-bottom: 15px;
        }
        .form-control {
            height: 45px;
        }
        .btn-forgot {
            width: 100%;
            height: 45px;
            font-size: 16px;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="forgot-container">
            <form action="forgot-password" method="post">
                <h2 class="text-center">Đặt lại mật khẩu</h2>
                
                <c:if test="${alert != null}">
                    <div class="alert alert-danger">${alert}</div>
                </c:if>
                
                <c:if test="${success != null}">
                    <div class="alert alert-success">${success}</div>
                </c:if>
                
                <div class="forgot-input">
                    <label class="input">
                        <div class="input-group">
                            <span class="input-group-addon">
                                <i class="fa fa-user"></i>
                            </span>
                            <input type="text" placeholder="Tên đăng nhập" name="username" class="form-control" required>
                        </div>
                    </label>
                </div>
                
                <div class="forgot-input">
                    <label class="input">
                        <div class="input-group">
                            <span class="input-group-addon">
                                <i class="fa fa-lock"></i>
                            </span>
                            <input type="password" placeholder="Mật khẩu mới" name="newPassword" class="form-control" required>
                        </div>
                    </label>
                </div>
                
                <div class="forgot-input">
                    <label class="input">
                        <div class="input-group">
                            <span class="input-group-addon">
                                <i class="fa fa-lock"></i>
                            </span>
                            <input type="password" placeholder="Nhập lại mật khẩu mới" name="confirmPassword" class="form-control" required>
                        </div>
                    </label>
                </div>
                
                <button type="submit" class="btn btn-primary btn-forgot">Đặt lại mật khẩu</button>
                
                <div class="text-center" style="margin-top: 15px;">
                    <a href="${pageContext.request.contextPath}/login">Quay lại đăng nhập</a>
                </div>
            </form>
        </div>
    </div>
</body>
</html>
