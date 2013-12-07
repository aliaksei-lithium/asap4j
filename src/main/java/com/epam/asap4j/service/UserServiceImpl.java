package com.epam.asap4j.service;

import com.epam.asap4j.dao.PersonDao;
import com.epam.asap4j.dao.UserDao;
import com.epam.asap4j.dto.Person;
import com.epam.asap4j.dto.User;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PersonDao personDao;

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
        }
        person.setPersonName(userObject.getString("fullName"));
        user.setPerson(person);
        userDao.saveOrUpdate(user);
        return user;
    }
}
