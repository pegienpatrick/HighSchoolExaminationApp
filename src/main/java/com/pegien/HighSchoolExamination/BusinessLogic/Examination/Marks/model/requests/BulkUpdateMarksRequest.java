package com.pegien.HighSchoolExamination.BusinessLogic.Examination.Marks.model.requests;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class BulkUpdateMarksRequest {

    private List<UpdateMarksRequest> marksList;


}
