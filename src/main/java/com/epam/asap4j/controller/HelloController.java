package com.epam.asap4j.controller;

import com.epam.asap4j.dao.PersonDao;
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
/*
        Employee employee = new Employee(null,"Arkadiy Dobkin",123L);

        Long id = personDao.addEntity(employee);

        employee = personDao.getEntityById(id);
        System.out.println(employee);

        employee.setName("Andrei");
        personDao.updateEntity(employee);

        employee = personDao.getEntityById(id);
 */
        model.addAttribute("message", "Hello ");
        model.addAttribute("loc", restService.getLocation(BigInteger.valueOf(271118)));
        return "hello";
    }
}