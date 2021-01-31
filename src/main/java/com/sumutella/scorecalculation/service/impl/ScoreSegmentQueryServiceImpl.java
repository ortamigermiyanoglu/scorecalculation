package com.sumutella.scorecalculation.service.impl;

import com.sumutella.scorecalculation.service.ScoreSegmentQueryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class ScoreSegmentQueryServiceImpl implements ScoreSegmentQueryService {
    @Override
    public Integer getUserScoreSegment(Long userIdentityNumber) {
        return null;
    }
}
