package com.epam.asap4j.dao;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

/**
 * User: Andrei_Akatsyeu
 * Date: 12/3/13
 */
public interface BaseDao<T, K extends Serializable> {

    T getEntityById(K id);

    List<T> getEntitiesList();

    void saveOrUpdate(T entity);

    void deleteEntity(T entity);

}
