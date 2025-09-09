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

@WebServlet("/manager/category/delete")
public class ManagerCategoryDeleteController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CategoryService categoryService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Category category = categoryService.get(id);
        
        // ✅ Check ownership: Manager can only delete their own categories
        HttpSession session = req.getSession();
        User currentUser = (User) session.getAttribute("account");
        
        if (category != null && category.getUserId() == currentUser.getId()) {
            categoryService.delete(id);
        }
        
        resp.sendRedirect(req.getContextPath() + "/manager/home");
    }
}
