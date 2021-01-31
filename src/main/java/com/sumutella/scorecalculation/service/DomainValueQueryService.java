package com.sumutella.scorecalculation.service;

import com.sumutella.scorecalculation.domain.DomainValue;
import com.sumutella.scorecalculation.dto.IdCodeDisplayValueDTO;

import java.util.List;
import java.util.Optional;

public interface DomainValueQueryService {
    DomainValue getIncomeTranche(Integer incomeTrancheCode);
    List<IdCodeDisplayValueDTO> getAllIncomeTranches(String domainValueTypeCode);

}
