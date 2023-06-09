package com.codestates.member;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/members")
public class MemberController {
    private final Map<Long, Map<String, Object>> members = new HashMap<>();

    @PostConstruct
    public void init() {
        Map<String, Object> member1 = new HashMap<>();
        long memberId = 1L; // memberID는 1
        member1.put("memberId", memberId);
        member1.put("email", "hgd@gmail.com");
        member1.put("name", "홍길동");
        member1.put("phone", "010-1234-5678");

        members.put(memberId, member1);
    }

    //---------------- 여기서 부터 아래에 코드를 구현하세요! --------------------//
    // 1. 회원 정보 수정을 위한 핸들러 메서드 구현
    // @PathVariable -> 경로 변수를 매개 변수에 매핑. 주로 리소스를 식별하고 조회하는데 사용
    // @RequestParam -> 쿼리 파라미터를 매개 변수에 매핑. 특정 데이터를 검색하거나 필터링할 때 사용
    // @PutMapping -> 리소스의 모든 정보를 수정 , @PatchMapping -> 리소스의 일부 정보만 수정. 둘 다 수정하는 기능인데 범위 차이인듯
    // memberId는 URI 경로에 포함, phone -> 010-1111-2222로 수정
    // 클라이언트 요청 데이터? -> 해시맵에 입력되는 값을 말하는건가

    @PutMapping("/{memberId}") // memberId를 조회하고 수정할 phone정보만 매핑
    public ResponseEntity updateMemberInfo(@PathVariable("memberId") long memberId,
                                           @RequestParam("phone") String phone) {
        Map<String, Object>  member1 = members.get(memberId); // members 이름의 맵에서 memberId가 1인 회원정보 가져오기
        member1.put("phone","010-1111-2222"); // phone 정보만 수정

        members.put(memberId, member1);

        return new ResponseEntity<>(member1, HttpStatus.OK);
    }

    // 2. 회원 정보 삭제를 위한 핸들러 메서드 구현
    // @DeleteMapping -> 리소스를 삭제
    // memberId는 URI 경로에 포함

    @DeleteMapping("/{memberId}") // memberId 매핑
    public ResponseEntity deleteMemberInfo(@PathVariable("memberId") long memberId) {

        Map<String, Object> member1 = members.get(memberId);
        members.clear();

        return new ResponseEntity<>(member1, HttpStatus.NO_CONTENT); // 응답코드 204

    }

}
