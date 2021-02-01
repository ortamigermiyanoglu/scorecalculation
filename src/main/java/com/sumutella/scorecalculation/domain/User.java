package com.sumutella.scorecalculation.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity(name = "user")
@Getter
@Setter
@ToString
@Table(indexes = {
        @Index(name = "identityNumberIndex", columnList = "identityNumber")
})
public class User extends BaseEntity{
    @Column(unique = true)
    private Long identityNumber;
    private String name;
    private String surname;
    @Column(unique = true)
    private Long phoneNumber;
}
