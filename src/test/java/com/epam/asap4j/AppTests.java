package com.epam.asap4j;

import com.epam.asap4j.dao.*;
import com.epam.asap4j.dto.Group;
import com.epam.asap4j.dto.GroupParticipation;
import com.epam.asap4j.dto.Person;
import com.epam.asap4j.dto.Subscribtion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigInteger;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {
        "classpath:/META-INF/spring/common.xml",
        "classpath:/META-INF/spring/mvc.xml",
        "classpath:/META-INF/spring/dao.xml"})
public class AppTests {

    @Autowired
    private PersonDao personDao;

    @Autowired
    private GroupDao groupDao;

    @Autowired
    private GroupParticipationDao groupParticipationDao;

    @Autowired
    private SubscribtionDao subscribtionDao;

    @Autowired
    private FeatureDao featureDao;

    @Autowired
    private EventDao eventDao;

    @Test
    public void testAddEntities(){
        personDao.saveOrUpdate(new Person("271118", "Arkadiy Dobkin"));
        personDao.saveOrUpdate(new Person("4060741400005112579", "Andrei Akatsyeu"));

        System.out.println(personDao.getEntitiesList());

        Group group = new Group(null, "Project EPM-UPSA");
        groupDao.saveOrUpdate(group);
        System.out.println(group);

        //groupDao.saveOrUpdate(new Group(null, "Location Minsk"));
        //groupDao.saveOrUpdate(new Group(null, "Unit E3S"));

    }
}
