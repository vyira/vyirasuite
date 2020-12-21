package com.vyira.vyirasuite.quizserver.repo;

import com.vyira.vyirasuite.quizserver.models.Quiz;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepository extends MongoRepository<Quiz, String> {
}
