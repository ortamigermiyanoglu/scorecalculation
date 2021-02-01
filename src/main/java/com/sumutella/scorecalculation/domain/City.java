package com.sumutella.scorecalculation.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity()
@Setter
@Getter
@ToString
@Table(name = "city")
public class City extends BaseEntity{
    private String name;
    private Integer trafficCode;
}
