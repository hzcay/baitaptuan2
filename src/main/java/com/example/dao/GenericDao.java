package com.example.dao;

import java.util.List;

public interface GenericDao<T, ID> {
    T save(T entity);
    T findById(ID id);
    T findByName(String name);
    List<T> findAll();
    T update(T entity);
    void deleteById(ID id); 
    void delete(T entity);
}