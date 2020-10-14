package com.vyira.vyirasuite.quizserver.models;

import lombok.Data;

@Data
public class Answer {
    public String id;
    public String answerText;
    public boolean correct;
}
