package com.vyira.vyirasuite.quizserver.ws;

import com.vyira.vyirasuite.quizserver.models.Question;
import com.vyira.vyirasuite.quizserver.models.User;
import com.vyira.vyirasuite.quizserver.services.QuizServerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/${api.version}/")
public class QuizController {

    QuizServerService service;

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable String id) {
        log.debug(String.format("getUser: %s", id));
        return service.getUser(id);
    }

    @PostMapping(value = "/user/add", produces = "application/json")
    public void addUser(@RequestBody User user) {
        log.debug(String.format("adding user + %s", user.toString()));
        service.addUser(user);
    }

    @DeleteMapping(path = "/user/{id}")
    public void deleteUser(@PathVariable String id) {
        log.debug(String.format("Deleting User with user id: %s", id));
    }

    @GetMapping("/question/{id}")
    public Question getQuestion(@PathVariable String id) {
        log.debug(String.format("Fetching Question for Quiz Id: %s", id));
        return service.getQuestion(id);
    }
}
