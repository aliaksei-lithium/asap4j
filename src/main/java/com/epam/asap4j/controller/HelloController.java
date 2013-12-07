package com.epam.asap4j.controller;

import com.epam.asap4j.dao.PersonDao;
import com.epam.asap4j.dto.Person;
import com.epam.asap4j.service.UpsaRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.math.BigInteger;

@Controller
@RequestMapping("/")
public class HelloController {

    @Autowired
    private PersonDao personDao;

    @Autowired
    private UpsaRestService restService;

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        Person employee = personDao.getEntityById(BigInteger.valueOf(271118));
        model.addAttribute("message", "Hello " + employee.toString());
        model.addAttribute("loc", restService.getLocation(BigInteger.valueOf(271118)));
        return "hello";
    }
}