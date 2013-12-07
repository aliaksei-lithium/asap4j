package com.epam.asap4j.dao;

import com.epam.asap4j.dto.GroupParticipation;
import org.springframework.stereotype.Repository;

/**
 * User: Andrei_Akatsyeu
 * Date: 12/3/13
 */
@Repository
public class GroupParticipationDaoImpl extends BaseDaoImpl<GroupParticipation, Long> implements GroupParticipationDao {

    public GroupParticipationDaoImpl() {
        super(GroupParticipation.class);
    }

    @Override
    public GroupParticipation getByGroupPersonId(Long groupId, String personId) {
        return (GroupParticipation) sessionFactory.getCurrentSession()
                .createQuery("from l_group_participation gp where gp.group.groupId = :groupId and gp.person.personId = :personId")
                .setParameter("groupId", groupId)
                .setParameter("personId", personId).uniqueResult();
    }
}
