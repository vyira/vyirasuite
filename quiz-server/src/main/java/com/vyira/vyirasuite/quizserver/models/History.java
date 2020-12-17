package com.vyira.vyirasuite.quizserver.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class History implements Serializable {
    private final long serialUID = 1L;

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
