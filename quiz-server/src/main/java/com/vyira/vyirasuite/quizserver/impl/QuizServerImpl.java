package com.vyira.vyirasuite.quizserver.impl;

import com.google.common.base.Strings;
import com.vyira.vyirasuite.quizserver.models.Question;
import com.vyira.vyirasuite.quizserver.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class QuizServerImpl {
    MongoTemplate mongoTemplate;

    public User getUser() {
        return null;
    }

    public void addUser(User user) {

    }

    public Question getQuestion(String id) {
        if (Strings.isNullOrEmpty(id)) {
            Query query = new Query();
            query.addCriteria(Criteria.where("_id").is(id));
            return mongoTemplate.findOne(query, Question.class);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public List<Question> getQuestions(String id) {
        return null;
    }
}
