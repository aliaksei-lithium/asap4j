package com.epam.asap4j.service;

import com.epam.asap4j.dto.Group;
import org.json.JSONObject;

public interface GroupService {
    Group getExternalGroup(String externalId, Group.Type groupType);

    Group createGroup(Group group);
}
