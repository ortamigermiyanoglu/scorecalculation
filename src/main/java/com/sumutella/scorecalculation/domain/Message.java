package com.sumutella.scorecalculation.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;

@Entity(name = "message")
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class Message extends BaseEntity {
    private Long userIdentityNumber;
    private Integer cityTrafficCode;
    private Integer cityScore;
    private Integer incomeTrancheFactor;
    private Integer userScoreSegment;
    private String message;

}
