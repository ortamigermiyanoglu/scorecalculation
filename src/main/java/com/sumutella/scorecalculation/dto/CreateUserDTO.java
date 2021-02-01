package com.sumutella.scorecalculation.dto;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class CreateUserDTO {

    private String userName;
    private String userSurname;
    private Integer incomeTrancheCode;
    private Long userIdentityNumber;
    private Long userPhoneNumber;
    private Integer cityTrafficCode;


}
