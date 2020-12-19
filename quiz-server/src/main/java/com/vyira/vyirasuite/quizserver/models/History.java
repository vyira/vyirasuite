package com.vyira.vyirasuite.quizserver.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "historyEvents")
public class History implements Serializable {

    @Id
    String id;
    String eventType;
    String code;
    String description;

    @CreatedDate
    Date createDate;
    @CreatedBy
    String createdBy;
}
