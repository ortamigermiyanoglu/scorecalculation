package com.sumutella.scorecalculation.repository;

import com.sumutella.scorecalculation.domain.CityScore;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CityScoreRepository extends JpaRepository<CityScore, Long> {
    Optional<CityScore> findByTrafficCode(Integer cityTrafficCode);
}
