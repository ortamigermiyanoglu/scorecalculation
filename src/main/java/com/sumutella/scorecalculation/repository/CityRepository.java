package com.sumutella.scorecalculation.repository;

import com.sumutella.scorecalculation.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CityRepository  extends JpaRepository<City, Long> {
    Optional<City> findByTrafficCode(Integer cityTrafficCode);
}
