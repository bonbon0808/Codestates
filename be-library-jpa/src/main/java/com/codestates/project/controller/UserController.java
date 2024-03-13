package com.codestates.project.controller;

import com.codestates.project.dto.request.UserCreateRequest;
import com.codestates.project.dto.response.UserLoanResponse;
import com.codestates.project.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    // UserController 생성자를 통해 UserService 주입
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 사용자 대출 히스토리 조회 API
     *
     * @param userId 조회할 사용자의 ID
     * @return ResponseEntity<List<UserLoanResponse>> 조회된 사용자 대출 히스토리 목록과 200 OK 상태 코드
     */
    @GetMapping(path = "/{userId}/loan", name = "사용자 대출 히스토리 조회")
    public ResponseEntity<List<UserLoanResponse>> getUserLoan(@PathVariable Long userId) {
        // UserService를 사용하여 사용자 대출 히스토리 조회 수행
        List<UserLoanResponse> userLoanHistories = userService.getUserLoanHistories(userId);
        // 조회된 결과를 ResponseEntity에 담아 반환 (200 OK 상태 코드)
        return ResponseEntity.ok(userLoanHistories);
    }

    /**
     * 사용자 등록 API
     *
     * @param request 등록할 사용자 정보가 담긴 UserCreateRequest 객체
     * @return ResponseEntity<Void> 사용자가 등록된 경우 201 Created 상태 코드와 생성된 사용자의 URI를 담은 응답
     */
    @PostMapping(name = "사용자 등록")
    public ResponseEntity<Void> saveUser(@RequestBody @Valid UserCreateRequest request) {
        // UserService를 사용하여 사용자 등록 수행하고, 생성된 사용자의 ID 반환
        Long savedUserId = userService.saveUser(request);
        // 생성된 사용자의 ID를 기반으로 생성된 URI를 ResponseEntity에 담아 반환 (201 Created 상태 코드)
        return ResponseEntity.created(URI.create("/users/" + savedUserId)).build();
    }

    /**
     * 사용자 삭제 API
     *
     * @param userId 삭제할 사용자의 ID
     * @return ResponseEntity<Void> 사용자가 삭제된 경우 200 OK 상태 코드를 담은 응답
     */
    @DeleteMapping(path = "/{userId}", name = "사용자 삭제")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        // UserService를 사용하여 사용자 삭제 수행
        userService.deleteUser(userId);
        // 삭제 성공 시 200 OK 상태 코드와 빈 응답을 반환
        return ResponseEntity.ok().build();
    }
}
