package com.vyira.vyirasuite.quizserver.impl;

import com.vyira.vyirasuite.quizserver.models.Question;
import com.vyira.vyirasuite.quizserver.models.User;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
public class QuizServerImpl implements Serializable {
    private final long serialUID = 1L;

    public User getUser() {
        return null;
    }

    public void addUser(User user) {

    }

    public Question getQuestion(String id) {
        return null;
    }

    public List<Question> getQuestions(String id) {
        return null;
    }
}
