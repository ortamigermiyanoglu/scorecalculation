package com.sumutella.scorecalculation.configuration;

import com.sumutella.scorecalculation.domain.City;
import com.sumutella.scorecalculation.domain.DomainValue;
import com.sumutella.scorecalculation.dto.IdCodeDisplayValueDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfiguration {
    private ModelMapper modelMapper = new ModelMapper();

    @Bean
    ModelMapper modelMapper() {
        PropertyMap<DomainValue, IdCodeDisplayValueDTO> incomeTrancheMap = new PropertyMap<DomainValue, IdCodeDisplayValueDTO>() {
            protected void configure() {
                map().setDisplayValue(source.getDescription());
            }
        };
        modelMapper.addMappings(incomeTrancheMap);

        PropertyMap<City, IdCodeDisplayValueDTO> citiesMap = new PropertyMap<City, IdCodeDisplayValueDTO>() {
            protected void configure() {
                map().setDisplayValue(source.getName());
            }
        };
        modelMapper.addMappings(citiesMap);


        return modelMapper;
    };
}

