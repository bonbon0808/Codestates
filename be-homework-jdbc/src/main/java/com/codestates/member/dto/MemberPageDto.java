package com.codestates.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class MemberPageDto {

    private List<MemberResponseDto> data; // data 멤버데이터
    private PageInfo pageInfo; // pageInfo 페이지 정보
}
