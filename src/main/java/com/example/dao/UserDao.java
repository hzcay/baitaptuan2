package com.example.dao;

import com.example.entity.User;
import java.util.List;

public interface UserDao extends GenericDao<User, Integer> {
    User findByUsername(String username);
    boolean existsByEmail(String email);
    boolean existsByUsername(String username);
    boolean existsByPhone(String phone);
    boolean updatePassword(String username, String newPassword);
    List<User> findByRole(int roleId);
}
