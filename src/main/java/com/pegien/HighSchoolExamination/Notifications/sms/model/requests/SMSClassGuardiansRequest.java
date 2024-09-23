package com.pegien.HighSchoolExamination.Notifications.sms.model.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SMSClassGuardiansRequest {

    private Double stage;
    private String stream;
    private String message;

}
