package com.sumutella.scorecalculation.service;

import com.sumutella.scorecalculation.domain.User;
import com.sumutella.scorecalculation.model.UserCreateModel;

public interface UserQueryService {
    User getUser(Long identityNumber);

    Boolean isUserExists(Long IdentityNumber);

    UserCreateModel getUserCreateModel();
}
