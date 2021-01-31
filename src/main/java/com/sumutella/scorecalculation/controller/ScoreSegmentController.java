package com.sumutella.scorecalculation.controller;

import com.sumutella.scorecalculation.request.CalculateScoreSegmentRequest;
import com.sumutella.scorecalculation.service.ScoreSegmentQueryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/scorecalculation")
public class ScoreSegmentController {
    private final ScoreSegmentQueryService scoreSegmentQueryService;

    public ScoreSegmentController(ScoreSegmentQueryService scoreSegmentQueryService) {
        this.scoreSegmentQueryService = scoreSegmentQueryService;
    }

    public Integer getScoreSegment(CalculateScoreSegmentRequest calculateScoreSegmentRequest){
        return scoreSegmentQueryService.getUserScoreSegment(calculateScoreSegmentRequest.getUserIdentityNumber());
    }

}
