package com.vyira.vyirasuite.quizserver.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Question implements Serializable {
    private final long serialUID = 1L;

    @Id
    public String id;
    public String questionText;
    public List<Answer> answers;
    public int score;
    public Difficulty difficulty;

    public enum Difficulty{
        EASY,
        NORMAL,
        HARD,
        INSANE
    }
}
