package com.codestates.project.repository;

import com.codestates.project.domain.Book;
import com.codestates.project.domain.UserLoanHistory;
import com.codestates.project.domain.UserLoanStatus;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * UserLoanHistoryRepository 인터페이스는 사용자(UserInfo) 대출 히스토리(UserLoanHistory)에 대한 데이터 접근을 위한 인터페이스입니다.
 * JpaRepository를 상속받아 기본적인 CRUD(Create, Read, Update, Delete) 기능을 포함하고 있으며,
 * DslUserLoanHistoryRepository를 함께 상속받아 사용자의 대출 히스토리에 대한 복잡한 조회를 가능하게 합니다.
 */
public interface UserLoanHistoryRepository extends JpaRepository<UserLoanHistory, Long>, DslUserLoanHistoryRepository {

    /**
     * 특정 도서의 대출 상태(UserLoanStatus)가 주어진 값과 일치하는 대출 히스토리의 개수를 조회하는 메서드입니다.
     *
     * @param book   조회할 대출 히스토리의 도서 정보(Book 객체)
     * @param status 조회할 대출 히스토리의 상태(UserLoanStatus 열거형)
     * @return 대출 상태가 일치하는 대출 히스토리의 개수
     */
    int countByBookAndStatus(Book book, UserLoanStatus status);
}
