package com.example;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/forgot-password")
public class ForgotPasswordController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserService userService = new UserServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        request.getRequestDispatcher("/views/forgot-password.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        String username = request.getParameter("username");
        String newPassword = request.getParameter("newPassword");
        String confirmPassword = request.getParameter("confirmPassword");

        User user = userService.get(username);
        if (user == null) {
            request.setAttribute("alert", "Tài khoản không tồn tại!");
            request.getRequestDispatcher("/views/forgot-password.jsp").forward(request, response);
            return;
        }

        if (!newPassword.equals(confirmPassword)) {
            request.setAttribute("alert", "Mật khẩu nhập lại không khớp!");
            request.getRequestDispatcher("/views/forgot-password.jsp").forward(request, response);
            return;
        }

        user.setPassWord(newPassword);
        boolean success = userService.resetPassword(username, newPassword);
        if (success) {
            request.setAttribute("success", "Đặt lại mật khẩu thành công! Bạn có thể đăng nhập với mật khẩu mới.");
            request.getRequestDispatcher("/views/forgot-password.jsp").forward(request, response);
        } else {
            request.setAttribute("alert", "Có lỗi xảy ra khi đặt lại mật khẩu!");
            request.getRequestDispatcher("/views/forgot-password.jsp").forward(request, response);
        }
    }
}
