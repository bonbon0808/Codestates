package com.codestates.project.controller;

import com.codestates.project.dto.request.BookLoanRequest;
import com.codestates.project.dto.request.BookReturnRequest;
import com.codestates.project.dto.request.BookSearchRequest;
import com.codestates.project.dto.response.BookResponse;
import com.codestates.project.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    // BookService 주입을 위한 생성자
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    /**
     * 도서 목록 조회 API
     *
     * @param request  검색 조건이 담긴 BookSearchRequest 객체
     * @param pageable 페이징 및 정렬 정보가 담긴 Pageable 객체 ex) books?page=0&size=10&sort=title,desc
     * @return ResponseEntity<Page<BookResponse>> 조회된 도서 목록과 200 OK 상태 코드
     */
    @GetMapping(name = "도서 목록 조회")
    public ResponseEntity<Page<BookResponse>> searchBooks(BookSearchRequest request, Pageable pageable) {
        // BookService의 searchBooks 메서드를 호출하여 도서 목록 조회를 수행하고 결과를 ResponseEntity에 담아 반환
        // Pageable을 통해 페이징 처리 가능 (페이지 번호, 페이지 크기, 정렬 정보 등)
        return ResponseEntity.ok(bookService.searchBooks(request, pageable));
    }

    /**
     * 도서 대출 API
     *
     * @param request 도서 대출 요청 정보가 담긴 BookLoanRequest 객체
     * @return ResponseEntity<Void> 도서 대출 성공 시 200 OK 상태 코드와 빈 응답
     */
    @PostMapping(path = "/loan", name = "도서 대출")
    public ResponseEntity<Void> loanBook(@RequestBody @Valid BookLoanRequest request) {
        // BookService의 loanBook 메서드를 호출하여 도서 대출을 수행
        bookService.loanBook(request);
        // 대출 성공 시 200 OK 상태 코드와 빈 응답을 반환
        return ResponseEntity.ok().build();
    }

    /**
     * 도서 반납 API
     *
     * @param request 도서 반납 요청 정보가 담긴 BookReturnRequest 객체
     * @return ResponseEntity<Void> 도서 반납 성공 시 200 OK 상태 코드와 빈 응답
     */
    @PostMapping(path = "/return", name = "도서 반납")
    public ResponseEntity<Void> returnBook(@RequestBody @Valid BookReturnRequest request) {
        // BookService의 returnBook 메서드를 호출하여 도서 반납을 수행
        bookService.returnBook(request);
        // 반납 성공 시 200 OK 상태 코드와 빈 응답을 반환
        return ResponseEntity.ok().build();
    }
}
