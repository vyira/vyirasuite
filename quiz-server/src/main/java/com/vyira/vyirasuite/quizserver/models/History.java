package com.vyira.vyirasuite.quizserver.models;

import com.vyira.vyirasuite.quizserver.enums.DBCollections;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder(setterPrefix = "set")
@Document(value = DBCollections.HISTORY_EVENT)
public class History implements Serializable {

    private static final long serialVersionUID = 456306624001166709L;
    @Id
    String id;
    String eventType;
    String code;
    String description;
    String entityType;
    String entityId;

    @CreatedDate
    LocalDateTime createDate;
    @CreatedBy
    String createdBy;
}
