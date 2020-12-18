package com.vyira.vyirasuite.quizserver.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class User implements Serializable {
    private final long serialUID = 1L;

    @Id
    String id;
    String name;
    Date dob;
    @CreatedDate
    Date createdAt;
    String gender;
    String email;
    String phone;
    boolean consoleAccess;
}
