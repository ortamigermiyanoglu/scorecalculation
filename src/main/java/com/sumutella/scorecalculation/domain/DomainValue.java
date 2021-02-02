package com.sumutella.scorecalculation.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "domain_value")
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class DomainValue extends BaseEntity{
    private String description;
    private Integer code;
    private Integer incomeTrancheFactor;
    @ManyToOne
    @JoinColumn(name = "domain_value_type_id")
    private DomainValueType domainValueType;


}
