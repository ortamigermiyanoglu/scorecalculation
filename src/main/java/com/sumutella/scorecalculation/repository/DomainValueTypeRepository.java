package com.sumutella.scorecalculation.repository;

import com.sumutella.scorecalculation.domain.DomainValueType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomainValueTypeRepository extends JpaRepository<DomainValueType, Long> {
}
