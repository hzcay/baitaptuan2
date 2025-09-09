package com.example.utils;

public class Constant {
    public static final String SESSION_USERNAME = "username";
    public static final String COOKIE_REMEMBER = "username";
    
    // ✅ Fixed role system as per requirement
    public static final int ROLE_USER = 1;      // user role
    public static final int ROLE_MANAGER = 2;   // manager role
    public static final int ROLE_ADMIN = 3;     // admin role
    
    public static class Path {
        public static final String REGISTER = "/views/register.jsp";
        public static final String LOGIN = "/views/login.jsp";
        public static final String ADMIN_HOME = "/views/admin/home.jsp";
    }
}
