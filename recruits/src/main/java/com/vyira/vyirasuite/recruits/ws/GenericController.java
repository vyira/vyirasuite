package com.vyira.vyirasuite.recruits.ws;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class GenericController {

    @ResponseBody
    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping("api/${api.version}/test")
    public String successTestResponse() {
        return "Success";
    }
}
