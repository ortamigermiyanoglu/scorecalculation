package com.sumutella.scorecalculation.service.impl;

import com.sumutella.scorecalculation.domain.CityScore;
import com.sumutella.scorecalculation.repository.CityScoreRepository;
import com.sumutella.scorecalculation.service.CityScoreQueryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class CityScoreQueryServiceImpl implements CityScoreQueryService {
    private final CityScoreRepository cityScoreRepository;

    public CityScoreQueryServiceImpl(CityScoreRepository cityScoreRepository) {
        this.cityScoreRepository = cityScoreRepository;
    }

    @Override
    public Integer getCityScore(Integer cityTrafficCode) {
        Optional<CityScore> optionalCityScore = cityScoreRepository.findByTrafficCode(cityTrafficCode);
        if (optionalCityScore.isPresent()) {
            return optionalCityScore.get().getScore();
        }
        return 0;
    }
}
