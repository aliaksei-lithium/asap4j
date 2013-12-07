package com.epam.asap4j.service;

import com.epam.asap4j.dao.GroupDao;
import com.epam.asap4j.dto.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupDao groupDao;

    @Override
    public Group getExternalGroup(String externalId, Group.Type groupType) {
        return groupDao.getExternalGroup(externalId, groupType);
    }

    public Group createGroup(Group group) {
        groupDao.saveOrUpdate(group);
        if(group.getGroupId() != null) {

        }
        return group;
    }
}
