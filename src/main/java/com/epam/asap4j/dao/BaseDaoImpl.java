package com.epam.asap4j.dao;

import com.epam.asap4j.dto.Entity;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * User: Andrei_Akatsyeu
 * Date: 12/3/13
 */
public abstract class BaseDaoImpl<T extends Entity> implements BaseDao<T> {

    private Class baseClass;

    @Autowired
    private SessionFactory sessionFactory;

    public BaseDaoImpl(Class baseClass) {
        this.baseClass = baseClass;
    }

    @Override
    @Transactional(value = "txManager")
    public T getEntityById(long id) {
        return (T)sessionFactory.getCurrentSession().get(baseClass, id);
    }

    @Override
    @Transactional(value = "txManager")
    public List<T> getEntitiesList() {
        return (List<T>)sessionFactory.getCurrentSession().createCriteria(baseClass).list();
    }

    @Override
    @Transactional(value = "txManager")
    public long addEntity(T entity) {
        return (Long)sessionFactory.getCurrentSession().save(entity);
    }

    @Override
    @Transactional(value = "txManager")
    public void updateEntity(T entity) {
        sessionFactory.getCurrentSession().update(entity);
    }

    @Override
    @Transactional(value = "txManager")
    public void deleteEntity(T entity) {
        sessionFactory.getCurrentSession().delete(entity);
    }
}
