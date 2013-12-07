package com.epam.asap4j.controller;

import com.epam.asap4j.dto.Event;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/events")
public class EventController {

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String editEvent( @PathVariable("id") Long id) {
        //service get info and type
        return "layout";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String createEvent(@RequestBody Event event) {
        //service create event
        return "redirect:dashboard/dashboard-main";
    }

}
