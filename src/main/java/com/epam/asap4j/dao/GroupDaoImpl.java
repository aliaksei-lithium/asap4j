package com.epam.asap4j.dao;

import com.epam.asap4j.dto.Group;
import org.springframework.stereotype.Repository;

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
}
