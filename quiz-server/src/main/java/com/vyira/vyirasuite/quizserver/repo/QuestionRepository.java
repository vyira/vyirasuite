package com.vyira.vyirasuite.quizserver.repo;

import com.vyira.vyirasuite.quizserver.models.Question;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends MongoRepository<Question, String> {
}
