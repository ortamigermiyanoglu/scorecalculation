package com.sumutella.scorecalculation.controller;

import com.sumutella.scorecalculation.service.ScoreSegmentQueryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public Integer getScoreSegment(@RequestParam @Valid Long userIdentityNumber) {
        return scoreSegmentQueryService.getUserScoreSegment(userIdentityNumber);
    }

}
