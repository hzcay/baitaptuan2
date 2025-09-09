package com.example.dao.impl;

import com.example.config.JPAUtil;
import com.example.dao.UserDao;
import com.example.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

public class UserDaoImpl extends GenericDaoImpl<User, Integer> implements UserDao {
    
    @Override
    public User findByName(String name) {
        // For User entity, "name" typically refers to username
        return findByUsername(name);
    }

    @Override
    public User findByUsername(String username) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            TypedQuery<User> query = em.createQuery(
                "SELECT u FROM User u WHERE u.userName = :username", User.class);
            query.setParameter("username", username);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }
    
    @Override
    public boolean existsByEmail(String email) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            Long count = em.createQuery(
                "SELECT COUNT(u) FROM User u WHERE u.email = :email", Long.class)
                .setParameter("email", email)
                .getSingleResult();
            return count > 0;
        } finally {
            em.close();
        }
    }
    
    @Override
    public boolean existsByUsername(String username) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            Long count = em.createQuery(
                "SELECT COUNT(u) FROM User u WHERE u.userName = :username", Long.class)
                .setParameter("username", username)
                .getSingleResult();
            return count > 0;
        } finally {
            em.close();
        }
    }
    
    @Override
    public boolean existsByPhone(String phone) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            Long count = em.createQuery(
                "SELECT COUNT(u) FROM User u WHERE u.phone = :phone", Long.class)
                .setParameter("phone", phone)
                .getSingleResult();
            return count > 0;
        } finally {
            em.close();
        }
    }
    
    @Override
    public boolean updatePassword(String username, String newPassword) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            int updated = em.createQuery(
                "UPDATE User u SET u.passWord = :password WHERE u.userName = :username")
                .setParameter("password", newPassword)
                .setParameter("username", username)
                .executeUpdate();
            tx.commit();
            return updated > 0;
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }
    
    @Override
    public List<User> findByRole(int roleId) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery(
                "SELECT u FROM User u WHERE u.roleid = :roleId", User.class)
                .setParameter("roleId", roleId)
                .getResultList();
        } finally {
            em.close();
        }
    }
}