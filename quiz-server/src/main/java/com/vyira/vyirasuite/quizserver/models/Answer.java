package com.vyira.vyirasuite.quizserver.models;

import com.vyira.vyirasuite.quizserver.enums.DBCollections;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(value = DBCollections.ANSWERS)
public class Answer implements Serializable {

    private static final long serialVersionUID = -280792960633318722L;
    @Id
    public String id;
    public String answerText;
    public boolean correct;
}
