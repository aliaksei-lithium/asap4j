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
@Transactional(value = "txManager")
public abstract class BaseDaoImpl<T, K extends Serializable>
        implements BaseDao<T, K> {

    private Class baseClass;

    @Autowired
    protected SessionFactory sessionFactory;

    public BaseDaoImpl(Class baseClass) {
        this.baseClass = baseClass;
    }

    @Override
    public T getEntityById(K id) {
        return (T) sessionFactory.getCurrentSession().get(baseClass, id);
    }

    @Override
    public List<T> getEntitiesList() {
        return (List<T>) sessionFactory.getCurrentSession().createCriteria(baseClass).list();
    }

    @Override
    public void saveOrUpdate(T entity) {
        sessionFactory.getCurrentSession().saveOrUpdate(entity);
    }

    @Override
    public void deleteEntity(T entity) {
        sessionFactory.getCurrentSession().delete(entity);
    }
}
