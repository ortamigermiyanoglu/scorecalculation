package com.sumutella.scorecalculation.service.impl;

import com.sumutella.scorecalculation.domain.User;
import com.sumutella.scorecalculation.model.UserCreateModel;
import com.sumutella.scorecalculation.repository.UserRepository;
import com.sumutella.scorecalculation.service.CityQueryService;
import com.sumutella.scorecalculation.service.DomainValueQueryService;
import com.sumutella.scorecalculation.service.UserQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UserQueryServiceImpl implements UserQueryService {
    private final UserRepository userRepository;
    private final DomainValueQueryService domainValueQueryService;
    private final CityQueryService cityQueryService;

    @Autowired
    public UserQueryServiceImpl(UserRepository userRepository, DomainValueQueryService domainValueQueryService, CityQueryService cityQueryService) {
        this.userRepository = userRepository;
        this.domainValueQueryService = domainValueQueryService;
        this.cityQueryService = cityQueryService;
    }

    @Override
    public User getUser(Long identityNumber) {
        Optional<User> optionalUser = userRepository.findByIdentityNumber(identityNumber);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        }
        return null;
    }

    @Override
    public Boolean isUserExists(Long IdentityNumber) {
        return userRepository.existsByIdentityNumber(IdentityNumber);
    }

    @Override
    public UserCreateModel getUserCreateModel() {
        UserCreateModel userCreateModel = new UserCreateModel();
        userCreateModel.setIncomeTranches(domainValueQueryService.getAllIncomeTranches("INCOME_TRANCHES"));
        userCreateModel.setCities(cityQueryService.getAllCities());
        return userCreateModel;
    }
}
