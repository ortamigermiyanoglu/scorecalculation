package com.sumutella.scorecalculation.service.impl;

import com.sumutella.scorecalculation.domain.City;
import com.sumutella.scorecalculation.domain.DomainValue;
import com.sumutella.scorecalculation.domain.User;
import com.sumutella.scorecalculation.domain.UserInfo;
import com.sumutella.scorecalculation.dto.CreateUserDTO;
import com.sumutella.scorecalculation.repository.UserRepository;
import com.sumutella.scorecalculation.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class UserCommandServiceImpl implements UserCommandService {
    private final UserRepository userRepository;
    private final UserQueryService userQueryService;
    private final UserInfoQueryService userInfoQueryService;
    private final UserInfoCommandService userInfoCommandService;
    private final CityQueryService cityQueryService;
    private final DomainValueQueryService domainValueQueryService;
    private final ScoreSegmentCommandService scoreSegmentCommandService;

    @Autowired
    public UserCommandServiceImpl(UserRepository userRepository, UserInfoQueryService userInfoQueryService, DomainValueQueryService domainValueQueryService, UserQueryService userQueryService, CityQueryService cityQueryService, UserInfoCommandService userInfoCommandService, ScoreSegmentCommandService scoreSegmentCommandService) {
        this.userRepository = userRepository;
        this.userInfoQueryService = userInfoQueryService;
        this.domainValueQueryService = domainValueQueryService;
        this.userQueryService = userQueryService;
        this.cityQueryService = cityQueryService;
        this.userInfoCommandService = userInfoCommandService;
        this.scoreSegmentCommandService = scoreSegmentCommandService;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Long createUpdateUser(CreateUserDTO createUserDTO) {
        Boolean isUserExists = userQueryService.isUserExists(createUserDTO.getUserIdentityNumber());
        UserInfo userInfo;
        User user;

        if (!isUserExists){
            user = new User();
            userInfo = new UserInfo();
        } else {
            userInfo = userInfoQueryService.getUserInfo(createUserDTO.getUserIdentityNumber());
            user = userQueryService.getUser(createUserDTO.getUserIdentityNumber());
        }
        user.setName(createUserDTO.getUserName());
        user.setSurname(createUserDTO.getUserSurname());
        user.setIdentityNumber(createUserDTO.getUserIdentityNumber());
        user.setPhoneNumber(createUserDTO.getUserPhoneNumber());

        User savedUser = userRepository.save(user);
        City userCity = cityQueryService.getCity(createUserDTO.getCityTrafficCode());
        DomainValue incomeTranche = domainValueQueryService.getIncomeTranche(createUserDTO.getIncomeTrancheCode());

        userInfo.setUser(savedUser);
        userInfo.setCity(userCity);
        userInfo.setIncomeTranche(incomeTranche);


        UserInfo savedUserInfo = userInfoCommandService.createUserInfo(userInfo);
        scoreSegmentCommandService.calculateScoreSegment(user.getIdentityNumber(), incomeTranche.getCode());
        log.info(savedUserInfo + " created/updated");
        return savedUserInfo.getUser().getId();

    }



}
