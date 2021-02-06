package com.sumutella.scorecalculation.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "city_score")
@Setter
@Getter
@ToString
public class CityScore extends BaseEntity {
    private Integer score;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "city_id", nullable = false)
    City city;
}
