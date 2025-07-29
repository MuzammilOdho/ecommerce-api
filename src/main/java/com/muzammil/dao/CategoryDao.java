package com.muzammil.dao;

import com.muzammil.model.Category;

import java.util.List;

public interface CategoryDao {

    void save(Category category);
    List<Category> findAll();
    Category findById(long id);
    void delete(Category category);
    void update(Category category);

}
