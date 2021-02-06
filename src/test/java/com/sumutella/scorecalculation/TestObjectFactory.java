package com.sumutella.scorecalculation;

import com.sumutella.scorecalculation.domain.*;
import com.sumutella.scorecalculation.dto.CreateUserDTO;

import java.util.Random;

public class TestObjectFactory {

    public static DomainValue incomeTranche() {
        DomainValue incomeTranche = new DomainValue();
        incomeTranche.setCode(1);
        incomeTranche.setIncomeTrancheFactor(800);
        incomeTranche.setDomainValueType(domainValueType());
        return incomeTranche;
    }

    public static DomainValueType domainValueType() {
        DomainValueType domainValueType = new DomainValueType();
        domainValueType.setCode("INCOME_TRANCHES");
        domainValueType.setDescription("Gelir Dilimleri");
        return domainValueType;
    }

    public static CreateUserDTO createUserDTO() {
        CreateUserDTO createUserDTO = new CreateUserDTO();
        createUserDTO.setUserName("Semir");
        createUserDTO.setUserSurname("Kurt");
        createUserDTO.setIncomeTrancheCode(3);
        createUserDTO.setUserIdentityNumber(22906948011L);
        createUserDTO.setUserPhoneNumber(5373564105L);
        createUserDTO.setCityTrafficCode(31);
        return createUserDTO;
    }

    public static User user() {
        User user = new User();
        user.setName("Semir");
        user.setSurname("Kurt");
        user.setPhoneNumber(5373564105L);
        user.setIdentityNumber(22906948011L);
        return user;
    }


    public static UserInfo userInfo() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUser(user());
        userInfo.setCity(city());
        userInfo.setIncomeTranche(incomeTranche());
        return userInfo;
    }

    public static City city() {
        City city = new City();
        city.setName("Hatay");
        city.setTrafficCode(31);
        return city;
    }

    public static CityScore cityScore() {
        CityScore cityScore = new CityScore();
        cityScore.setScore(12000);
        cityScore.setCity(city());
        return cityScore;
    }


    public static ScoreSegment scoreSegment() {
        ScoreSegment scoreSegment = new ScoreSegment();
        Random r = new Random();
        Integer score = incomeTranche().getCode() > 3 ? r.nextInt((4) + 5) : r.nextInt((4)) + 1;
        scoreSegment.setScore(score);
        return scoreSegment;
    }


}
