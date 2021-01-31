package com.sumutella.scorecalculation.repository;

import com.sumutella.scorecalculation.domain.DomainValue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DomainValueRepository extends JpaRepository<DomainValue, Long> {
    Optional<DomainValue> findDomainValueByCode(Integer code);
    List<DomainValue> findAllByDomainValueTypeCode(String domainValueTypeCode);
}
