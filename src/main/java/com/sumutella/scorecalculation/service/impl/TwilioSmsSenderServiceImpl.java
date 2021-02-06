package com.sumutella.scorecalculation.service.impl;

import com.sumutella.scorecalculation.configuration.TwilioConfiguration;
import com.sumutella.scorecalculation.domain.City;
import com.sumutella.scorecalculation.domain.DomainValue;
import com.sumutella.scorecalculation.domain.User;
import com.sumutella.scorecalculation.domain.UserInfo;
import com.sumutella.scorecalculation.request.SmsRequest;
import com.sumutella.scorecalculation.service.*;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TwilioSmsSenderServiceImpl implements TwilioSmsSenderService {
    private final UserInfoQueryService userInfoQueryService;
    private final ScoreSegmentQueryServiceImpl scoreSegmentQueryService;
    private final TwilioConfiguration twilioConfiguration;
    private final MessageCommandService messageCommandService;
    private final DomainValueQueryService domainValueQueryService;
    private final CityScoreQueryService cityScoreQueryService;

    @Autowired
    public TwilioSmsSenderServiceImpl(UserInfoQueryService userInfoQueryService, ScoreSegmentQueryServiceImpl scoreSegmentQueryService, TwilioConfiguration twilioConfiguration, MessageCommandService messageCommandService, DomainValueQueryService domainValueQueryService, CityScoreQueryService cityScoreQueryService) {
        this.userInfoQueryService = userInfoQueryService;
        this.scoreSegmentQueryService = scoreSegmentQueryService;
        this.twilioConfiguration = twilioConfiguration;
        this.messageCommandService = messageCommandService;
        this.domainValueQueryService = domainValueQueryService;
        this.cityScoreQueryService = cityScoreQueryService;
    }

    @Override
    public void sendSms(SmsRequest smsRequest) {
        UserInfo userInfo = userInfoQueryService.getUserInfo(smsRequest.getUserIdentityNumber());
        User user = userInfo.getUser();
        City userCity = userInfo.getCity();
        DomainValue incomeTranche = userInfo.getIncomeTranche();

        Integer scoreSegment = scoreSegmentQueryService.getUserScoreSegment(smsRequest.getUserIdentityNumber());
        Integer cityScore = cityScoreQueryService.getCityScore(userCity.getTrafficCode());

        PhoneNumber to = new PhoneNumber("+90" + user.getPhoneNumber());
        PhoneNumber from = new PhoneNumber(twilioConfiguration.getTrialNumber());
        String messageBody = "Mr/Miss " + user.getName() + " your score is " + calculateScore(scoreSegment, incomeTranche.getIncomeTrancheFactor(), cityScore);

        MessageCreator messageCreator = Message.creator(to, from, messageBody);
        messageCreator.create();
        log.info("message sending: ");

        saveMessage(incomeTranche, userCity, user, messageBody);
    }

    private boolean isPhoneNumberValid(String phoneNumber) {
        //TODO: implement phone number validator
        return true;
    }

    private void saveMessage(DomainValue userIncomeTranche, City userCity, User user, String messageBody) {
        com.sumutella.scorecalculation.domain.Message message = new com.sumutella.scorecalculation.domain.Message();
        message.setCityScore(cityScoreQueryService.getCityScore(userCity.getTrafficCode()));
        message.setIncomeTrancheFactor(userIncomeTranche.getIncomeTrancheFactor());
        message.setUserScoreSegment(scoreSegmentQueryService.getUserScoreSegment(user.getIdentityNumber()));
        message.setMessage(messageBody);
        message.setCityTrafficCode(userCity.getTrafficCode());
        message.setUserIdentityNumber(user.getIdentityNumber());
        messageCommandService.saveSentMessage(message);
    }

    private Long calculateScore(Integer scoreSegment, Integer incomeTrancheFactor, Integer cityScore) {
        return Long.valueOf(scoreSegment * incomeTrancheFactor + cityScore);
    }

}
