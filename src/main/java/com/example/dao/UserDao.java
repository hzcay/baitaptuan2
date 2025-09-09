package com.example.dao;

import com.example.entity.User;

public interface UserDao {
    User get(String username);
    void insert(User user);
    boolean checkExistEmail(String email);
    boolean checkExistUsername(String username);
    boolean checkExistPhone(String phone);
    boolean updatePassword(String username, String newPassword);
}
