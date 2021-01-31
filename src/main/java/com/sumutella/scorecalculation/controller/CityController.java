package com.sumutella.scorecalculation.controller;

import com.sumutella.scorecalculation.request.CalculateCityScoreRequest;
import com.sumutella.scorecalculation.service.CityQueryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/scorecalculation")
public class CityController {
    private final CityQueryService cityQueryService;

    public CityController(CityQueryService cityQueryService) {
        this.cityQueryService = cityQueryService;
    }

    @GetMapping("/cities")
    public Integer getCityScore(CalculateCityScoreRequest calculateCityScoreRequest){
        return cityQueryService.getCityScore(calculateCityScoreRequest.getTrafficCode());
    }
}
