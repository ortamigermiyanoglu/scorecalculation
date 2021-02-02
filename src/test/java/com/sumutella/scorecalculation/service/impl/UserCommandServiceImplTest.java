package com.sumutella.scorecalculation.service.impl;

import com.sumutella.scorecalculation.TestObjectFactory;
import com.sumutella.scorecalculation.domain.User;
import com.sumutella.scorecalculation.domain.UserInfo;
import com.sumutella.scorecalculation.repository.UserRepository;
import com.sumutella.scorecalculation.service.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserCommandServiceImplTest {

    UserCommandServiceImpl service;
    @Mock
    private UserRepository userRepository;
    @Mock
    private UserQueryService userQueryService;
    @Mock
    private UserInfoQueryService userInfoQueryService;
    @Mock
    private UserInfoCommandService userInfoCommandService;
    @Mock
    private CityQueryService cityQueryService;
    @Mock
    private DomainValueQueryService domainValueQueryService;
    @Mock
    private ScoreSegmentCommandService scoreSegmentCommandService;

    @Before
    public void setUp() throws Exception {
        service = new UserCommandServiceImpl(userRepository, userInfoQueryService, domainValueQueryService, userQueryService, cityQueryService, userInfoCommandService, scoreSegmentCommandService);
    }

    @Test
    public void createUpdateUser() {

        Mockito.when(userQueryService.isUserExists(Mockito.anyLong())).thenReturn(false);
        Mockito.when(cityQueryService.getCity(Mockito.anyInt())).thenReturn(TestObjectFactory.city());
        Mockito.when(domainValueQueryService.getIncomeTranche(Mockito.anyInt())).thenReturn(TestObjectFactory.incomeTranche());
        Mockito.when(userInfoCommandService.createUserInfo(Mockito.any(UserInfo.class))).thenReturn(TestObjectFactory.userInfo());

        service.createUpdateUser(TestObjectFactory.createUserDTO());

        Mockito.verify(userRepository, Mockito.times(1)).save(Mockito.any(User.class));
        Mockito.verify(userInfoQueryService, Mockito.times(0)).getUserInfo(Mockito.anyLong());
    }
}