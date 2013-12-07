package com.epam.asap4j.controller;

import com.epam.asap4j.dao.EventDao;
import com.epam.asap4j.dto.Event;
import com.epam.asap4j.dto.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventDao eventDao;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String editEvent( @PathVariable("id") Long id) {
        //service get info and type
        return "layout";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String createEvent(Event event) {
        //service create event
        event.getFeature().setFeatureId(new Long(2));
        List<Group> groups = new ArrayList<>();
        groups.add(new Group(event.getGroupId(),""));

        event.setGroups(groups);
        eventDao.saveOrUpdate(event);
        return "redirect:dashboard";
    }



}
