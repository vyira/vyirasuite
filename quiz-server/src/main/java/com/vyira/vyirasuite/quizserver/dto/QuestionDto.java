package com.vyira.vyirasuite.quizserver.dto;

import com.vyira.vyirasuite.quizserver.models.Answer;
import com.vyira.vyirasuite.quizserver.models.Question;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
public class QuestionDto implements Serializable {
    private static final long serialVersionUID = -2296965278559930676L;

    private String id;
    private String questionText;
    private List<Answer> answers;
    private int score;

    private QuestionDto convertToDto(Question question){
        QuestionDto questionDto = new QuestionDto();
        BeanUtils.copyProperties(question, questionDto);
        return questionDto;
    }
}
