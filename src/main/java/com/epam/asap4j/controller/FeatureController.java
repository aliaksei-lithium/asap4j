package com.epam.asap4j.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/features")
public class FeatureController {

    @RequestMapping(method = RequestMethod.GET)
    public String doIt() {
        return "layout";
    }

}
