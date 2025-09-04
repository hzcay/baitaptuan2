package com.example;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/category/edit")
public class CategoryEditController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CategoryService categoryService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        String id = req.getParameter("id");
        Category category = categoryService.get(Integer.parseInt(id));
        req.setAttribute("category", category);
        
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/edit-category.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        int cateid = Integer.parseInt(req.getParameter("cateid"));
        String catename = req.getParameter("catename");
        String icon = req.getParameter("icon");

        Category category = new Category();
        category.setCateid(cateid);
        category.setCatename(catename);
        category.setIcon(icon);

        categoryService.edit(category);
        resp.sendRedirect(req.getContextPath() + "/admin/category/list");
    }
}
