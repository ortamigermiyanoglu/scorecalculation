package com.sumutella.scorecalculation.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;


@Setter
@Getter
public class CreateUserDTO {

    @NotBlank
    private String userName;
    @NotBlank
    private String userSurname;
    @NotBlank
    private Integer incomeTrancheCode;
    @NotNull
    private Long userIdentityNumber;
    @NotBlank
    private Long userPhoneNumber;
    private Integer cityTrafficCode;


}
