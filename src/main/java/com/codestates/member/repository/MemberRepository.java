package com.codestates.member.repository;

import com.codestates.member.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.awt.print.Pageable;
import java.util.Optional;

// TODO 페이지네이션을 적용하세요!
public interface MemberRepository extends PagingAndSortingRepository<Member, Long> {
    Optional<Member> findByEmail(String email);

}


