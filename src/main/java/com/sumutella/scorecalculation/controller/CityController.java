package com.sumutella.scorecalculation.controller;

import com.sumutella.scorecalculation.service.CityScoreQueryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/scorecalculation")
public class CityController {
    private final CityScoreQueryService cityScoreQueryService;

    public CityController(CityScoreQueryService cityScoreQueryService) {
        this.cityScoreQueryService = cityScoreQueryService;
    }


    @GetMapping("/cities")
    public Integer getCityScore(@RequestParam @Valid Integer cityTrafficCode) {
        return cityScoreQueryService.getCityScore(cityTrafficCode);
    }
}
