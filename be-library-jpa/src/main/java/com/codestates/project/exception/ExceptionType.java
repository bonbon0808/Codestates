package com.codestates.project.exception;

import org.springframework.http.HttpStatus;

/**
 * ExceptionType 열거형은 서비스에서 발생 가능한 예외들에 대한 상태 코드와 메시지를 정의합니다.
 */
public enum ExceptionType {

    /**
     * 이미 존재하는 아이디 예외
     */
    EXISTS_USER(HttpStatus.BAD_REQUEST, "이미 존재하는 아이디 입니다."),

    /**
     * 유저 정보가 없는 예외
     */
    NOT_FOUND_USER(HttpStatus.NOT_FOUND, "유저 정보가 없습니다."),

    /**
     * 도서 정보가 없는 예외
     */
    NOT_FOUND_BOOK(HttpStatus.NOT_FOUND, "도서 정보가 없습니다."),

    /**
     * 대출 중인 사용자 삭제 예외
     */
    EXISTS_LOANED_USER(HttpStatus.BAD_REQUEST, "대출 중인 사용자는 삭제할 수 없습니다."),

    /**
     * 대출 중인 도서 예외
     */
    EXISTS_LOANED_BOOK(HttpStatus.BAD_REQUEST, "대출 중인 도서입니다."),

    /**
     * 대출이 불가능한 상태 예외
     */
    NOT_ALLOW_LOAN(HttpStatus.BAD_REQUEST, "대출이 불가능한 상태입니다.");

    private final HttpStatus status;
    private final String errorMessage;

    /**
     * ExceptionType 생성자
     * @param status 예외 상태 코드
     * @param errorMessage 예외 메시지
     */
    ExceptionType(HttpStatus status, String errorMessage) {
        this.status = status;
        this.errorMessage = errorMessage;
    }

    /**
     * 예외의 상태 코드를 반환합니다.
     * @return HttpStatus 상태 코드
     */
    public HttpStatus getStatus() {
        return status;
    }

    /**
     * 예외의 메시지를 반환합니다.
     * @return 예외 메시지
     */
    public String getErrorMessage() {
        return errorMessage;
    }
}
