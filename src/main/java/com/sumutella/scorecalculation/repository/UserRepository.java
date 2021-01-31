package com.sumutella.scorecalculation.repository;

import com.sumutella.scorecalculation.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Boolean existsByIdentityNumber(Long userIdentityNumber);
    Optional<User> findByIdentityNumber(Long userIdentityNumber);
}
