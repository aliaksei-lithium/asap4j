package com.epam.asap4j.service;

import com.epam.asap4j.dao.EmployeeInfoDao;
import com.epam.asap4j.dao.EventDao;
import com.epam.asap4j.dao.PersonDao;
import com.epam.asap4j.dto.Event;
import com.epam.asap4j.dto.Feature;
import com.epam.asap4j.dto.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

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
    private EmployeeInfoDao employeeInfoDao;

    private static final Feature BIRTH_DAY = new Feature(1l, "BirthDay");

    @Override
    public void fillBirthDayEvents() {
        for(Person person : personDao.getEntitiesList()){
            if(eventDao.hasEventByExternalId(person.getPersonId(), BIRTH_DAY)){
                Event event = new Event(person.getPersonName(), BIRTH_DAY, groupService.getPersonGroups(person));
                event.setDate(employeeInfoDao.getEntityById(person.getPersonId()).getBirthday());
                eventDao.saveOrUpdate(event);
            }
        }
    }
}
