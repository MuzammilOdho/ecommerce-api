package com.muzammil.service;

import com.muzammil.dao.CategoryDao;
import com.muzammil.dto.request.CategoryCreationRequest;
import com.muzammil.dto.response.CategoryResponse;
import com.muzammil.mapper.CategoryMapper;
import com.muzammil.model.Category;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CategoryService {

    CategoryDao categoryDao;

    @Autowired
    public CategoryService(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    public void save(CategoryCreationRequest category) {

        categoryDao.save(CategoryMapper.toCategory(category));

    }

    public CategoryResponse findById(long id) {

        Category category = categoryDao.findById(id);
        if (category == null) {
            return null; // TODO
        }

        return CategoryMapper.toCategoryResponse(category);

    }

    public List<CategoryResponse> findAll() {
       return categoryDao.findAll().stream()
               .map(CategoryMapper::toCategoryResponse)
               .collect(Collectors.toList());
    }


    public void delete(int id) {
        Category category = categoryDao.findById(id);
        if ( category == null) {
            return;//TODO
        }

        categoryDao.delete(category);

    }

    public void update(Category category) {
        Category oldCategory = categoryDao.findById(category.getId());
        if (category == null) {
            return; //TODO
        }
        categoryDao.update(category);

    }





}
