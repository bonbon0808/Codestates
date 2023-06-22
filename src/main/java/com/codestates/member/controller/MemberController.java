package com.codestates.member.controller;

import com.codestates.member.dto.*;
import com.codestates.member.entity.Member;
import com.codestates.member.dto.PageInfo;
import com.codestates.member.mapper.MemberMapper;
import com.codestates.member.service.MemberService;
import com.codestates.utils.UriCreator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import java.net.URI;
import java.util.List;


/**
 * - DI 적용
 * - Mapstruct Mapper 적용
 * - @ExceptionHandler 적용
 */
@RestController
@RequestMapping("/v10/members")
@Validated
@Slf4j
public class MemberController {
    private final static String MEMBER_DEFAULT_URL = "/v10/members";
    private final MemberService memberService;
    private final MemberMapper mapper;

    public MemberController(MemberService memberService, MemberMapper mapper) {
        this.memberService = memberService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity postMember(@Valid @RequestBody MemberPostDto memberDto) {
        Member member = mapper.memberPostDtoToMember(memberDto);

        Member resultMember = memberService.createMember(member);

        URI location = UriCreator.createUri(MEMBER_DEFAULT_URL, resultMember.getMemberId());

        return ResponseEntity.created(location).build();
    }

    @PatchMapping("/{member-id}")
    public ResponseEntity patchMember(
            @PathVariable("member-id") @Positive long memberId,
            @Valid @RequestBody MemberPatchDto memberPatchDto) {
        memberPatchDto.setMemberId(memberId);

        Member response =
                memberService.updateMember(mapper.memberPatchDtoToMember(memberPatchDto));

        return new ResponseEntity<>(mapper.memberToMemberResponseDto(response),
                HttpStatus.OK);
    }

    @GetMapping("/{member-id}")
    public ResponseEntity getMember(
            @PathVariable("member-id") @Positive long memberId) {
        Member response = memberService.findMember(memberId);
        return new ResponseEntity<>(mapper.memberToMemberResponseDto(response)
                , HttpStatus.OK);
    }

    // @RequestParam으로 int page, int size 전달받기 ( 둘 다 0보다 큰 숫자만 가능 - 양수인지 검증 ) @Positive 애너테이션으로 양수인지 확인 가능함
    @GetMapping
    public ResponseEntity getMembers(@RequestParam(defaultValue = "0") @Min(1) int page,
                                     @RequestParam(defaultValue = "0") @Min(1) int size) {

        // TODO 페이지네이션을 적용하세요!
        Page<Member> memberPage = memberService.findMembers(page-1, size); // 페이지는 1부터 시작인데 데이터 액세스 계층에서 접근은 0부터라 page에서 -1
        PageInfo pageInfoDto = new PageInfo(page,size, memberPage.getNumberOfElements(), memberPage.getTotalPages());

        List<Member> members = memberPage.getContent();
        List<MemberResponseDto> response = mapper.membersToMemberResponseDtos(members);

        return new ResponseEntity<>(new MemberPageDto(response,pageInfoDto), HttpStatus.OK);
    }

    @DeleteMapping("/{member-id}")
    public ResponseEntity deleteMember(
            @PathVariable("member-id") @Positive long memberId) {
        memberService.deleteMember(memberId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
