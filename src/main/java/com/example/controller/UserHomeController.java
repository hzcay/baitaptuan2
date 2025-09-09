package com.example.controller;

import com.example.entity.Category;
import com.example.entity.User;
import com.example.service.CategoryService;
import com.example.service.impl.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/user/home")
public class UserHomeController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession();
        User currentUser = (User) session.getAttribute("account");
        
        CategoryService categoryService = new CategoryServiceImpl();
        // ✅ User role: Chỉ hiển thị categories của chính user đó (chỉ xem)
        List<Category> categories = categoryService.getByUserId(currentUser.getId());
        req.setAttribute("categories", categories);
        req.getRequestDispatcher("/views/user/home.jsp").forward(req, resp);
    }
}
