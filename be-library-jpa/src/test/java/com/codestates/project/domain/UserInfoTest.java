package com.codestates.project.domain;

import com.codestates.project.exception.CustomException;
import com.codestates.project.fixture.UserFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

import static com.codestates.project.domain.UserLoanStatus.RETURNED;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@DisplayName("UserInfo 테스트")
class UserInfoTest {

    // UserFixture 객체를 생성하여 테스트에서 활용할 예시 사용자 데이터를 생성합니다.
    private static final UserFixture fixture = new UserFixture();

    @DisplayName("대출 여부에 따른 사용자 삭제 가능 여부 확인")
    @MethodSource("getUser")
    @ParameterizedTest
    void checkDeletableUserStatus(UserInfo userInfo, boolean expected) {
        // given & when
        // 사용자의 대출 여부를 확인하는 isNotDeletable() 메서드를 호출하여 결과를 가져옵니다.
        boolean deletable = userInfo.isNotDeletable();

        // then
        // 기대한 결과와 실제 결과가 일치하는지 assertThat 메서드를 사용하여 검증합니다.
        assertThat(deletable).isEqualTo(expected);
    }

    // isNotDeletable() 메서드의 테스트에 사용될 사용자 정보와 삭제 가능 여부를 반환하는 메서드입니다.
    private static Stream<Arguments> getUser() {
        return Stream.of(
            // fixture 객체를 사용하여 대출 중인 사용자 정보를 생성하고, 삭제 가능 여부가 true인 경우를 테스트합니다.
            Arguments.of(fixture.getUserInfoWithLoanHistory(LocalDate.now()), true),
            // fixture 객체를 사용하여 대출 반납 이력을 가진 사용자 정보를 생성하고, 삭제 가능 여부가 false인 경우를 테스트합니다.
            Arguments.of(fixture.getUserInfoWithReturnHistory(LocalDate.now(), LocalDate.now()), false)
        );
    }

    @DisplayName("대출 반납")
    @Test
    void returnBook() {
        // given
        // fixture 객체를 사용하여 대출 중인 사용자 정보를 생성합니다.
        UserInfo userInfo = fixture.getUserInfoWithLoanHistory(LocalDate.now());

        // when
        // 사용자가 도서를 반납하는 returnBook() 메서드를 호출합니다.
        userInfo.returnBook(1000L);

        // then
        // 도서 반납 후, 사용자의 대출 이력 상태가 RETURNED로 변경되었는지 검증합니다.
        assertThat(userInfo.getUserLoanHistories().get(0).getStatus()).isEqualTo(RETURNED);
    }

    @DisplayName("대출중인 책이 5권 이상인 경우 대출 불가")
    @Test
    void isOverLoanCount() {
        // given
        // 대출 중인 책이 5권인 사용자 정보를 생성합니다.
        UserInfo userInfo = new UserInfo("name", 33, Gender.MALE, "01012341234",
            List.of(
                fixture.getUserLoanHistory(LocalDate.now()),
                fixture.getUserLoanHistory(LocalDate.now()),
                fixture.getUserLoanHistory(LocalDate.now()),
                fixture.getUserLoanHistory(LocalDate.now()),
                fixture.getUserLoanHistory(LocalDate.now())
            ));

        // when & then
        // 6번째 도서를 대출하려고 할 때, 예외(CustomException)가 발생하는지 검증합니다.
        assertThatThrownBy(() -> {
            userInfo.loanBook(1002L);
        }).isInstanceOf(CustomException.class);
    }

    @DisplayName("연체중인 책이 있으면 대출 불가")
    @Test
    void isOverDue() {
        // given
        // 2022년 8월 31일에 대출한 사용자 정보를 생성합니다.
        LocalDate loanDate = LocalDate.of(2022, 8, 31);
        UserInfo userInfo = fixture.getUserInfoWithLoanHistory(loanDate);

        // when & then
        // 연체 중인 상태에서 다른 도서를 대출하려고 할 때, 예외(CustomException)가 발생하는지 검증합니다.
        assertThatThrownBy(() -> {
            userInfo.loanBook(1002L);
        }).isInstanceOf(CustomException.class);
    }
}
