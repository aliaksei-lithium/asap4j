package com.epam.asap4j.controller;

import com.epam.asap4j.dao.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HelloController {

    @Autowired
    private PersonDao personDao;

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
        System.out.println(employee);

		model.addAttribute("message", "Hello " + employee.getName());*/
		return "hello";
	}
}