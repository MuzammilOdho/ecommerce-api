package com.muzammil.dao.impl;

import com.muzammil.dao.CategoryDao;
import com.muzammil.model.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryDaoImpl implements CategoryDao {

    SessionFactory sessionFactory;

    @Autowired
    public CategoryDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void save(Category category) {

        getSession().persist(category);

    }

    @Override
    public List<Category> findAll() {
      return getSession().createQuery("from Category",Category.class).getResultList();
    }

    @Override
    public Category findById(long id) {
        return getSession().find(Category.class, id);
    }

    @Override
    public void delete(Category category) {
        getSession().remove(category);
    }

    @Override
    public void update(Category category) {
        getSession().merge(category);
    }
}
