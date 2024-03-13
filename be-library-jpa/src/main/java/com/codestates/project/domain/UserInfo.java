package com.codestates.project.domain;

import com.codestates.project.domain.baseentity.BaseTimeEntity;
import com.codestates.project.exception.CustomException;
import com.codestates.project.exception.ExceptionType;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 사용자 정보를 나타내는 엔티티 클래스인 UserInfo입니다.
 * BaseTimeEntity를 상속하여 생성일시와 수정일시를 자동으로 관리합니다.
 */
@Entity
public class UserInfo extends BaseTimeEntity {

    /**
     * 사용자의 고유 식별자인 ID입니다.
     * GenerationType.IDENTITY를 통해 자동으로 생성되도록 설정하였습니다.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    /**
     * 사용자의 이름을 나타내는 필드입니다.
     */
    private String name;

    /**
     * 사용자의 나이를 나타내는 필드입니다.
     */
    private Integer age;

    /**
     * 사용자의 성별을 나타내는 필드입니다.
     * EnumType.STRING을 통해 열거형 상수를 문자열로 저장합니다.
     */
    @Enumerated(EnumType.STRING)
    private Gender gender;

    /**
     * 사용자의 전화번호를 나타내는 필드입니다.
     */
    private String phone;

    /**
     * 사용자와 대출 이력 간의 일대다 관계를 설정합니다.
     * 사용자가 삭제될 경우 해당 사용자의 대출 이력도 함께 삭제되도록 cascade 설정을 하였습니다.
     */
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserLoanHistory> userLoanHistories = new ArrayList<>();

    /**
     * 기본 생성자입니다.
     */
    public UserInfo() {
    }

    /**
     * ID를 인자로 받는 생성자입니다.
     * @param id 사용자의 고유 식별자
     */
    public UserInfo(Long id) {
        this.id = id;
    }

    /**
     * 사용자 정보를 생성하는 생성자입니다.
     * @param name 사용자의 이름
     * @param age 사용자의 나이
     * @param gender 사용자의 성별
     * @param phone 사용자의 전화번호
     */
    public UserInfo(String name, Integer age, Gender gender, String phone) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
    }

    /**
     * 사용자 정보와 대출 이력을 함께 생성하는 생성자입니다.
     * @param name 사용자의 이름
     * @param age 사용자의 나이
     * @param gender 사용자의 성별
     * @param phone 사용자의 전화번호
     * @param userLoanHistories 사용자의 대출 이력 리스트
     */
    public UserInfo(String name, Integer age, Gender gender, String phone, List<UserLoanHistory> userLoanHistories) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.userLoanHistories = userLoanHistories;
    }

    /**
     * 사용자의 고유 식별자(ID)를 반환합니다.
     * @return Long 사용자 ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 사용자의 대출 이력 리스트를 반환합니다.
     * 변경 불가능한 리스트를 반환하도록 Collections.unmodifiableList()로 감싸서 보호합니다.
     * @return List<UserLoanHistory> 사용자의 대출 이력 리스트 (변경 불가능)
     */
    public List<UserLoanHistory> getUserLoanHistories() {
        return Collections.unmodifiableList(userLoanHistories);
    }

    /**
     * 사용자의 대출 가능 여부를 확인하는 메서드입니다.
     * @return boolean 대출 가능 여부
     */
    public boolean isNotDeletable() {
        return userLoanHistories.stream()
            .anyMatch(userLoanHistory -> userLoanHistory.getStatus() == UserLoanStatus.LOANED);
    }

    /**
     * 도서 대출 메서드입니다.
     * 사용자가 대출 가능한 상태인지 확인하고, 대출 이력을 추가합니다.
     * @param bookId 대출할 도서의 ID
     */
    public void loanBook(Long bookId) {
        assertValidLoanStatus();
        this.userLoanHistories.add(new UserLoanHistory(id, bookId));
    }

    /**
     * 대출 가능 여부를 확인하는 메서드입니다.
     * 현재 대출 중인 도서 개수와 대출 기한을 확인하여 대출 가능 여부를 판단합니다.
     * 대출 불가능한 경우 CustomException을 던집니다.
     */
    private void assertValidLoanStatus() {
        if (isOverLoanCount() || isOverDue()) {
            throw new CustomException(ExceptionType.NOT_ALLOW_LOAN);
        }
    }

    /**
     * 사용자가 대출한 도서 개수가 최대 대출 가능한 도서 개수를 초과하는지 확인합니다.
     * @return boolean 대출 가능한 도서 개수 초과 여부
     */
    private boolean isOverLoanCount() {
        return userLoanHistories.stream()
            .filter(h -> h.getStatus() == UserLoanStatus.LOANED).count() >= Book.MAX_LOAN_COUNT;
    }

    /**
     * 사용자가 대출한 도서 중 연체된 도서가 있는지 확인합니다.
     * @return boolean 연체 도서 존재 여부
     */
    private boolean isOverDue() {
        return userLoanHistories.stream()
            .anyMatch(h -> h.getStatus() == UserLoanStatus.LOANED
                && LocalDate.now().minusDays(Book.LOAN_PERIOD).isAfter(h.getLoanDate()));
    }

    /**
     * 도서 반납 메서드입니다.
     * 사용자가 대출한 도서 중 대상 도서를 반납 처리합니다.
     * 반납 처리 대상 도서가 존재하지 않을 경우 CustomException을 던집니다.
     * @param bookId 반납할 도서의 ID
     */
    public void returnBook(Long bookId) {
        UserLoanHistory userLoanHistory = userLoanHistories.stream()
            .filter(h -> bookId.equals(h.getBook().getId()) && h.getStatus() == UserLoanStatus.LOANED)
            .findFirst()
            .orElseThrow(() -> new CustomException(ExceptionType.NOT_FOUND_BOOK));
        userLoanHistory.doReturn();
    }
}
