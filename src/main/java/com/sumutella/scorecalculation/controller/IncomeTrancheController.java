package com.sumutella.scorecalculation.controller;

import com.sumutella.scorecalculation.service.DomainValueQueryService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/scorecalculation")
@Api(value = "income-tranche-controller-api")
public class IncomeTrancheController {
    private final DomainValueQueryService domainValueQueryService;

    public IncomeTrancheController(DomainValueQueryService domainValueQueryService) {
        this.domainValueQueryService = domainValueQueryService;
    }


    @GetMapping("/incometranche")
    public Integer getIncomeTrancheFactor(Integer incomeTrancheCode) {
        return domainValueQueryService.getIncomeTranche(incomeTrancheCode).getIncomeTrancheFactor();
    }
}
