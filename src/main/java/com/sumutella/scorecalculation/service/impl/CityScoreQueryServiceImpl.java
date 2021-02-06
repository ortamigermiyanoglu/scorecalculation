package com.sumutella.scorecalculation.service.impl;

import com.sumutella.scorecalculation.domain.City;
import com.sumutella.scorecalculation.domain.CityScore;
import com.sumutella.scorecalculation.repository.CityScoreRepository;
import com.sumutella.scorecalculation.service.CityQueryService;
import com.sumutella.scorecalculation.service.CityScoreQueryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class CityScoreQueryServiceImpl implements CityScoreQueryService {
    private final CityScoreRepository cityScoreRepository;
    private final CityQueryService cityQueryService;

    public CityScoreQueryServiceImpl(CityScoreRepository cityScoreRepository, CityQueryService cityQueryService) {
        this.cityScoreRepository = cityScoreRepository;
        this.cityQueryService = cityQueryService;
    }

    @Override
    public Integer getCityScore(Integer cityTrafficCode) {

        City city = cityQueryService.getCity(cityTrafficCode);

        Optional<CityScore> optionalCityScore = cityScoreRepository.findByCity(city);
        if (optionalCityScore.isPresent()) {
            return optionalCityScore.get().getScore();
        }
        return 0;
    }
}
