package com.epam.asap4j.dao;

import com.epam.asap4j.dto.Group;
import com.epam.asap4j.dto.Person;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * User: Andrei_Akatsyeu
 * Date: 12/3/13
 */
@Repository
public class GroupDaoImpl extends BaseDaoImpl<Group, Long> implements GroupDao {

    public GroupDaoImpl() {
        super(Group.class);
    }

    @Override
    public Group getExternalGroup(String externalId, Group.Type groupType) {
        return (Group) sessionFactory.getCurrentSession()
                .createQuery("from m_group where externalId = :externalId and groupType = :groupType")
                .setParameter("externalId", externalId)
                .setParameter("groupType", groupType).uniqueResult();
    }

    public List<Group> getPersonGroups(String personId) {
        return sessionFactory.getCurrentSession()
                .createQuery("select g from l_group_participation gp " +
                        "inner join gp.group g where gp.person.personId = :personId")
                .setParameter("personId", personId).list();
    }
}
