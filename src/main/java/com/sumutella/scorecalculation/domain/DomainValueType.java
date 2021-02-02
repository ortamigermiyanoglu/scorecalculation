package com.sumutella.scorecalculation.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;


@Entity(name = "domain_value_type")
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class DomainValueType extends BaseEntity {
    private String code;
    private String description;
}
