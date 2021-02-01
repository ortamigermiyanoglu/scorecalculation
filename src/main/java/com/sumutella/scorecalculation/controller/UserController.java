package com.sumutella.scorecalculation.controller;

import com.sumutella.scorecalculation.model.UserCreateModel;
import com.sumutella.scorecalculation.request.CreateUserRequest;
import com.sumutella.scorecalculation.service.UserCommandService;
import com.sumutella.scorecalculation.service.UserQueryService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/scorecalculation")
public class UserController {
    private final UserCommandService userCommandService;
    private final UserQueryService userQueryService;


    public UserController(UserCommandService userCommandService, UserQueryService userQueryService) {
        this.userCommandService = userCommandService;
        this.userQueryService = userQueryService;
    }

    @PostMapping(value = "/users")
    public Long createUpdateUser(@RequestBody @Valid CreateUserRequest createUserRequest) {
        return userCommandService.createUpdateUser(createUserRequest.getCreateUserDTO());
    }

    @GetMapping("/users/createmodel")
    public UserCreateModel getUserCreateModel() {
        return userQueryService.getUserCreateModel();
    }
}
