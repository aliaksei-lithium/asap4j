package com.epam.asap4j.dao;

import com.epam.asap4j.dto.Event;
import com.epam.asap4j.dto.Feature;
import com.epam.asap4j.dto.Person;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
        return sessionFactory.getCurrentSession().createQuery(
                "select distinct e " +
                "from m_event e " +
                "inner join e.groups g, " +
                "l_group_participation gp, " +
                "l_subscribtion sb " +
                "where g.groupId = gp.group.groupId " +
                "and sb.groupParticipation.groupParticipationId = gp.groupParticipationId " +
                "and gp.person.personId = :personId " +
                "and sb.feature.featureId = :featureId ")
                .setParameter("personId", person.getPersonId())
                .setParameter("featureId", feature.getFeatureId()).list();
    }

    @Override
    public boolean hasEventByExternalId(String externalId, Feature feature) {
        return sessionFactory.getCurrentSession().createQuery("select e " +
                "from m_event e " +
                "where e.externalId = :externalId " +
                "and e.feature.featureId = :featureId")
                .setParameter("externalId", externalId)
                .setParameter("featureId", feature.getFeatureId())
                .list().isEmpty();
    }


}
