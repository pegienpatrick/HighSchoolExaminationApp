package com.pegien.HighSchoolExamination.BusinessLogic.Notifications.sms.model.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SMSGuardiansRequest {

    private int admNo;
    private String message;

}
