package com.example.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.config.DBConnection;
import com.example.dao.UserDao;
import com.example.entity.User;

public class UserDaoImpl implements UserDao {
    
    @Override
    public User get(String username) {
        String sql = "SELECT * FROM [User] WHERE username = ?";
        
        try (Connection conn = new DBConnection().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setUserName(rs.getString("username"));
                user.setFullName(rs.getString("fullname"));
                user.setPassWord(rs.getString("password"));
                user.setAvatar(rs.getString("avatar"));
                user.setRoleid(rs.getInt("roleid"));
                user.setPhone(rs.getString("phone"));
                user.setCreatedDate(rs.getDate("createdDate"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void insert(User user) {
        String sql = "INSERT INTO [User](email, username, fullname, password, avatar, roleid, phone, createddate) VALUES (?,?,?,?,?,?,?,?)";
        try (Connection conn = new DBConnection().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getUserName());
            ps.setString(3, user.getFullName());
            ps.setString(4, user.getPassWord());
            ps.setString(5, user.getAvatar());
            ps.setInt(6, user.getRoleid());
            ps.setString(7, user.getPhone());
            ps.setDate(8, user.getCreatedDate());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean checkExistEmail(String email) {
        boolean duplicate = false;
        String query = "SELECT * FROM [User] WHERE email = ?";
        try (Connection conn = new DBConnection().getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                duplicate = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return duplicate;
    }

    @Override
    public boolean checkExistUsername(String username) {
        boolean duplicate = false;
        String query = "SELECT * FROM [User] WHERE username = ?";
        try (Connection conn = new DBConnection().getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                duplicate = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return duplicate;
    }

    @Override
    public boolean checkExistPhone(String phone) {
        boolean duplicate = false;
        String query = "SELECT * FROM [User] WHERE phone = ?";
        try (Connection conn = new DBConnection().getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            
            ps.setString(1, phone);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                duplicate = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return duplicate;
    }

    @Override
    public boolean updatePassword(String username, String newPassword) {
        String sql = "UPDATE [User] SET password = ? WHERE username = ?";
        try (Connection conn = new DBConnection().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, newPassword);
            ps.setString(2, username);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
