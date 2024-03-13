package com.pegien.HighSchoolExamination.Users.models.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
public class AssignRoleRequest {

    @NotNull(message = "You Have null roles")
    List<String> roles;


}
