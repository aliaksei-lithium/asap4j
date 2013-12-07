package com.epam.asap4j;

import com.epam.asap4j.dao.*;
import com.epam.asap4j.dto.*;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
    public void testAddEntities() {

        Person andrei = new Person("4060741400005112579", "Andrei Akatsyeu");
        personDao.saveOrUpdate(andrei);

        Person arkadiy = new Person("271118", "Arkadiy Dobkin");
        personDao.saveOrUpdate(arkadiy);

        Feature featureBirthDay = new Feature(1L, "BirthDay");
        featureDao.saveOrUpdate(featureBirthDay);

        Feature featureWish = new Feature(2L, "Wish List");
        featureDao.saveOrUpdate(featureWish);

        System.out.println(personDao.getEntitiesList());

        Group groupMinsk = new Group(1L, "Location Minsk");
        groupDao.saveOrUpdate(groupMinsk);

        Group groupNewtown = new Group(2L, "Location Newtown");
        groupDao.saveOrUpdate(groupNewtown);

        Group groupUPSA = new Group(3L, "Project EPM-UPSA");
        groupDao.saveOrUpdate(groupUPSA);

        Group groupE3S = new Group(4L, "Unit E3S");
        groupDao.saveOrUpdate(groupE3S);

        System.out.println(groupDao.getEntitiesList());

        GroupParticipation groupParticipation = new GroupParticipation(groupMinsk, andrei);
        groupParticipationDao.saveOrUpdate(groupParticipation);

        groupParticipation = new GroupParticipation(groupUPSA, andrei);
        groupParticipationDao.saveOrUpdate(groupParticipation);
        subscribtionDao.saveOrUpdate(new Subscribtion(groupParticipation, featureBirthDay));

        groupParticipation = new GroupParticipation(groupE3S, andrei);
        groupParticipationDao.saveOrUpdate(groupParticipation);
        subscribtionDao.saveOrUpdate(new Subscribtion(groupParticipation, featureBirthDay));
        subscribtionDao.saveOrUpdate(new Subscribtion(groupParticipation, featureWish));

        groupParticipation = new GroupParticipation(groupNewtown, arkadiy);
        groupParticipationDao.saveOrUpdate(groupParticipation);
        subscribtionDao.saveOrUpdate(new Subscribtion(groupParticipation, featureWish));

        groupParticipation = new GroupParticipation(groupUPSA, arkadiy);
        groupParticipationDao.saveOrUpdate(groupParticipation);

        eventDao.saveOrUpdate(new Event("Dasha birthday", featureBirthDay, Arrays.asList(groupE3S,groupMinsk,groupUPSA)));
        eventDao.saveOrUpdate(new Event("I wish a darts", featureBirthDay, Arrays.asList(groupE3S,groupUPSA)));
        eventDao.saveOrUpdate(new Event("Super USA wish", featureBirthDay, Arrays.asList(groupNewtown)));
        eventDao.saveOrUpdate(new Event("Sam from newtown birthday", featureBirthDay, Arrays.asList(groupNewtown)));

        System.out.println("Andrei birthday: " + eventDao.getPersonEventsByFeature(andrei, featureBirthDay));
        System.out.println("Andrei wish: " + eventDao.getPersonEventsByFeature(andrei, featureWish));
        System.out.println("Arkadiy wish: " + eventDao.getPersonEventsByFeature(arkadiy, featureWish));
        System.out.println(personDao.getPersonsWithSubscribtionOnFeature(featureBirthDay));
    }
}
