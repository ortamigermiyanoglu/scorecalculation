package com.sumutella.scorecalculation.repository;

import com.sumutella.scorecalculation.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Boolean existsByIdentityNumber(Long userIdentityNumber);

    Optional<User> findByIdentityNumber(Long userIdentityNumber);
}
