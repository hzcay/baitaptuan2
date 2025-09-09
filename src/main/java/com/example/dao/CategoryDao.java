package com.example.dao;

import java.util.List;
import com.example.entity.Category;

public interface CategoryDao extends GenericDao<Category, Integer> {
    List<Category> findByKeyword(String keyword);
    List<Category> findByUserId(int userId);
}
