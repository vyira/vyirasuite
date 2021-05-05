package com.vyira.vyirasuite.quizserver.impl;

import com.google.common.base.Strings;
import com.vyira.vyirasuite.quizserver.enums.DBCollections;
import com.vyira.vyirasuite.quizserver.exceptions.NotFoundException;
import com.vyira.vyirasuite.quizserver.models.History;
import com.vyira.vyirasuite.quizserver.models.Question;
import com.vyira.vyirasuite.quizserver.models.Quiz;
import com.vyira.vyirasuite.quizserver.models.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.util.ObjectUtils.isEmpty;

@Slf4j
@Component
@RequiredArgsConstructor
public class QuizServerImpl {
    MongoOperations mongoOperations;
    String errorMessage;

    @Autowired
    public QuizServerImpl(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    public User getUser(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        List<User> userList = mongoOperations.find(query, User.class);
        User user = userList.get(0);
        History history = new History.HistoryBuilder()
                .setCode("1000")
                .setEventType("FETCH_USER")
                .setDescription(String.format("Get Request received for user id %s", id))
                .setCreateDate(LocalDateTime.now())
                .build();
        mongoOperations.save(history, DBCollections.HISTORY_EVENT);
        log.info("User details: " + user.toString());
        return user;
    }

    public HttpStatus addUser(User user) {
        if (isValidUser(user)) {
            user.setCreatedAt(LocalDateTime.now());
            User temp_user = mongoOperations.save(user, DBCollections.USERS);
            log.info("User Added: " + temp_user);
            return HttpStatus.ACCEPTED;
        }
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }

    private boolean isValidUser(User user) {
        String errorMessage = null;
        if (!StringUtils.isNotEmpty(user.getName())) {
            errorMessage = "Name cannot be empty";
        }
        if (!StringUtils.isNotEmpty(user.getEmail())) {
            errorMessage = "Email cannot be empty";
        }
        if (!StringUtils.isNotEmpty(user.getPhone())) {
            errorMessage = "Phone cannot be empty";
        }
        if (!StringUtils.isNotEmpty(user.getGender())) {
            errorMessage = "Gender cannot be empty";
        }
        if (user.getDob() == null || isEmpty(user.getDob())) {
            errorMessage = "DOB cannot be empty";
        }
        if (StringUtils.isEmpty(errorMessage)) {
            return true;
        } else {
            log.error("Invalid User Object: " + errorMessage);
            return true;
        }
    }

    public Question getQuestion(String id) {
        if (!Strings.isNullOrEmpty(id)) {
            Query query = new Query();
            query.addCriteria(Criteria.where("_id").is(id));
            return mongoOperations.findOne(query, Question.class);
        } else {
            log.error(String.format("Cannot find question with id %s", id));
        }
        return null;
    }

    public HttpStatus saveQuestion(Question question) {
        Question temp = mongoOperations.save(question, DBCollections.QUESTIONS);
        if (Strings.isNullOrEmpty(temp.id)) {
            log.error("Save Failed", temp);
        } else {
            return HttpStatus.CREATED;
        }
        return HttpStatus.INTERNAL_SERVER_ERROR;
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
