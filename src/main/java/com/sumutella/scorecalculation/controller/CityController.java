package com.sumutella.scorecalculation.controller;

import com.sumutella.scorecalculation.request.CalculateCityScoreRequest;
import com.sumutella.scorecalculation.service.CityScoreQueryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/scorecalculation")
public class CityController {
    private final CityScoreQueryService cityScoreQueryService;

    public CityController(CityScoreQueryService cityScoreQueryService) {
        this.cityScoreQueryService = cityScoreQueryService;
    }


    @GetMapping("/cities")
    public Integer getCityScore(CalculateCityScoreRequest calculateCityScoreRequest) {
        return cityScoreQueryService.getCityScore(calculateCityScoreRequest.getTrafficCode());
    }
}
