package com.sumutella.scorecalculation.service;

import com.sumutella.scorecalculation.request.SmsRequest;

public interface TwilioSmsSenderService {
    void sendSms(SmsRequest smsRequest);
}
