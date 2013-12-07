package com.epam.asap4j.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * User: Andrei_Akatsyeu
 * Date: 12/3/13
 */
public abstract class BaseDaoImpl<T, K extends Serializable>
        implements BaseDao<T, K> {

    private Class baseClass;

    @Autowired
    private SessionFactory sessionFactory;

    public BaseDaoImpl(Class baseClass) {
        this.baseClass = baseClass;
    }

    @Override
    @Transactional(value = "txManager")
    public T getEntityById(K id) {
        return (T) sessionFactory.getCurrentSession().get(baseClass, id);
    }

    @Override
    @Transactional(value = "txManager")
    public List<T> getEntitiesList() {
        return (List<T>) sessionFactory.getCurrentSession().createCriteria(baseClass).list();
    }

    @Override
    @Transactional(value = "txManager")
    public void saveOrUpdate(T entity) {
        sessionFactory.getCurrentSession().saveOrUpdate(entity);
    }

    @Override
    @Transactional(value = "txManager")
    public void deleteEntity(T entity) {
        sessionFactory.getCurrentSession().delete(entity);
    }
}
