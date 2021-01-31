package com.sumutella.scorecalculation.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfiguration {
    private ModelMapper modelMapper = new ModelMapper();

    @Bean
    ModelMapper modelMapper() {
        return modelMapper;
    };
}

