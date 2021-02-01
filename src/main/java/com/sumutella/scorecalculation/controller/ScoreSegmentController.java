package com.sumutella.scorecalculation.controller;

import com.sumutella.scorecalculation.service.ScoreSegmentQueryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/scorecalculation")
@Api(value = "score-segment-controller-api")
public class ScoreSegmentController {
    private final ScoreSegmentQueryService scoreSegmentQueryService;

    public ScoreSegmentController(ScoreSegmentQueryService scoreSegmentQueryService) {
        this.scoreSegmentQueryService = scoreSegmentQueryService;
    }

    @GetMapping("/scoresegment")
    @ApiOperation(value = "", notes = "get user score segment with userIdentityNumber parameter")
    public Integer getScoreSegment(@ApiParam(required = true) @RequestParam @Valid Long userIdentityNumber) {
        return scoreSegmentQueryService.getUserScoreSegment(userIdentityNumber);
    }

}
