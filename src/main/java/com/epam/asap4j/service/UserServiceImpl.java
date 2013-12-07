package com.epam.asap4j.service;

import com.epam.asap4j.dao.GroupParticipationDao;
import com.epam.asap4j.dao.PersonDao;
import com.epam.asap4j.dao.UserDao;
import com.epam.asap4j.dto.Group;
import com.epam.asap4j.dto.GroupParticipation;
import com.epam.asap4j.dto.Person;
import com.epam.asap4j.dto.User;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(value = "txManager")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PersonDao personDao;

    @Autowired
    private GroupParticipationDao groupParticipationDao;

    @Autowired
    GroupService groupService;

    @Autowired
    private UpsaRestService restService;

    public User loginUser(String name) {
        User user = userDao.getByName(name);

        if(user == null) {
            user  = createNewUser(name);
        }
        return user;
    }

    private User createNewUser(String name) {
        JSONObject userObject = restService.getUserByName(name);
        User user = new User();
        String personId = userObject.getString("employeeId");
        Person person = personDao.getEntityById(personId);
        if(person == null) {
            person = new Person();
            person.setPersonId(personId);
            person.setPersonName(userObject.getString("fullName"));
        }
        user.setPerson(person);
        userDao.saveOrUpdate(user);
        createUserGroups(userObject, user);
        return user;
    }

    private void createUserGroups(JSONObject userObject, User user) {
        Group unitGroup = new Group(null, "Unit " + userObject.getString("unitName"), userObject.getString("unitId"), Group.Type.UNIT);
        createGroup(unitGroup, user.getPerson());

        JSONArray projects =  userObject.getJSONArray("participationList");
        for (int i = 0; i < projects.length(); i++) {
            JSONObject project = projects.getJSONObject(i);
            Group projectGroup = new Group(null, "Project " + project.getString("projectName"), project.getString("projectId"), Group.Type.PROJECT);
            createGroup(projectGroup, user.getPerson());
        }
    }

    private void createGroup(Group newGroup, Person person) {
        Group savedGroup = groupService.getExternalGroup(newGroup.getExternalId(), newGroup.getGroupType());
        GroupParticipation participation = null;
        if(savedGroup == null) {
            savedGroup = groupService.createGroup(newGroup);
        } else {
            participation = groupParticipationDao.getByGroupPersonId(savedGroup.getGroupId(), person.getPersonId());
        }
        if(participation == null) {
            participation = new GroupParticipation(savedGroup, person);
            groupParticipationDao.saveOrUpdate(participation);
        }
    }
}
