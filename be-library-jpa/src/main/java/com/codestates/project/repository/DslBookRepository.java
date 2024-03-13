package com.codestates.project.repository;

import com.codestates.project.dto.request.BookSearchType;
import com.codestates.project.dto.response.BookResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * DslBookRepository 인터페이스는 도서(Book) 엔티티에 대한 복잡한 동적 쿼리를 작성하기 위한 인터페이스입니다.
 * searchBooks 메서드를 통해 도서 검색을 수행할 수 있으며, 검색 타입과 값, 페이징 정보를 입력받습니다.
 * 검색 결과는 Page 객체로 반환됩니다.
 */
public interface DslBookRepository {
    /**
     * 도서 검색을 수행하는 메서드입니다.
     *
     * @param type     도서 검색 유형을 나타내는 BookSearchType enum 값 (제목, 작가, 출판사)
     * @param value    검색어 값 (제목, 작가, 출판사에 대한 검색어)
     * @param pageable 페이징 정보 (페이지 번호, 페이지 크기, 정렬 정보 등)
     * @return 도서 검색 결과를 담은 Page<BookResponse> 객체
     */
    Page<BookResponse> searchBooks(BookSearchType type, String value, Pageable pageable);
}
