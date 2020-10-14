package com.vyira.vyirasuite.quizserver.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Quiz {
    @Id
    public String id;
    public String quizName;
    public String[] questionIds;
    public String description;
    public Date startTime;
    public long duration;
    public String createdBy;
    public Date createdAt;
    public Date lastModified;
}
