package com.codestates.project.dto.response;

import com.codestates.project.domain.BookCategory;
import com.querydsl.core.annotations.QueryProjection;

/**
 * 도서 목록 조회 응답을 나타내는 클래스인 BookResponse입니다.
 * 도서 목록 조회 시 반환되는 도서 정보를 담고 있습니다.
 */
public class BookResponse {

    private String title; // 도서 제목

    private BookCategory category; // 도서 카테고리

    private String author; // 도서 저자

    private String publisher; // 도서 출판사

    /**
     * BookResponse의 생성자입니다.
     * Querydsl의 @QueryProjection 어노테이션을 활용하여 도서 정보를 생성합니다.
     * @param title 도서 제목
     * @param category 도서 카테고리
     * @param author 도서 저자
     * @param publisher 도서 출판사
     */
    @QueryProjection
    public BookResponse(String title, BookCategory category, String author, String publisher) {
        this.title = title;
        this.category = category;
        this.author = author;
        this.publisher = publisher;
    }

    /**
     * 도서 제목을 반환합니다.
     * @return String 도서 제목
     */
    public String getTitle() {
        return title;
    }

    /**
     * 도서 카테고리를 반환합니다.
     * @return BookCategory 도서 카테고리
     */
    public BookCategory getCategory() {
        return category;
    }

    /**
     * 도서 저자를 반환합니다.
     * @return String 도서 저자
     */
    public String getAuthor() {
        return author;
    }

    /**
     * 도서 출판사를 반환합니다.
     * @return String 도서 출판사
     */
    public String getPublisher() {
        return publisher;
    }
}
