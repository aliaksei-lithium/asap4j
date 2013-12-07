package com.epam.asap4j.controller;

import com.epam.asap4j.dao.EmployeeDao;
import com.epam.asap4j.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HelloController {

    @Autowired
    private EmployeeDao employeeDao;

	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {

        Employee employee = new Employee(null,"Arkadiy Dobkin",123L);

        Long id = employeeDao.addEntity(employee);

        employee = employeeDao.getEntityById(id);
        System.out.println(employee);

        employee.setName("Andrei");
        employeeDao.updateEntity(employee);

        employee = employeeDao.getEntityById(id);
        System.out.println(employee);

		model.addAttribute("message", "Hello " + employee.getName());
		return "hello";
	}
}