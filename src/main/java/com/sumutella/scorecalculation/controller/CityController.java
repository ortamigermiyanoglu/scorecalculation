package com.sumutella.scorecalculation.controller;

import com.sumutella.scorecalculation.service.CityScoreQueryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/scorecalculation")
@Api(value = "city-controller-api")
public class CityController {
    private final CityScoreQueryService cityScoreQueryService;

    public CityController(CityScoreQueryService cityScoreQueryService) {
        this.cityScoreQueryService = cityScoreQueryService;
    }


    @GetMapping("/cities")
    @ApiOperation(value = "", notes = "get city score with traffic code parameter")
    public Integer getCityScore(@ApiParam(required = true) @RequestParam @Valid Integer cityTrafficCode) {
        return cityScoreQueryService.getCityScore(cityTrafficCode);
    }
}
