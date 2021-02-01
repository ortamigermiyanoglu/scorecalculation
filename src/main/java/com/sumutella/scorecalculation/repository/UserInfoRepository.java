package com.sumutella.scorecalculation.repository;

import com.sumutella.scorecalculation.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
    Optional<UserInfo> getUserInfoByUserIdentityNumber(Long userIdentityNumber);
}
