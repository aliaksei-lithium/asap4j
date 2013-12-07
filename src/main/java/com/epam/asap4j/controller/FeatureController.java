package com.epam.asap4j.controller;

import com.epam.asap4j.dto.Event;
import com.epam.asap4j.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/features")
public class FeatureController {

    @Autowired
    private EventService eventService;

    @RequestMapping(method = RequestMethod.GET)
    public String doIt() {
        return "layout";
    }

    @RequestMapping(value = "events", method = RequestMethod.POST)
    public String saveFeature(Event event) {
        eventService.saveEvent(event.getTitle(), event.getDescription(), event.getFeature().getFeatureId(), event.getGroupId());
        return "redirect:dashboard";
    }
}
