package com.vyira.vyirasuite.recruits.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Recruit {
    @Id
    public String id;
    public String fName;
    public String mName;
    public String lName;
    public String fullName;
    public String email;
    public Phone[] phones;
    public RecruitAddress[] addresses;
    public Date joiningDate;
    public Date birthday;
    public String aadhaarNo;
    public String[] languages;
}
