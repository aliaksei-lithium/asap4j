package com.epam.asap4j.dao;

import com.epam.asap4j.dto.Person;
import com.epam.asap4j.dto.Subscribtion;
import org.springframework.stereotype.Repository;

/**
 * User: Andrei_Akatsyeu
 * Date: 12/3/13
 */
@Repository
public class SubscribtionDaoImpl extends BaseDaoImpl<Subscribtion, Long> implements SubscribtionDao {

    public SubscribtionDaoImpl() {
        super(Subscribtion.class);
    }
}
