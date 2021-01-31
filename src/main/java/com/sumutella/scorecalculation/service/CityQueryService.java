package com.sumutella.scorecalculation.service;

import com.sumutella.scorecalculation.domain.City;

public interface CityQueryService {
    Integer getCityScore(Integer cityTrafficCode);
    City getCity(Integer cityTrafficCode);
}
