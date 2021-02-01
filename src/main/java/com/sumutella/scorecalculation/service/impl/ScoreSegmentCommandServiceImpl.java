package com.sumutella.scorecalculation.service.impl;

import com.sumutella.scorecalculation.domain.ScoreSegment;
import com.sumutella.scorecalculation.repository.ScoreSegmentRepository;
import com.sumutella.scorecalculation.service.ScoreSegmentCommandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

@Service
@Slf4j
public class ScoreSegmentCommandServiceImpl implements ScoreSegmentCommandService {
    private final ScoreSegmentRepository scoreSegmentRepository;

    public ScoreSegmentCommandServiceImpl(ScoreSegmentRepository scoreSegmentRepository) {
        this.scoreSegmentRepository = scoreSegmentRepository;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void calculateScoreSegment(Long userIdentityNumber, Integer incomeTrancheCode) {
        ScoreSegment scoreSegment;
        if (scoreSegmentRepository.existsByIdentityNumber(userIdentityNumber)) {
            scoreSegment = scoreSegmentRepository.findByIdentityNumber(userIdentityNumber);
        } else {
            scoreSegment = new ScoreSegment();
        }

        Random r = new Random();
        Integer score = incomeTrancheCode > 3 ? r.nextInt((4) + 5) : r.nextInt((4)) + 1;

        scoreSegment.setIdentityNumber(userIdentityNumber);
        scoreSegment.setScore(score);
        ScoreSegment savedScore = scoreSegmentRepository.save(scoreSegment);
        log.info(savedScore + " created/updated");
    }
}
