package com.epam.asap4j.service;

import com.epam.asap4j.dao.GroupDao;
import com.epam.asap4j.dto.Group;
import com.epam.asap4j.dto.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupDao groupDao;

    @Autowired
    private GroupParticipationService participationService;

    @Override
    public Group getExternalGroup(String externalId, Group.Type groupType) {
        return groupDao.getExternalGroup(externalId, groupType);
    }

    public Group createGroup(Group group) {
        groupDao.saveOrUpdate(group);
        participationService.fillGroupParticipations(group);
        return group;
    }

    public List<Group> getPersonGroups(Person person) {
        return groupDao.getPersonGroups(person.getPersonId());
    }
}
