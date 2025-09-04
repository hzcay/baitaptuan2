<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Dashboard</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <style>
        .dashboard-container {
            margin-top: 20px;
        }
        .dashboard-card {
            background: #fff;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
            padding: 20px;
            margin-bottom: 20px;
            transition: transform 0.2s;
        }
        .dashboard-card:hover {
            transform: translateY(-2px);
            box-shadow: 0 4px 8px rgba(0,0,0,0.15);
        }
        .dashboard-icon {
            font-size: 48px;
            margin-bottom: 15px;
        }
        .welcome-section {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            color: white;
            padding: 30px;
            border-radius: 8px;
            margin-bottom: 30px;
        }
        .navbar-custom {
            background-color: #2c3e50;
            border: none;
        }
        .navbar-custom .navbar-brand,
        .navbar-custom .navbar-nav > li > a {
            color: #ecf0f1;
        }
        .navbar-custom .navbar-nav > li > a:hover {
            color: #3498db;
        }
    </style>
</head>
<body>
    <!-- Navigation -->
    <nav class="navbar navbar-custom">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="${pageContext.request.contextPath}/admin/home">
                    <i class="fa fa-dashboard"></i> Admin Panel
                </a>
            </div>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <i class="fa fa-user"></i> ${sessionScope.account.fullName} <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="${pageContext.request.contextPath}/logout"><i class="fa fa-sign-out"></i> Đăng xuất</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </nav>

    <div class="container-fluid dashboard-container">
        <!-- Welcome Section -->
        <div class="welcome-section">
            <h2><i class="fa fa-hand-o-right"></i> Chào mừng, ${sessionScope.account.fullName}!</h2>
            <p class="lead">Bạn đang đăng nhập với quyền quản trị viên. Chọn chức năng bên dưới để bắt đầu quản lý hệ thống.</p>
        </div>

        <!-- Dashboard Cards -->
        <div class="row">
            <div class="col-md-3 col-sm-6">
                <div class="dashboard-card text-center">
                    <div class="dashboard-icon text-primary">
                        <i class="fa fa-list"></i>
                    </div>
                    <h4>Quản lý Category</h4>
                    <p class="text-muted">Thêm, sửa, xóa danh mục sản phẩm</p>
                    <a href="${pageContext.request.contextPath}/admin/category/list" class="btn btn-primary">
                        <i class="fa fa-arrow-right"></i> Truy cập
                    </a>
                </div>
            </div>
            
            <div class="col-md-3 col-sm-6">
                <div class="dashboard-card text-center">
                    <div class="dashboard-icon text-success">
                        <i class="fa fa-users"></i>
                    </div>
                    <h4>Quản lý User</h4>
                    <p class="text-muted">Xem và quản lý tài khoản người dùng</p>
                    <a href="#" class="btn btn-success">
                        <i class="fa fa-arrow-right"></i> Truy cập
                    </a>
                </div>
            </div>
            
            <div class="col-md-3 col-sm-6">
                <div class="dashboard-card text-center">
                    <div class="dashboard-icon text-warning">
                        <i class="fa fa-shopping-cart"></i>
                    </div>
                    <h4>Quản lý Sản phẩm</h4>
                    <p class="text-muted">Thêm, sửa, xóa sản phẩm</p>
                    <a href="#" class="btn btn-warning">
                        <i class="fa fa-arrow-right"></i> Truy cập
                    </a>
                </div>
            </div>
            
            <div class="col-md-3 col-sm-6">
                <div class="dashboard-card text-center">
                    <div class="dashboard-icon text-info">
                        <i class="fa fa-bar-chart"></i>
                    </div>
                    <h4>Thống kê</h4>
                    <p class="text-muted">Xem báo cáo và thống kê hệ thống</p>
                    <a href="#" class="btn btn-info">
                        <i class="fa fa-arrow-right"></i> Truy cập
                    </a>
                </div>
            </div>
        </div>

        <!-- Quick Actions -->
        <div class="row">
            <div class="col-md-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title"><i class="fa fa-flash"></i> Thao tác nhanh</h3>
                    </div>
                    <div class="panel-body">
                        <div class="btn-group" role="group">
                            <a href="${pageContext.request.contextPath}/admin/category/add" class="btn btn-primary">
                                <i class="fa fa-plus"></i> Thêm Category
                            </a>
                            <a href="${pageContext.request.contextPath}/register" class="btn btn-success">
                                <i class="fa fa-user-plus"></i> Thêm User
                            </a>
                            <a href="${pageContext.request.contextPath}/logout" class="btn btn-danger">
                                <i class="fa fa-sign-out"></i> Đăng xuất
                            </a>
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
