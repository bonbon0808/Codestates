package com.codestates.project.dto.request;

/**
 * 도서 반납 요청을 나타내는 클래스인 BookReturnRequest입니다.
 * 사용자 ID와 도서 ID를 가지고 있으며, 도서 반납 시 요청으로 사용됩니다.
 */
public class BookReturnRequest {

    private Long userId; // 반납을 요청하는 사용자의 ID

    private Long bookId; // 반납하고자 하는 도서의 ID

    /**
     * BookReturnRequest의 생성자입니다.
     * 기본 생성자로, 사용자 ID와 도서 ID는 따로 설정해주어야 합니다.
     */
    public BookReturnRequest() {
    }

    /**
     * BookReturnRequest의 생성자입니다.
     * 사용자 ID와 도서 ID를 받아서 객체를 생성합니다.
     * @param userId 반납을 요청하는 사용자의 ID
     * @param bookId 반납하고자 하는 도서의 ID
     */
    public BookReturnRequest(Long userId, Long bookId) {
        this.userId = userId;
        this.bookId = bookId;
    }

    /**
     * 사용자 ID를 반환합니다.
     * @return Long 사용자 ID
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 도서 ID를 반환합니다.
     * @return Long 도서 ID
     */
    public Long getBookId() {
        return bookId;
    }
}
