package com.example.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.entity.User;
import com.example.service.UserService;
import com.example.service.impl.UserServiceImpl;
import com.example.utils.Constant;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/login")
public class LoginController extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session != null && session.getAttribute("account") != null) {
            User user = (User) session.getAttribute("account");
            if(user.getRoleid() == Constant.ROLE_ADMIN) {
                resp.sendRedirect(req.getContextPath() + "/admin/home");
            } else {
                resp.sendRedirect(req.getContextPath() + "/waiting");
            }
            return;
        }
        
        // Check cookie
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("username")) {
  
                    UserService service = new UserServiceImpl();
                    User user = service.get(cookie.getValue());
                    if (user != null) {
                        session = req.getSession(true);
                        session.setAttribute("account", user);
                        if(user.getRoleid() == Constant.ROLE_ADMIN) {
                            resp.sendRedirect(req.getContextPath() + "/admin/home");
                        } else {
                            resp.sendRedirect(req.getContextPath() + "/waiting");
                        }
                        return;
                    }
                }
            }
        }
        req.getRequestDispatcher("views/login.jsp").forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        boolean isRememberMe = false;
        String remember = req.getParameter("remember");
        
        if("on".equals(remember)){
            isRememberMe = true;
        }
        String alertMsg = "";
        
        if(username.isEmpty() || password.isEmpty()){
            alertMsg = "Tài khoản hoặc mật khẩu không được rỗng";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
            return;
        }
        
        UserService service = new UserServiceImpl();
        User user = service.login(username, password);
        
        if(user != null){
            HttpSession session = req.getSession(true);
            session.setAttribute("account", user);
            if(isRememberMe){
                saveRemeberMe(resp, username);
            }
            
            // Phân quyền theo role
            if(user.getRoleid() == Constant.ROLE_ADMIN) {
                resp.sendRedirect(req.getContextPath()+"/admin/home");
            } else {
                resp.sendRedirect(req.getContextPath()+"/waiting");
            }
        } else {
            alertMsg = "Tài khoản hoặc mật khẩu không đúng";
            req.setAttribute("alert", alertMsg);
            req.getRequestDispatcher("/views/login.jsp").forward(req, resp);
        }
    }
    
    private void saveRemeberMe(HttpServletResponse response, String username){
        Cookie cookie = new Cookie(Constant.COOKIE_REMEMBER, username);
        cookie.setMaxAge(30*60);
        response.addCookie(cookie);
    }
}
