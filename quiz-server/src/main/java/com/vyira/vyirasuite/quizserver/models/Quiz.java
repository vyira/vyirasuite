package com.vyira.vyirasuite.quizserver.models;

import com.vyira.vyirasuite.quizserver.enums.DBCollections;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(value = DBCollections.QUIZ_LIST)
public class Quiz implements Serializable {
    private static final long serialVersionUID = -3394779289727820256L;

    @Id
    public String id;
    public String quizName;
    public String description;
    public List<String> questionIds;
    public Date startTime;
    public long duration;
    public String createdBy;
    public Date createdAt;
    public Date lastModified;
    public boolean active;
}
