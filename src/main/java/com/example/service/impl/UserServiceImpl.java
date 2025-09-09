package com.example.service.impl;

import com.example.dao.UserDao;
import com.example.dao.impl.UserDaoImpl;
import com.example.entity.User;
import com.example.service.UserService;
import com.example.utils.Constant;
import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    
    @Override
    public User login(String username, String password) {
        User user = this.get(username);
        if (user != null && password.equals(user.getPassWord())) {
            return user;
        }
        return null;
    }
    
    @Override
    public User get(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public void insert(User user) {
        userDao.save(user);
    }

    @Override
    public boolean register(String username, String password, String email, String fullname, String phone) {
        if (userDao.existsByUsername(username)) {
            return false;
        }
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        userDao.save(new User(email, username, fullname, password, null, Constant.ROLE_USER, phone, date));
        return true;
    }

    @Override
    public boolean checkExistEmail(String email) {
        return userDao.existsByEmail(email);
    }

    @Override
    public boolean checkExistUsername(String username) {
        return userDao.existsByUsername(username);
    }

    @Override
    public boolean checkExistPhone(String phone) {
        return userDao.existsByPhone(phone);
    }

    @Override
    public boolean resetPassword(String username, String newPassword) {
        return userDao.updatePassword(username, newPassword);
    }
    
    @Override
    public List<User> getAll() {
        return userDao.findAll();
    }
}
