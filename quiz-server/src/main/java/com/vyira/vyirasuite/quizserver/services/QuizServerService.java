package com.vyira.vyirasuite.quizserver.services;

import com.vyira.vyirasuite.quizserver.exceptions.NotFoundException;
import com.vyira.vyirasuite.quizserver.impl.QuizServerImpl;
import com.vyira.vyirasuite.quizserver.models.Question;
import com.vyira.vyirasuite.quizserver.models.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class QuizServerService {
    QuizServerImpl quizServer;

    @Autowired
    public QuizServerService(QuizServerImpl quizServer) {
        this.quizServer = quizServer;
    }

    public User getUser(String id) {
        log.debug(String.format("getUser(%s)", id));
        return quizServer.getUser(id);
    }

    public HttpStatus addUser(User user) {
        log.debug(String.format("addUser: %s", user.toString()));
        HttpStatus status = quizServer.addUser(user);
        log.info("Add User: " + status);
        return status;
    }

    public Question getQuestion(String id) {
        log.debug(String.format("getQuestion(%s)", id));
        return quizServer.getQuestion(id);
    }

    public Object getQuestions(String quizId) {
        log.debug(String.format("getQuestions(%s)", quizId));
        try {
            return quizServer.getQuestions(quizId);
        } catch (NotFoundException e) {
            return new ResponseEntity<Object>("Error is Processing request", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public HttpStatus saveQuestion(Object obj) {
        return quizServer.saveQuestion((Question) obj);
    }
}
