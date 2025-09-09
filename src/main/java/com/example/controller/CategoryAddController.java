package com.example.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.entity.Category;
import com.example.entity.User;
import com.example.service.CategoryService;
import com.example.service.UserService;
import com.example.service.impl.CategoryServiceImpl;
import com.example.service.impl.UserServiceImpl;

@WebServlet("/admin/category/add")
public class CategoryAddController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CategoryService categoryService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        // ✅ Load tất cả users để admin chọn
        UserService userService = new UserServiceImpl();
        List<User> users = userService.getAll();
        req.setAttribute("users", users);
        
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/add-category.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        String catename = req.getParameter("catename");
        String icon = req.getParameter("icon");
        String selectedUserId = req.getParameter("userId"); // ✅ Admin chọn user

        if (catename != null && !catename.trim().isEmpty() && selectedUserId != null) {
            int userId = Integer.parseInt(selectedUserId);
            Category category = new Category(catename, icon, userId);
            categoryService.insert(category);
        }
        
        resp.sendRedirect(req.getContextPath() + "/admin/home"); // ✅ Về admin home
    }
}
