package com.codestates.project.dto.request;

/**
 * 도서 검색 요청을 나타내는 클래스인 BookSearchRequest입니다.
 * 도서 검색 시 사용되는 검색 유형과 검색어를 가지고 있습니다.
 */
public class BookSearchRequest {

    private BookSearchType searchType; // 도서 검색 유형 (제목, 저자, 출판사 등)

    private String searchValue; // 도서 검색어

    /**
     * BookSearchRequest의 생성자입니다.
     * 기본 생성자로, 검색 유형과 검색어는 따로 설정해주어야 합니다.
     */
    public BookSearchRequest() {
    }

    /**
     * 도서 검색 유형을 반환합니다.
     * @return BookSearchType 도서 검색 유형
     */
    public BookSearchType getSearchType() {
        return searchType;
    }

    /**
     * 도서 검색어를 반환합니다.
     * @return String 도서 검색어
     */
    public String getSearchValue() {
        return searchValue;
    }

    /**
     * 도서 검색 유형을 설정합니다.
     * @param searchType 도서 검색 유형
     */
    public void setSearchType(BookSearchType searchType) {
        this.searchType = searchType;
    }

    /**
     * 도서 검색어를 설정합니다.
     * @param searchValue 도서 검색어
     */
    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }
}
