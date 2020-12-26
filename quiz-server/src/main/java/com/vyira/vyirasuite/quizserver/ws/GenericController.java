package com.vyira.vyirasuite.quizserver.ws;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class GenericController {

    @ResponseBody
    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping("api/${api.version}/test")
    public String successTestResponse() {
        return "Success";
    }
}
