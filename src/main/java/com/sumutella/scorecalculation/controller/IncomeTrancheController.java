package com.sumutella.scorecalculation.controller;

import com.sumutella.scorecalculation.service.DomainValueQueryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Positive;


@RestController
@RequestMapping("/scorecalculation")
@Api(value = "income-tranche-controller-api")
public class IncomeTrancheController {
    private final DomainValueQueryService domainValueQueryService;

    public IncomeTrancheController(DomainValueQueryService domainValueQueryService) {
        this.domainValueQueryService = domainValueQueryService;
    }


    @GetMapping("/incometranche")
    @ApiOperation(value = "", notes = "get income tranche factor by income tranche code")
    public Integer getIncomeTrancheFactor(@ApiParam(required = true) @Valid @Positive Integer incomeTrancheCode) {
        return domainValueQueryService.getIncomeTranche(incomeTrancheCode).getIncomeTrancheFactor();
    }
}
