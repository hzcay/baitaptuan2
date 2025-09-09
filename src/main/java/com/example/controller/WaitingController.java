package com.example.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet(urlPatterns="/waiting")
public class WaitingController extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if(session != null && session.getAttribute("account") != null) {
            // Đăng nhập thành công, chuyển đến trang chủ
            resp.sendRedirect(req.getContextPath()+"/home");
        } else {
            resp.sendRedirect(req.getContextPath()+"/login");
        }
    }
}
