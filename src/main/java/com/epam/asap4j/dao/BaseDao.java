package com.epam.asap4j.dao;

import java.math.BigInteger;
import java.util.List;

/**
 * User: Andrei_Akatsyeu
 * Date: 12/3/13
 */
public interface BaseDao <T> {

    T getEntityById(BigInteger id);

    List<T> getEntitiesList();

    BigInteger addEntity(T entity);

    void updateEntity(T entity);

    void deleteEntity(T entity);

}
