package com.sumutella.scorecalculation.service;

import com.sumutella.scorecalculation.dto.CreateUserDTO;

public interface UserCommandService {
    void createUser(CreateUserDTO createUserDTO);
    Boolean updateUserScores(Long userIdentityNumber, Integer cityScore, Integer scoreSegment);
}
