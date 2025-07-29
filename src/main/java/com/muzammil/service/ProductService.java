package com.muzammil.service;

import com.muzammil.dao.CategoryDao;
import com.muzammil.dao.ProductDao;
import com.muzammil.dto.request.ProductCreationRequest;
import com.muzammil.dto.response.ProductResponse;
import com.muzammil.mapper.ProductMapper;
import com.muzammil.model.Category;
import com.muzammil.model.Product;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
@Transactional
public class ProductService {
    ProductDao productDao;
    CategoryDao categoryDao;
    public ProductService(ProductDao productDao, CategoryDao categoryDao) {
        this.productDao = productDao;
        this.categoryDao = categoryDao;
    }

    public void save(ProductCreationRequest productCreationRequest) {
        Category category = categoryDao.findById(productCreationRequest.getProductCategoryId());
        if (category == null) {
            return;//TODO
        }
        Product product = ProductMapper.toProduct(productCreationRequest);
        product.setCategory(category);
        productDao.save(product);
    }
//    public void update(ProductCreationRequest productCreationRequest) {
//        if (productDao.findById(productCreationRequest.getProductId()) != null) {
//
//            productDao.update(ProductMapper.toProduct(productCreationRequest));
//
//        }else {
//            //TODO EXCEPTION
//        }
//    }
    public void delete(long id) {
        Product product = productDao.findById(id);
        if (product == null) {
        return;//TODO
        }
            productDao.delete(product);
    }

    public ProductResponse findById(long id){
        Product product = productDao.findById(id);

        if (product == null) {
        return null;    //TODO EXCEPTION
        }

            return ProductMapper.toProductResponse(product);
    }

    public List<ProductResponse> findAll(){

        return  productDao.findAll().stream()
                .map(ProductMapper::toProductResponse)
                .collect(Collectors.toList());

    }
}
