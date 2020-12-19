package com.vyira.vyirasuite.quizserver.ws;

import com.vyira.vyirasuite.quizserver.models.Answer;
import com.vyira.vyirasuite.quizserver.models.Question;
import com.vyira.vyirasuite.quizserver.models.User;
import com.vyira.vyirasuite.quizserver.services.QuizServerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/${api.version}/")
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

    @GetMapping("/question/{id}")
    public Question getQuestion(@PathVariable String id) {
        Question q = new Question();
        q.setId(id);
        Answer ans = new Answer();
        List<Answer> answerList = new ArrayList<>();
        answerList.add(ans);
        q.setAnswers(answerList);
        return q;
    }
}
