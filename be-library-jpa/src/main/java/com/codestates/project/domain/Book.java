package com.codestates.project.domain;

import com.codestates.project.domain.baseentity.BaseTimeEntity;

import javax.persistence.*;

/**
 * 도서 정보를 나타내는 엔티티 클래스인 Book입니다.
 * BaseTimeEntity를 상속하여 생성일시와 수정일시를 자동으로 관리합니다.
 */
@Entity
public class Book extends BaseTimeEntity {

    public static int LOAN_PERIOD = 14;
    public static int MAX_LOAN_COUNT = 5;

    /**
     * 도서의 고유 식별자인 ID입니다.
     * GenerationType.IDENTITY를 통해 자동으로 생성되도록 설정하였습니다.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long id;

    /**
     * 도서의 제목을 나타내는 필드입니다.
     */
    private String title;

    /**
     * 도서의 카테고리를 나타내는 필드입니다.
     * EnumType.STRING을 통해 열거형 상수를 문자열로 저장합니다.
     */
    @Enumerated(EnumType.STRING)
    private BookCategory category;

    /**
     * 도서의 작가를 나타내는 필드입니다.
     */
    private String author;

    /**
     * 도서의 출판사를 나타내는 필드입니다.
     */
    private String publisher;

    /**
     * 기본 생성자입니다.
     */
    public Book() {
    }

    /**
     * ID를 인자로 받는 생성자입니다.
     * @param id 도서의 고유 식별자
     */
    public Book(Long id) {
        this.id = id;
    }

    /**
     * 도서의 고유 식별자(ID)를 반환합니다.
     * @return Long 도서 ID
     */
    public Long getId() {
        return id;
    }

    // 아래에 LOAN_PERIOD, MAX_LOAN_COUNT 등 도서와 관련된 추가적인 메서드와 상수를 작성할 수 있습니다.
    // 필요한 경우 이 클래스를 확장하여 도서 관련 비즈니스 로직을 구현할 수 있습니다.
}
