package com.sumutella.scorecalculation.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "user_info")
@Getter
@Setter
@ToString
public class UserInfo extends BaseEntity{
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "city_id")
    private City city;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "income_tranche_id")
    private DomainValue incomeTranche;

}
