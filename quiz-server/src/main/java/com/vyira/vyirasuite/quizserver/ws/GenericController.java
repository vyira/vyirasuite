package com.vyira.vyirasuite.quizserver.ws;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/${api.version}/")
public class GenericController {

    /**
     * Generic API to talk with UI-component
     * @return String
     */
    @GetMapping("/polling/")
    public String polling(){
        return "Success";
    }

    // TODO: Create bunch of Generic Controller
}
