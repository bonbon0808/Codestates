package com.codestates.member.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;

@Getter
@Setter
public class Member {
    @Id
    private Long memberId;
}
