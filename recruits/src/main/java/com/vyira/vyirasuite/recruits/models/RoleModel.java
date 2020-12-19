package com.vyira.vyirasuite.recruits.models;

import com.vyira.vyirasuite.recruits.roles.Roles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleModel {
    @Id
    public String id;
    public String userId;
    public Roles[] roles;
}
