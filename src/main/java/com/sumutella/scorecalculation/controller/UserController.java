package com.sumutella.scorecalculation.controller;

import com.sumutella.scorecalculation.model.UserCreateModel;
import com.sumutella.scorecalculation.request.CreateUserRequest;
import com.sumutella.scorecalculation.service.UserCommandService;
import com.sumutella.scorecalculation.service.UserQueryService;
import io.swagger.annotations.ApiOperation;
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
    @ApiOperation(value = "", notes = "create/update user")
    public Long createUpdateUser(@RequestBody @Valid CreateUserRequest createUserRequest) {
        return userCommandService.createUpdateUser(createUserRequest.getCreateUserDTO());
    }

    @GetMapping("/users/createmodel")
    @ApiOperation(value = "", notes = "get necessary data to create user")
    public UserCreateModel getUserCreateModel() {
        return userQueryService.getUserCreateModel();
    }
}
