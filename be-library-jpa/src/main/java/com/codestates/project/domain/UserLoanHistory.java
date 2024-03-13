package com.codestates.project.domain;

import com.codestates.project.domain.baseentity.BaseTimeEntity;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * 사용자 대출 이력을 나타내는 엔티티 클래스인 UserLoanHistory입니다.
 * BaseTimeEntity를 상속하여 생성일시와 수정일시를 자동으로 관리합니다.
 */
@Entity
public class UserLoanHistory extends BaseTimeEntity {

    /**
     * 사용자 대출 이력의 고유 식별자인 ID입니다.
     * GenerationType.IDENTITY를 통해 자동으로 생성되도록 설정하였습니다.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "history_id")
    private Long id;

    /**
     * 사용자 대출 이력의 상태를 나타내는 필드입니다.
     * EnumType.STRING을 통해 열거형 상수를 문자열로 저장합니다.
     */
    @Enumerated(EnumType.STRING)
    private UserLoanStatus status;

    /**
     * 대출 일자를 나타내는 필드입니다.
     */
    private LocalDate loanDate;

    /**
     * 반납 일자를 나타내는 필드입니다.
     */
    private LocalDate returnedDate;

    /**
     * 사용자 대출 이력과 사용자 정보(UserInfo) 간의 다대일 관계를 설정합니다.
     * FetchType.LAZY를 통해 지연 로딩으로 설정하였으며, optional = false로 설정하여 반드시 사용자 정보가 존재해야 합니다.
     * user_id를 외래키로 사용하고, 조인 컬럼으로 user_id를 사용합니다.
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    private UserInfo user;

    /**
     * 사용자 대출 이력과 도서(Book) 간의 다대일 관계를 설정합니다.
     * FetchType.LAZY를 통해 지연 로딩으로 설정하였으며, optional = false로 설정하여 반드시 도서 정보가 존재해야 합니다.
     * book_id를 외래키로 사용하고, 조인 컬럼으로 book_id를 사용합니다.
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "book_id")
    private Book book;

    /**
     * 기본 생성자입니다.
     */
    public UserLoanHistory() {
    }

    /**
     * 사용자 대출 이력을 생성하는 생성자입니다.
     * 대출 이력을 생성할 때 초기 상태(LOANED)와 대출 일자를 설정합니다.
     * @param userId 사용자의 고유 식별자(ID)
     * @param bookId 대출할 도서의 고유 식별자(ID)
     */
    public UserLoanHistory(Long userId, Long bookId) {
        this.user = new UserInfo(userId);
        this.book = new Book(bookId);
        this.status = UserLoanStatus.LOANED;
        this.loanDate = LocalDate.now();
    }

    /**
     * 사용자 대출 이력을 생성하는 생성자입니다.
     * @param status 사용자 대출 상태
     * @param loanDate 대출 일자
     * @param returnedDate 반납 일자
     * @param userId 사용자의 고유 식별자(ID)
     * @param bookId 대출할 도서의 고유 식별자(ID)
     */
    public UserLoanHistory(UserLoanStatus status, LocalDate loanDate, LocalDate returnedDate, Long userId, Long bookId) {
        this.status = status;
        this.loanDate = loanDate;
        this.returnedDate = returnedDate;
        this.user = new UserInfo(userId);
        this.book = new Book(bookId);
    }

    /**
     * 사용자 대출 이력의 상태를 반환합니다.
     * @return UserLoanStatus 사용자 대출 상태
     */
    public UserLoanStatus getStatus() {
        return status;
    }

    /**
     * 사용자가 대출한 도서 정보를 반환합니다.
     * @return Book 사용자가 대출한 도서
     */
    public Book getBook() {
        return book;
    }

    /**
     * 사용자가 도서를 대출한 날짜를 반환합니다.
     * @return LocalDate 대출 일자
     */
    public LocalDate getLoanDate() {
        return loanDate;
    }

    /**
     * 사용자가 도서를 반납 처리하는 메서드입니다.
     * 반납 상태로 변경하고, 반납 일자를 현재 날짜로 설정합니다.
     */
    public void doReturn() {
        this.status = UserLoanStatus.RETURNED;
        this.returnedDate = LocalDate.now();
    }
}
