package com.example.controller;

import com.example.entity.Category;
import com.example.service.CategoryService;
import com.example.service.impl.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/home")
public class AdminHomeController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        CategoryService categoryService = new CategoryServiceImpl();
        // ✅ Admin role: Hiển thị TẤT CẢ category
        List<Category> categories = categoryService.getAll();
        req.setAttribute("categories", categories);
        req.getRequestDispatcher("/views/admin/home.jsp").forward(req, resp);
    }
}