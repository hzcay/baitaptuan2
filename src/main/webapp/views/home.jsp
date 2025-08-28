<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Trang chủ</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <!-- Include topbar -->
    <jsp:include page="topbar.jsp" />
    
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <h1>Chào mừng đến với trang chủ!</h1>
                <c:if test="${sessionScope.account != null}">
                    <h2>Xin chào, <strong>${sessionScope.account.fullName}</strong>!</h2>
                    <p>Bạn đã đăng nhập thành công.</p>
                </c:if>
            </div>
        </div>
    </div>
</body>
</html>
