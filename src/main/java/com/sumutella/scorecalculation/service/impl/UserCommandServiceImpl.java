package com.sumutella.scorecalculation.service.impl;

import com.sumutella.scorecalculation.domain.City;
import com.sumutella.scorecalculation.domain.DomainValue;
import com.sumutella.scorecalculation.domain.User;
import com.sumutella.scorecalculation.domain.UserInfo;
import com.sumutella.scorecalculation.dto.CreateUserDTO;
import com.sumutella.scorecalculation.repository.DomainValueRepository;
import com.sumutella.scorecalculation.repository.UserRepository;
import com.sumutella.scorecalculation.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
public class UserCommandServiceImpl implements UserCommandService {
    private final UserRepository userRepository;
    private final UserQueryService userQueryService;
    private final UserInfoQueryService userInfoQueryService;
    private final UserInfoCommandService userInfoCommandService;
    private final CityQueryService cityQueryService;
    private final DomainValueQueryService domainValueQueryService;

    @Autowired
    public UserCommandServiceImpl(UserRepository userRepository, DomainValueRepository domainValueRepository, UserInfoQueryService userInfoQueryService, DomainValueQueryService domainValueQueryService, UserQueryService userQueryService, CityQueryService cityQueryService, UserInfoCommandService userInfoCommandService) {
        this.userRepository = userRepository;
        this.userInfoQueryService = userInfoQueryService;
        this.domainValueQueryService = domainValueQueryService;
        this.userQueryService = userQueryService;
        this.cityQueryService = cityQueryService;
        this.userInfoCommandService = userInfoCommandService;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
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
        return savedUserInfo.getUser().getId();

    }

    @Override
    public Boolean updateUserScores(Long userIdentityNumber, Integer cityScore, Integer scoreSegment) {
        UserInfo userInfo= userInfoQueryService.getUserInfo(userIdentityNumber);
        if (Objects.nonNull(userInfo)){
            userInfo.setCityScore(cityScore);
            userInfo.setScoreSegment(scoreSegment);
            UserInfo savedUserInfo = userInfoCommandService.createUserInfo(userInfo);
            log.info("user city score and score segment updated:" + savedUserInfo);
            return true;
        }
        log.info("user with " + userIdentityNumber + " not found");
        return false;
    }


}
