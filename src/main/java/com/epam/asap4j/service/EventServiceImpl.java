package com.epam.asap4j.service;

import com.epam.asap4j.dao.*;
import com.epam.asap4j.dto.Event;
import com.epam.asap4j.dto.Feature;
import com.epam.asap4j.dto.Group;
import com.epam.asap4j.dto.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Andrei_Akatsyeu on 12/7/13.
 */
@Service
@Transactional(value = "txManager")
public class EventServiceImpl implements EventService {

    @Autowired
    private PersonDao personDao;

    @Autowired
    private EventDao eventDao;

    @Autowired
    private GroupService groupService;

    @Autowired
    private GroupDao groupDao;

    @Autowired
    private FeatureDao featureDao;

    @Autowired
    private EmployeeInfoDao employeeInfoDao;

    private static final Feature BIRTH_DAY = new Feature(1l, "BirthDay");

    @Override
    public void fillBirthDayEvents() {
        for(Person person : personDao.getEntitiesList()){
            if(eventDao.hasEventByExternalId(person.getPersonId(), BIRTH_DAY)){
                Event event = new Event(person.getPersonName(), BIRTH_DAY, groupService.getPersonGroups(person));
                Date date = employeeInfoDao.getEntityById(person.getPersonId()).getBirthday();
                date.setYear(2013);
                event.setDate(date);
                eventDao.saveOrUpdate(event);
            }
        }
    }

    @Override
    public void saveEvent(String title, String description, Long featureId, Long groupId) {
        Event event = new Event();
        event.setTitle(title);
        event.setDescription(description);
        Feature feature = featureDao.getEntityById(featureId);
        Group group = groupDao.getEntityById(groupId);
        List<Group> groups = new ArrayList<>();
        groups.add(group);
        event.setFeature(feature);
        event.setGroups(groups);
        eventDao.saveOrUpdate(event);
    }
}
