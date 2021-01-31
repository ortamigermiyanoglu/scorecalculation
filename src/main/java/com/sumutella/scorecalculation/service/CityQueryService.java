package com.sumutella.scorecalculation.service;

import com.sumutella.scorecalculation.domain.City;
import com.sumutella.scorecalculation.dto.IdCodeDisplayValueDTO;

import java.util.List;

public interface CityQueryService {
    Integer getCityScore(Integer cityTrafficCode);

    City getCity(Integer cityTrafficCode);

    List<IdCodeDisplayValueDTO> getAllCities();
}
