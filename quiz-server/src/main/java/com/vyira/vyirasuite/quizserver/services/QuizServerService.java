package com.vyira.vyirasuite.quizserver.services;

import com.vyira.vyirasuite.quizserver.impl.QuizServerImpl;
import com.vyira.vyirasuite.quizserver.models.Question;
import com.vyira.vyirasuite.quizserver.models.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class QuizServerService {
    QuizServerImpl quizServer;

    public User getUser(String id) {
        log.debug(String.format("getUser(%s)", id));
        return quizServer.getUser();
    }

    public void addUser(User user) {
        log.debug(String.format("addUser: %s", user.toString()));
        quizServer.addUser(user);
    }

    public Question getQuestion(String id) {
        log.debug(String.format("getQuestion(%s)", id));
        return quizServer.getQuestion(id);
    }

    public List<Question> getQuestions(String quizId) {
        log.debug(String.format("getQuestions(%s)", quizId));
        return quizServer.getQuestions(quizId);
    }
}
