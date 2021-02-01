package com.sumutella.scorecalculation.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;

@Entity(name = "city_score")
@Setter
@Getter
@ToString
public class CityScore extends BaseEntity {
    private Integer trafficCode;
    private Integer score;
}
