package com.muzammil.dao;

import com.muzammil.model.Product;

import java.util.List;

public interface ProductDao {

    void save(Product product);
    void update(Product product);
    void delete(Product product);
    Product findById(long id);
    List<Product> findAll();

}
