package com.epam.asap4j.service;

import com.epam.asap4j.dto.Group;
import com.epam.asap4j.dto.Person;
import org.json.JSONObject;

import java.util.List;

public interface GroupService {
    Group getExternalGroup(String externalId, Group.Type groupType);

    Group createGroup(Group group);

    List<Group> getPersonGroups(Person person);
}
