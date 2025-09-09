package com.example.dao.impl;

import com.example.config.JPAUtil;
import com.example.dao.CategoryDao;
import com.example.entity.Category;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

public class CategoryDaoImpl extends GenericDaoImpl<Category, Integer> implements CategoryDao {
    
    @Override
    public Category findByName(String name) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery(
                "SELECT c FROM Category c WHERE c.catename = :name", Category.class)
                .setParameter("name", name)
                .getSingleResult();
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }
    
    @Override
    public List<Category> findByKeyword(String keyword) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery(
                "SELECT c FROM Category c WHERE c.catename LIKE :keyword", Category.class)
                .setParameter("keyword", "%" + keyword + "%")
                .getResultList();
        } finally {
            em.close();
        }
    }
    
    @Override
    public List<Category> findByUserId(int userId) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery(
                "SELECT c FROM Category c WHERE c.userId = :userId", Category.class)
                .setParameter("userId", userId)
                .getResultList();
        } finally {
            em.close();
        }
    }
}
