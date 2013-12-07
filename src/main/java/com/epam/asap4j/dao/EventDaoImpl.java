package com.epam.asap4j.dao;

import com.epam.asap4j.dto.Event;
import com.epam.asap4j.dto.Feature;
import com.epam.asap4j.dto.Person;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * User: Andrei_Akatsyeu
 * Date: 12/3/13
 */
@Repository
public class EventDaoImpl extends BaseDaoImpl<Event, Long> implements EventDao {

    public EventDaoImpl() {
        super(Event.class);
    }

    @Override
    public List<Event> getPersonEventsByFeature(Person person, Feature feature) {
        return null;
    }
}
