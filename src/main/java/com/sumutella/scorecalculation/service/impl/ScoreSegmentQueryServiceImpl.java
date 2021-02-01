package com.sumutella.scorecalculation.service.impl;

import com.sumutella.scorecalculation.domain.ScoreSegment;
import com.sumutella.scorecalculation.repository.ScoreSegmentRepository;
import com.sumutella.scorecalculation.service.ScoreSegmentQueryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Transactional(readOnly = true)
public class ScoreSegmentQueryServiceImpl implements ScoreSegmentQueryService {
    private final ScoreSegmentRepository scoreSegmentRepository;

    public ScoreSegmentQueryServiceImpl(ScoreSegmentRepository scoreSegmentRepository) {
        this.scoreSegmentRepository = scoreSegmentRepository;
    }

    @Override
    public Integer getUserScoreSegment(Long userIdentityNumber) {
        ScoreSegment scoreSegment = scoreSegmentRepository.findByIdentityNumber(userIdentityNumber);
        if (Objects.nonNull(scoreSegment)) {
            return scoreSegment.getScore();
        }
        return 0;
    }
}
