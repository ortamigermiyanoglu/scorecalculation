package com.sumutella.scorecalculation.controller;

import com.sumutella.scorecalculation.request.CalculateScoreSegmentRequest;
import com.sumutella.scorecalculation.service.ScoreSegmentQueryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/scorecalculation")
public class ScoreSegmentController {
    private final ScoreSegmentQueryService scoreSegmentQueryService;

    public ScoreSegmentController(ScoreSegmentQueryService scoreSegmentQueryService) {
        this.scoreSegmentQueryService = scoreSegmentQueryService;
    }

    @GetMapping("/scoresegment")
    public Integer getScoreSegment(@RequestBody @Valid CalculateScoreSegmentRequest calculateScoreSegmentRequest) {
        return scoreSegmentQueryService.getUserScoreSegment(calculateScoreSegmentRequest.getUserIdentityNumber());
    }

}
