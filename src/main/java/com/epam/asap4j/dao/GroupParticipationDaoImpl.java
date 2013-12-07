package com.epam.asap4j.dao;

import com.epam.asap4j.dto.GroupParticipation;
import com.epam.asap4j.dto.Person;
import org.springframework.stereotype.Repository;

/**
 * User: Andrei_Akatsyeu
 * Date: 12/3/13
 */
@Repository
public class GroupParticipationDaoImpl extends BaseDaoImpl<GroupParticipation> implements GroupParticipationDao {

    public GroupParticipationDaoImpl() {
        super(GroupParticipation.class);
    }
}
