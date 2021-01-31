package com.sumutella.scorecalculation.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
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
