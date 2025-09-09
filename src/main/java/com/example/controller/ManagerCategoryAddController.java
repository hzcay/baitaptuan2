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

@WebServlet("/manager/category/add")
public class ManagerCategoryAddController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CategoryService categoryService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/views/manager/add-category.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        
        String catename = req.getParameter("catename");
        String icon = req.getParameter("icon");

        // ✅ Get current user from session
        HttpSession session = req.getSession();
        User currentUser = (User) session.getAttribute("account");

        if (catename != null && !catename.trim().isEmpty()) {
            Category category = new Category(catename, icon, currentUser.getId()); // Pass userId
            categoryService.insert(category);
            resp.sendRedirect(req.getContextPath() + "/manager/home");
        }
        
        resp.sendRedirect(req.getContextPath() + "/manager/home");
    }
}
