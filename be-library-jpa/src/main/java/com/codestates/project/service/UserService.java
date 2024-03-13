package com.codestates.project.service;

import com.codestates.project.domain.UserInfo;
import com.codestates.project.dto.request.UserCreateRequest;
import com.codestates.project.dto.response.UserLoanResponse;
import com.codestates.project.exception.CustomException;
import com.codestates.project.exception.ExceptionType;
import com.codestates.project.repository.UserLoanHistoryRepository;
import com.codestates.project.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * UserService는 사용자 관련 비즈니스 로직을 처리하는 서비스 클래스입니다.
 * 사용자 등록, 삭제, 대출 이력 조회 등의 기능을 수행합니다.
 * Service 어노테이션으로 서비스 빈으로 등록되며, 트랜잭션 처리를 위해 Transactional 어노테이션을 사용합니다.
 */
@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final UserLoanHistoryRepository userLoanHistoryRepository;

    /**
     * UserService의 생성자로서, 의존성 주입을 받습니다.
     *
     * @param userRepository         사용자 정보를 조회하는 데 사용되는 UserRepository 인터페이스
     * @param userLoanHistoryRepository 사용자 대출 이력 정보를 조회하는 데 사용되는 UserLoanHistoryRepository 인터페이스
     */
    public UserService(UserRepository userRepository, UserLoanHistoryRepository userLoanHistoryRepository) {
        this.userRepository = userRepository;
        this.userLoanHistoryRepository = userLoanHistoryRepository;
    }

    /**
     * 사용자의 대출 이력을 조회하는 메서드입니다.
     *
     * @param userId 사용자 ID
     * @return 사용자의 대출 이력을 담은 리스트
     */
    public List<UserLoanResponse> getUserLoanHistories(Long userId) {
        return userLoanHistoryRepository.findAllUserLoanHistories(userId);
    }

    /**
     * 사용자를 등록하는 메서드입니다.
     *
     * @param request 사용자 등록 요청 정보를 담고 있는 UserCreateRequest 객체
     * @return 등록된 사용자의 ID
     * @throws CustomException 이미 존재하는 아이디일 경우 예외 발생
     */
    public Long saveUser(UserCreateRequest request) {
        Optional<UserInfo> user = userRepository.findByNameAndPhone(
            request.getName(),
            request.getPhone()
        );
        if (user.isPresent()) {
            throw new CustomException(ExceptionType.EXISTS_USER);
        }

        return userRepository.save(request.toEntity()).getId();
    }

    /**
     * 사용자를 삭제하는 메서드입니다.
     *
     * @param userId 사용자 ID
     * @throws CustomException 대출 중인 사용자일 경우 예외 발생
     */
    public void deleteUser(Long userId) {
        UserInfo user = userRepository.findByUserId(userId);
        if (user.isNotDeletable()) {
            throw new CustomException(ExceptionType.EXISTS_LOANED_USER);
        }
        userRepository.delete(user);
    }
}
