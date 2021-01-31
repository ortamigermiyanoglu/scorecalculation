package com.sumutella.scorecalculation.service;

import com.sumutella.scorecalculation.domain.User;

public interface UserQueryService {
    User getUser(Long identityNumber);
    Boolean isUserExists(Long IdentityNumber);
}
