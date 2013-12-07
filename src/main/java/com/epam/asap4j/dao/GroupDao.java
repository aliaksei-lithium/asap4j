package com.epam.asap4j.dao;

import com.epam.asap4j.dto.Group;

/**
 * User: Andrei_Akatsyeu
 * Date: 12/3/13
 */
public interface GroupDao extends BaseDao<Group, Long> {

   Group getExternalGroup(String externalId, Group.Type groupType);
}
