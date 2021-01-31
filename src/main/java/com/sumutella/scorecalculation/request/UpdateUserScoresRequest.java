package com.sumutella.scorecalculation.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateUserScoresRequest {
    private Long userIdentityNumber;
    private Integer cityScore;
    private Integer scoreSegment;
}
