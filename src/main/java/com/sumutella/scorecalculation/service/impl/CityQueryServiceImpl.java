package com.sumutella.scorecalculation.service.impl;

import com.sumutella.scorecalculation.domain.City;
import com.sumutella.scorecalculation.repository.CityRepository;
import com.sumutella.scorecalculation.service.CityQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class CityQueryServiceImpl implements CityQueryService {
    private final CityRepository cityRepository;

    @Autowired
    public CityQueryServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public Integer getCityScore(Integer cityTrafficCode) {
        return null;
    }

    @Override
    public City getCity(Integer cityTrafficCode) {
        Optional<City> optionalCity = cityRepository.findByTrafficCode(cityTrafficCode);
        if (optionalCity.isPresent()){
            return optionalCity.get();
        }
        return null;
    }
}
