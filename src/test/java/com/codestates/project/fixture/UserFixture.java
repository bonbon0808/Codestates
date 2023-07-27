package com.codestates.project.fixture;

import com.codestates.project.domain.Gender;
import com.codestates.project.domain.UserInfo;
import com.codestates.project.domain.UserLoanHistory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.codestates.project.domain.UserLoanStatus.LOANED;
import static com.codestates.project.domain.UserLoanStatus.RETURNED;

/**
 * 사용자와 사용자 대출 이력을 생성하는 Fixture 클래스입니다.
 */
public class UserFixture {

  /**
   * 기본 사용자 정보를 반환합니다.
   */
  public UserInfo getUserInfo() {
    return new UserInfo("name", 33, Gender.MALE, "01012341234");
  }

  /**
   * 사용자 반납 이력을 생성하여 반환합니다.
   * @param loanDate 도서 대출일
   * @param returnedDate 도서 반납일
   */
  public UserLoanHistory getUserReturnHistory(LocalDate loanDate, LocalDate returnedDate) {
    return new UserLoanHistory(RETURNED, loanDate, returnedDate, 1000L, 1000L);
  }

  /**
   * 사용자 대출 이력을 생성하여 반환합니다.
   * @param loanDate 도서 대출일
   */
  public UserLoanHistory getUserLoanHistory(LocalDate loanDate) {
    return new UserLoanHistory(LOANED, loanDate, null, 1000L, 1000L);
  }

  /**
   * 특정 대출일을 가진 사용자 정보를 생성하여 반환합니다.
   * @param loanDate 도서 대출일
   */
  public UserInfo getUserInfoWithLoanHistory(LocalDate loanDate) {
    return new UserInfo("name", 33, Gender.MALE, "01012341234",
        new ArrayList<>(Collections.singletonList(getUserLoanHistory(loanDate)))
    );
  }

  /**
   * 특정 대출일과 반납일을 가진 사용자 정보를 생성하여 반환합니다.
   * @param loanDate 도서 대출일
   * @param returnedDate 도서 반납일
   */
  public UserInfo getUserInfoWithReturnHistory(LocalDate loanDate, LocalDate returnedDate) {
    return new UserInfo("name", 33, Gender.MALE, "01012341234",
        List.of(getUserReturnHistory(loanDate, returnedDate))
    );
  }
}
