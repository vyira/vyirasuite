package com.vyira.vyirasuite.quizserver.models;

import com.vyira.vyirasuite.quizserver.enums.DBCollections;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(value = DBCollections.USERS)
public class User implements Serializable {

    private static final long serialVersionUID = -6698899816867317333L;

    @Id
    String id;
    String name;
    LocalDate dob;
    LocalDateTime createdAt;
    String gender;
    @Indexed(unique = true)
    String email;
    String phone;
    boolean consoleAccess;
}
