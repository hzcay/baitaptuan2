package com.example.controller;

import com.example.entity.Category;
import com.example.entity.User;
import com.example.service.CategoryService;
import com.example.service.UserService;
import com.example.service.impl.CategoryServiceImpl;
import com.example.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/manager/home")
public class ManagerHomeController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        CategoryService categoryService = new CategoryServiceImpl();
        UserService userService = new UserServiceImpl();
        
        // ✅ Get selected userID from parameter (default to all)
        String selectedUserIdParam = req.getParameter("userId");
        List<Category> categories;
        
        if (selectedUserIdParam != null && !selectedUserIdParam.isEmpty()) {
            // Show categories of selected user
            int selectedUserId = Integer.parseInt(selectedUserIdParam);
            categories = categoryService.getByUserId(selectedUserId);
        } else {
            // Show all categories by default
            categories = categoryService.getAll();
        }
        
        // Get all users for dropdown
        List<User> users = userService.getAll();
        
        req.setAttribute("categories", categories);
        req.setAttribute("users", users);
        req.setAttribute("selectedUserId", selectedUserIdParam);
        req.getRequestDispatcher("/views/manager/home.jsp").forward(req, resp);
    }
}
