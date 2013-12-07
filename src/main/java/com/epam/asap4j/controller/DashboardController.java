package com.epam.asap4j.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class DashboardController {

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "redirect:dashboard";
    }

    @RequestMapping(value = "dashboard", method = RequestMethod.GET)
    public String getDashboard() {
        return "dashboard/dashboard-main";
    }

    @RequestMapping(value = "accident", method = RequestMethod.GET)
    public String submitAccident() {
        return "events/event-accident-main";
    }

    @RequestMapping(value = "wish", method = RequestMethod.GET)
    public String submitWish() {
        return "events/event-wishlist-main";
    }

    @RequestMapping(value = "groups", method = RequestMethod.GET)
    public String getGroups() {
        return "groups/groups-list-main";
    }

}
