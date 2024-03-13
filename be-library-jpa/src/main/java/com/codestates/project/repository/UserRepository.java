package com.codestates.project.repository;

import com.codestates.project.domain.UserInfo;
import com.codestates.project.exception.CustomException;
import com.codestates.project.exception.ExceptionType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * UserRepository 인터페이스는 사용자(UserInfo)에 대한 데이터 접근을 위한 인터페이스입니다.
 * JpaRepository를 상속받아 기본적인 CRUD(Create, Read, Update, Delete) 기능을 포함하고 있습니다.
 */
public interface UserRepository extends JpaRepository<UserInfo, Long> {

    /**
     * 이름과 전화번호를 기준으로 사용자를 조회하는 메서드입니다.
     *
     * @param name  조회할 사용자의 이름
     * @param phone 조회할 사용자의 전화번호
     * @return 이름과 전화번호가 일치하는 사용자 정보(Optional)
     */
    Optional<UserInfo> findByNameAndPhone(String name, String phone);

    /**
     * 사용자 ID를 기준으로 사용자를 조회하는 메서드입니다.
     * 사용자 ID에 해당하는 사용자가 존재하지 않을 경우 CustomException을 발생시킵니다.
     *
     * @param userId 조회할 사용자의 ID
     * @return 사용자 ID에 해당하는 사용자 정보
     * @throws CustomException 사용자가 존재하지 않을 경우 예외 발생
     */
    default UserInfo findByUserId(Long userId) {
        return this.findById(userId)
            .orElseThrow(() -> new CustomException(ExceptionType.NOT_FOUND_USER));
    }
}
