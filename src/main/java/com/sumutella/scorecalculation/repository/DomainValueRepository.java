package com.sumutella.scorecalculation.repository;

import com.sumutella.scorecalculation.domain.DomainValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DomainValueRepository extends JpaRepository<DomainValue, Long> {
    Optional<DomainValue> findDomainValueByCode(Integer code);

    List<DomainValue> findAllByDomainValueTypeCode(String domainValueTypeCode);
}
