package com.codestates.project.service;

import com.codestates.project.domain.Gender;
import com.codestates.project.domain.UserInfo;
import com.codestates.project.dto.request.UserCreateRequest;
import com.codestates.project.exception.CustomException;
import com.codestates.project.fixture.UserFixture;
import com.codestates.project.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
class UserServiceTest {

    private final UserFixture fixture = new UserFixture();

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @DisplayName("중복된 사용자 등록 실패")
    @Test
    void existUserException() {
        // given
        UserInfo userInfo = fixture.getUserInfo();
        userRepository.save(userInfo);

        // when & then
        assertThatThrownBy(() -> {
            // 이미 존재하는 사용자 이름과 전화번호를 가지고 사용자 등록을 시도하면 CustomException이 발생해야 함
            userService.saveUser(new UserCreateRequest("name", 33, Gender.MALE, "01012341234"));
        }).isInstanceOf(CustomException.class);
    }
}
