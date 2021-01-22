package com.vyira.vyirasuite.quizserver.impl;

import com.google.common.base.Strings;
import com.vyira.vyirasuite.quizserver.exceptions.NotFoundException;
import com.vyira.vyirasuite.quizserver.models.Question;
import com.vyira.vyirasuite.quizserver.models.Quiz;
import com.vyira.vyirasuite.quizserver.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class QuizServerImpl {
    MongoOperations mongoOperations;

    public User getUser() {
        return null;
    }

    public void addUser(User user) {
    }

    public Question getQuestion(String id) {
        if (Strings.isNullOrEmpty(id)) {
            Query query = new Query();
            query.addCriteria(Criteria.where("_id").is(id));
            return mongoOperations.findOne(query, Question.class);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public List<Question> getQuestions(String quizId) throws NotFoundException {
        Query quizQuery = new Query(Criteria.where("_id").is(quizId));
        Quiz quiz = mongoOperations.findOne(quizQuery, Quiz.class);
        List<String> questionIdList;
        if (quiz != null) {
            questionIdList = quiz.getQuestionIds();
            Query questionQuery = new Query(Criteria.where("_is").all(questionIdList));
            return mongoOperations.find(questionQuery, Question.class);
        } else {
            throw new NotFoundException(String.format("Error in Finding Questions for quizId = %s", quizId));
        }
    }
}
