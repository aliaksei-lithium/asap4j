package com.epam.asap4j.dao;

import com.epam.asap4j.dto.Event;
import com.epam.asap4j.dto.Subscribtion;
import org.springframework.stereotype.Repository;

/**
 * User: Andrei_Akatsyeu
 * Date: 12/3/13
 */
@Repository
public class EventDaoImpl extends BaseDaoImpl<Event, Long> implements EventDao {

    public EventDaoImpl() {
        super(Event.class);
    }
}
