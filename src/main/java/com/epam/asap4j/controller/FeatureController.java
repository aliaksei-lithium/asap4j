package com.epam.asap4j.controller;

import com.epam.asap4j.dao.EventDao;
import com.epam.asap4j.dao.FeatureDao;
import com.epam.asap4j.dto.Event;
import com.epam.asap4j.dto.Feature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/features")
public class FeatureController {

    @Autowired
    private EventDao eventDao;

    @RequestMapping(method = RequestMethod.GET)
    public String doIt() {
        return "layout";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveFeature(Event event) {
        eventDao.saveOrUpdate(event);
        return "redirect:dashboard";
    }
}
