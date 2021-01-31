package com.sumutella.scorecalculation.service;

import com.sumutella.scorecalculation.domain.UserInfo;

public interface UserInfoQueryService {
    UserInfo getUserInfo(Long identityNumber);
}
