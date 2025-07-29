package com.muzammil.dao.impl;

import com.muzammil.dao.ProductDao;
import com.muzammil.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao {
    private final SessionFactory sessionFactory;

    @Autowired
    public ProductDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public void save(Product product) {

     getSession().persist(product);

    }
    public void update(Product product) {
        getSession().merge(product);

    }
    public void delete(Product product) {
        getSession().remove(product);
    }
    public Product findById(long id) {
        return getSession().find(Product.class, id);
    }
    public List<Product> findAll() {
        return getSession().createQuery("from Product",Product.class).getResultList();
    }

}
