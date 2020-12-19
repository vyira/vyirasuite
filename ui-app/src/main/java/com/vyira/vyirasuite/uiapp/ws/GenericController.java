package com.vyira.vyirasuite.uiapp.ws;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GenericController {
    private final Logger Log = LoggerFactory.getLogger(GenericController.class);

    @RequestMapping("/")
    public ModelAndView index() {
        Log.debug("Root Page Requested");
        return new ModelAndView("index.html");
    }
}