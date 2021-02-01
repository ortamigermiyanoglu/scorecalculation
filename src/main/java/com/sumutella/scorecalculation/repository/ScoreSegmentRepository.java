package com.sumutella.scorecalculation.repository;

import com.sumutella.scorecalculation.domain.ScoreSegment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreSegmentRepository extends JpaRepository<ScoreSegment, Long> {
    Boolean existsByIdentityNumber(Long userIdentityNumber);

    ScoreSegment findByIdentityNumber(Long userIdentityNumber);
}
