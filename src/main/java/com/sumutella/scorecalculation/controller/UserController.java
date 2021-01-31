package com.sumutella.scorecalculation.controller;

import com.sumutella.scorecalculation.request.CreateUserRequest;
import com.sumutella.scorecalculation.request.UpdateUserScoresRequest;
import com.sumutella.scorecalculation.service.UserCommandService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/scorecalculation")
public class UserController {
    private final UserCommandService userCommandService;


    public UserController(UserCommandService userCommandService) {
        this.userCommandService = userCommandService;
    }

    @PostMapping("/users")
    public Long createUpdateUser(@RequestBody @Valid CreateUserRequest createUserRequest){
        return userCommandService.createUpdateUser(createUserRequest.getCreateUserDTO());
    }

    @PostMapping("/users")
    public Boolean updateUserCityScorendScoreSegment(UpdateUserScoresRequest updateUserScoresRequest){
        return userCommandService.updateUserScores(updateUserScoresRequest.getUserIdentityNumber(),updateUserScoresRequest.getCityScore(),
                updateUserScoresRequest.getScoreSegment());
    }
}
