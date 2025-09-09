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

@WebServlet("/manager/category/edit")
public class ManagerCategoryEditController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CategoryService categoryService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Category category = categoryService.get(id);
        
        // ✅ Check ownership: Manager can only edit their own categories
        HttpSession session = req.getSession();
        User currentUser = (User) session.getAttribute("account");
        
        if (category == null || category.getUserId() != currentUser.getId()) {
            resp.sendRedirect(req.getContextPath() + "/manager/home?error=access_denied");
            return;
        }
        
        req.setAttribute("category", category);
        req.getRequestDispatcher("/views/manager/edit-category.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        
        int cateid = Integer.parseInt(req.getParameter("cateid"));
        String catename = req.getParameter("catename");
        String icon = req.getParameter("icon");

        // ✅ Get existing category and check ownership
        Category category = categoryService.get(cateid);
        HttpSession session = req.getSession();
        User currentUser = (User) session.getAttribute("account");
        
        if (category != null && category.getUserId() == currentUser.getId()) {
            category.setCatename(catename);
            if (icon != null && !icon.trim().isEmpty()) {
                category.setIcon(icon);
            }
            categoryService.edit(category);
        }
        
        resp.sendRedirect(req.getContextPath() + "/manager/home");
    }
}
