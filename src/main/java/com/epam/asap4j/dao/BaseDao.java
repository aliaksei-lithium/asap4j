package com.epam.asap4j.dao;

import com.epam.asap4j.dto.Entity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * User: Andrei_Akatsyeu
 * Date: 12/3/13
 */
public interface BaseDao <T extends Entity> {

    T getEntityById(long id);

    List<T> getEntitiesList();

    long addEntity(T entity);

    void updateEntity(T entity);

    void deleteEntity(T entity);

}
