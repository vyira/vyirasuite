package com.vyira.vyirasuite.quizserver.services;

import com.vyira.vyirasuite.quizserver.models.User;
import org.springframework.stereotype.Service;

@Service
public class QuizServerService {
    public User getUser(String id){
        return new User();
    }

    public void addUser(Object user) {

    }
}
