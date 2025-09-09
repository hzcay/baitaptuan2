package com.example.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.entity.Category;
import com.example.service.CategoryService;
import com.example.service.impl.CategoryServiceImpl;

@WebServlet("/admin/category/add")
public class CategoryAddController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CategoryService categoryService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
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

        Category category = new Category();
        category.setCatename(catename);
        category.setIcon(icon);

        categoryService.insert(category);
        resp.sendRedirect(req.getContextPath() + "/admin/category/list");
    }
}
