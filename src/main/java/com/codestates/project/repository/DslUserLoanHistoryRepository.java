package com.codestates.project.repository;

import com.codestates.project.dto.response.UserLoanResponse;

import java.util.List;

/**
 * DslUserLoanHistoryRepository 인터페이스는 사용자(UserInfo) 대출 히스토리(UserLoanHistory)에 대한 복잡한 조회를 위한 인터페이스입니다.
 * findAllUserLoanHistories 메서드를 통해 특정 사용자의 대출 히스토리를 조회할 수 있습니다.
 */
public interface DslUserLoanHistoryRepository {
    /**
     * 특정 사용자의 대출 히스토리를 조회하는 메서드입니다.
     *
     * @param userId 조회할 사용자의 식별자(Long 타입)
     * @return 사용자의 대출 히스토리를 담은 List<UserLoanResponse> 객체
     */
    List<UserLoanResponse> findAllUserLoanHistories(Long userId);
}
