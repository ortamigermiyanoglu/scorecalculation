package com.sumutella.scorecalculation.model;

import com.sumutella.scorecalculation.dto.IdCodeDisplayValueDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class CreateUserModel {
    private List<IdCodeDisplayValueDTO> incomeTranches = new ArrayList<>();
    private List<IdCodeDisplayValueDTO> cities = new ArrayList<>();
}
