package com.vyira.vyirasuite.quizserver.ws;

import com.vyira.vyirasuite.quizserver.models.User;
import com.vyira.vyirasuite.quizserver.services.QuizServerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController("api/${api.version}/")
public class QuizController {

    QuizServerService service;

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable String id) {
        log.debug("getUser: " + id);
        return service.getUser(id);
    }

    @PostMapping(value = "/user/add", produces = "application/json")
    public void addUser(@RequestBody User user) {
        log.debug("adding user + " + user.toString());
        service.addUser(user);
    }

    @DeleteMapping(path = "/user/{id}")
    public void deleteUser(@PathVariable String id) {
        log.debug("Deleting User with user id: " + id);
    }
}
