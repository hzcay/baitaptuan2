package com.example.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.service.CategoryService;
import com.example.service.impl.CategoryServiceImpl;

@WebServlet("/admin/category/delete")
public class CategoryDeleteController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CategoryService categoryService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        String id = req.getParameter("id");
        categoryService.delete(Integer.parseInt(id));
        resp.sendRedirect(req.getContextPath() + "/admin/category/list");
    }
}
