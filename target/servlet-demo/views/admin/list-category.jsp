<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh sách Category</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .container {
            margin-top: 20px;
        }
        .table th, .table td {
            vertical-align: middle;
            text-align: center;
        }
        .btn-actions {
            white-space: nowrap;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Quản lý Category</h3>
                        <div class="pull-right">
                            <a href="${pageContext.request.contextPath}/admin/category/add" class="btn btn-primary btn-sm">
                                <i class="glyphicon glyphicon-plus"></i> Thêm Category
                            </a>
                        </div>
                    </div>
                    <div class="panel-body">
                        <table class="table table-striped table-bordered">
                            <thead>
                                <tr>
                                    <th width="10%">STT</th>
                                    <th width="20%">Icon</th>
                                    <th width="40%">Tên Category</th>
                                    <th width="30%">Thao tác</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${categoryList}" var="category" varStatus="STT">
                                    <tr>
                                        <td>${STT.index + 1}</td>
                                        <td>
                                            <c:if test="${category.icon != null && category.icon != ''}">
                                                <img src="${pageContext.request.contextPath}/${category.icon}" 
                                                     alt="${category.catename}" width="50" height="50" class="img-thumbnail">
                                            </c:else>
                                                <span class="text-muted">Không có ảnh</span>
                                            </c:if>
                                        </td>
                                        <td>${category.catename}</td>
                                        <td class="btn-actions">
                                            <a href="${pageContext.request.contextPath}/admin/category/edit?id=${category.cateid}" 
                                               class="btn btn-warning btn-sm">
                                                <i class="glyphicon glyphicon-edit"></i> Sửa
                                            </a>
                                            <a href="${pageContext.request.contextPath}/admin/category/delete?id=${category.cateid}" 
                                               class="btn btn-danger btn-sm" 
                                               onclick="return confirm('Bạn có chắc chắn muốn xóa category này?')">
                                                <i class="glyphicon glyphicon-trash"></i> Xóa
                                            </a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                <c:if test="${empty categoryList}">
                                    <tr>
                                        <td colspan="4" class="text-center text-muted">
                                            Chưa có category nào. <a href="${pageContext.request.contextPath}/admin/category/add">Thêm ngay</a>
                                        </td>
                                    </tr>
                                </c:if>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
