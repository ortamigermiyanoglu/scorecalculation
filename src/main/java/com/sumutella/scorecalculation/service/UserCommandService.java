package com.sumutella.scorecalculation.service;

import com.sumutella.scorecalculation.dto.CreateUserDTO;

public interface UserCommandService {
    Long createUpdateUser(CreateUserDTO createUserDTO);
    Boolean updateUserScores(Long userIdentityNumber, Integer cityScore, Integer scoreSegment);
}
