package com.sumutella.scorecalculation.service.impl;

import com.sumutella.scorecalculation.domain.City;
import com.sumutella.scorecalculation.dto.IdCodeDisplayValueDTO;
import com.sumutella.scorecalculation.repository.CityRepository;
import com.sumutella.scorecalculation.service.CityQueryService;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class CityQueryServiceImpl implements CityQueryService {
    private final CityRepository cityRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CityQueryServiceImpl(CityRepository cityRepository, ModelMapper modelMapper) {
        this.cityRepository = cityRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Integer getCityScore(Integer cityTrafficCode) {
        return null;
    }

    @Override
    public City getCity(Integer cityTrafficCode) {
        Optional<City> optionalCity = cityRepository.findByTrafficCode(cityTrafficCode);
        if (optionalCity.isPresent()) {
            return optionalCity.get();
        }
        return null;
    }

    @Override
    public List<IdCodeDisplayValueDTO> getAllCities() {
        PropertyMap<City, IdCodeDisplayValueDTO> citiesMap = new PropertyMap<City, IdCodeDisplayValueDTO>() {
            protected void configure() {
                map().setDisplayValue(source.getName());
            }
        };
        modelMapper.addMappings(citiesMap);
        List<City> cities = cityRepository.findAll();
        return cities.stream().map(city -> modelMapper.map(city, IdCodeDisplayValueDTO.class)).collect(Collectors.toList());
    }


}
