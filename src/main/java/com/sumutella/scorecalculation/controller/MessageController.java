package com.sumutella.scorecalculation.controller;


import com.sumutella.scorecalculation.request.SmsRequest;
import com.sumutella.scorecalculation.service.TwilioSmsSenderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/scorecalculation")
@Api(value = "message-controller-api")
public class MessageController {
    private final TwilioSmsSenderService twilioSmsSenderService;

    public MessageController(TwilioSmsSenderService twilioSmsSenderService) {
        this.twilioSmsSenderService = twilioSmsSenderService;
    }

    @PostMapping("/sms")
    @ApiOperation(value = "", notes = "send overall score to user as sms")
    public void sendSms(@RequestBody @Valid SmsRequest smsRequest) {
        twilioSmsSenderService.sendSms(smsRequest);
    }
}
