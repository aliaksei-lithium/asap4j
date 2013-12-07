package com.epam.asap4j.dao;

import com.epam.asap4j.dto.Feature;
import com.epam.asap4j.dto.Person;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * User: Andrei_Akatsyeu
 * Date: 12/3/13
 */
@Repository
public class PersonDaoImpl extends BaseDaoImpl<Person, String> implements PersonDao {

    public PersonDaoImpl() {
        super(Person.class);
    }

    @Override
    public List<Person> getPersonsWithSubscribtionOnFeature(Feature feature) {
        return sessionFactory.getCurrentSession().createQuery(
                "select distinct p " +
                        "from m_person p, " +
                        "l_group_participation gp, " +
                        "l_subscribtion s " +
                        "where p.personId = gp.person.personId " +
                        "and gp.groupParticipationId = s.groupParticipation.groupParticipationId " +
                        "and s.feature.featureId = :featureId")
                .setParameter("featureId", feature.getFeatureId()).list();
    }
}
