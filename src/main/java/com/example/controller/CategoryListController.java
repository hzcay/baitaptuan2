package com.example.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.entity.Category;
import com.example.service.CategoryService;
import com.example.service.impl.CategoryServiceImpl;

@WebServlet("/admin/category/list")
public class CategoryListController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CategoryService categoryService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        List<Category> categoryList = categoryService.getAll();
        req.setAttribute("categoryList", categoryList);
        
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/list-category.jsp");
        dispatcher.forward(req, resp);
    }
}
