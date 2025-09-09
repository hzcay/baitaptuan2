package com.example.service.impl;

import java.util.List;

import com.example.dao.CategoryDao;
import com.example.dao.impl.CategoryDaoImpl;
import com.example.entity.Category;
import com.example.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {
    private CategoryDao categoryDao = new CategoryDaoImpl();

    @Override
    public void insert(Category category) {
        categoryDao.save(category);
    }

    @Override
    public void edit(Category newCategory) {
        Category oldCategory = categoryDao.findById(newCategory.getCateid());
        if (oldCategory != null) {
            oldCategory.setCatename(newCategory.getCatename());
            if (newCategory.getIcon() != null) {
                oldCategory.setIcon(newCategory.getIcon());
            }
            categoryDao.update(oldCategory);
        }
    }

    @Override
    public void delete(int id) {
        categoryDao.deleteById(id);
    }

    @Override
    public Category get(int id) {
        return categoryDao.findById(id);
    }

    @Override
    public Category get(String name) {
        return categoryDao.findByName(name);
    }

    @Override
    public List<Category> getAll() {
        return categoryDao.findAll();
    }

    @Override
    public List<Category> search(String keyword) {
        return categoryDao.findByKeyword(keyword);
    }
    
    @Override
    public List<Category> getByUserId(int userId) {
        return categoryDao.findByUserId(userId);
    }
}
