package com.sumutella.scorecalculation.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "score_segment")
@Setter
@Getter
@ToString
public class ScoreSegment extends BaseEntity {
    private Integer score;
    @Column(unique = true)
    private Long identityNumber;

}
