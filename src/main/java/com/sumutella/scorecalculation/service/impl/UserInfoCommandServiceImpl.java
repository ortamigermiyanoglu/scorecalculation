package com.sumutella.scorecalculation.service.impl;

import com.sumutella.scorecalculation.domain.UserInfo;
import com.sumutella.scorecalculation.repository.UserInfoRepository;
import com.sumutella.scorecalculation.service.UserInfoCommandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserInfoCommandServiceImpl implements UserInfoCommandService {
    private final UserInfoRepository userInfoRepository;

    public UserInfoCommandServiceImpl(UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }

    @Override
    public UserInfo createUserInfo(UserInfo userInfo) {
        UserInfo savedUserInfo = userInfoRepository.save(userInfo);
        log.info("User with info" + savedUserInfo + " created");
        return savedUserInfo;
    }
}
