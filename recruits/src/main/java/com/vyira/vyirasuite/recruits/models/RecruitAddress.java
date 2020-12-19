package com.vyira.vyirasuite.recruits.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecruitAddress {
    @Id
    public String id;
    public String pinCode;
    public String state;
    public String city;
    public String addressLine1;
    public String addressLine2;
    public String nearby;
    public String country;
    public Type addressType;
    public enum Type{
        HOME,
        OFFICE,
        WORKSHOP
    }
}
