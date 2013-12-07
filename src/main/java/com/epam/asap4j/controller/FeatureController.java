package com.epam.asap4j.controller;

import com.epam.asap4j.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/features")
public class FeatureController {

    @Autowired
    private EventService eventService;

    @RequestMapping(method = RequestMethod.GET)
    public String doIt() {
        return "layout";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String saveFeature(@RequestParam String title, @RequestParam String description,
                              @RequestParam Long featureId, @RequestParam Long groupId) {
        eventService.saveEvent(title, description, featureId, groupId);
        return "redirect:dashboard";
    }
}
