package com.sumutella.scorecalculation.service.impl;

import com.sumutella.scorecalculation.domain.UserInfo;
import com.sumutella.scorecalculation.repository.UserInfoRepository;
import com.sumutella.scorecalculation.service.UserInfoQueryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UserInfoQueryServiceImpl implements UserInfoQueryService {
    private final UserInfoRepository userInfoRepository;

    public UserInfoQueryServiceImpl(UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }

    @Override
    public UserInfo getUserInfo(Long identityNumber) {
        Optional<UserInfo> optionalUserInfo = userInfoRepository.getUserInfoByUserIdentityNumber(identityNumber);
        if (optionalUserInfo.isPresent()){
            return optionalUserInfo.get();
        }
        return null;
    }
}
