package com.vyira.vyirasuite.quizserver.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Question {
    @Id
    public String id;
    public String questionText;
    public Answer[] answers;
    public int score;
    public Difficulty difficulty;

    public enum Difficulty{
        EASY,
        NORMAL,
        HARD,
        INSANE
    }
}
