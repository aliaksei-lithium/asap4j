package com.epam.asap4j.dao;

import com.epam.asap4j.dto.Event;
import com.epam.asap4j.dto.Feature;
import com.epam.asap4j.dto.Person;

import java.util.List;

/**
 * User: Andrei_Akatsyeu
 * Date: 12/3/13
 */
public interface EventDao extends BaseDao<Event, Long> {

    List<Event> getPersonEventsByFeature(Person person, Feature feature);

    boolean hasEventByExternalId(String externalId, Feature feature);

}
