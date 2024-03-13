package com.codestates.project.service;

import com.codestates.project.domain.Book;
import com.codestates.project.domain.UserInfo;
import com.codestates.project.dto.request.BookLoanRequest;
import com.codestates.project.dto.request.BookReturnRequest;
import com.codestates.project.dto.request.BookSearchRequest;
import com.codestates.project.dto.response.BookResponse;
import com.codestates.project.exception.CustomException;
import com.codestates.project.repository.UserLoanHistoryRepository;
import com.codestates.project.repository.BookRepository;
import com.codestates.project.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.codestates.project.domain.UserLoanStatus.LOANED;
import static com.codestates.project.exception.ExceptionType.EXISTS_LOANED_BOOK;

/**
 * BookService는 도서 관련 비즈니스 로직을 처리하는 서비스 클래스입니다.
 * 서비스 클래스에서는 도서 대출, 반납, 검색 등의 기능을 수행합니다.
 * Service 어노테이션으로 서비스 빈으로 등록되며, 트랜잭션 처리를 위해 Transactional 어노테이션을 사용합니다.
 */
@Service
@Transactional
public class BookService {

    private final BookRepository bookRepository;
    private final UserRepository userRepository;
    private final UserLoanHistoryRepository userLoanHistoryRepository;

    /**
     * BookService의 생성자로서, 의존성 주입을 받습니다.
     *
     * @param bookRepository          도서 정보를 조회하는 데 사용되는 BookRepository 인터페이스
     * @param userRepository         사용자 정보를 조회하는 데 사용되는 UserRepository 인터페이스
     * @param userLoanHistoryRepository 사용자 대출 이력 정보를 조회하는 데 사용되는 UserLoanHistoryRepository 인터페이스
     */
    public BookService(BookRepository bookRepository, UserRepository userRepository, UserLoanHistoryRepository userLoanHistoryRepository) {
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
        this.userLoanHistoryRepository = userLoanHistoryRepository;
    }

    /**
     * 도서 목록을 조회하는 메서드입니다.
     *
     * @param request  도서 검색 조건을 담고 있는 BookSearchRequest 객체
     * @param pageable 페이징 정보를 담고 있는 Pageable 객체
     * @return 도서 목록을 페이징하여 반환하는 Page 객체
     * @Transactional(readOnly = true) 어노테이션을 사용하여 읽기 전용 트랜잭션을 적용하여 조회 기능을 최적화합니다.
     */
    @Transactional(readOnly = true)
    public Page<BookResponse> searchBooks(BookSearchRequest request, Pageable pageable) {
        return bookRepository.searchBooks(request.getSearchType(), request.getSearchValue(), pageable);
    }

    /**
     * 도서를 대출하는 메서드입니다.
     *
     * @param request 도서 대출 요청 정보를 담고 있는 BookLoanRequest 객체
     * @throws CustomException 대출 중인 도서가 존재할 경우 예외 발생
     */
    public void loanBook(BookLoanRequest request) {
        // 도서 대출 중인 사용자가 존재하는지 조회합니다.
        int loanedCount = userLoanHistoryRepository.countByBookAndStatus(new Book(request.getBookId()), LOANED);
        if (loanedCount > 0) {
            throw new CustomException(EXISTS_LOANED_BOOK);
        }

        // 대출 요청한 사용자를 조회합니다.
        UserInfo user = userRepository.findByUserId(request.getUserId());
        // 사용자의 대출 이력에 도서를 대출하는 로직을 수행합니다.
        user.loanBook(request.getBookId());
    }

    /**
     * 도서를 반납하는 메서드입니다.
     *
     * @param request 도서 반납 요청 정보를 담고 있는 BookReturnRequest 객체
     */
    public void returnBook(BookReturnRequest request) {
        // 반납 요청한 사용자를 조회합니다.
        UserInfo user = userRepository.findByUserId(request.getUserId());
        // 사용자의 대출 이력에 도서 반납하는 로직을 수행합니다.
        user.returnBook(request.getBookId());
    }
}
