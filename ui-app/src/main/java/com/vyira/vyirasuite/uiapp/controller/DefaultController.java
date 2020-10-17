package com.vyira.vyirasuite.uiapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DefaultController {
    private final Logger Log = LoggerFactory.getLogger(DefaultController.class);

    @RequestMapping("/")
    public ModelAndView index() {
        Log.debug("Root Page Requested");
        return new ModelAndView("index.html");
    }
}