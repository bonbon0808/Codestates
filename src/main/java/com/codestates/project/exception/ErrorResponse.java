package com.codestates.project.exception;

/**
 * ErrorResponse 클래스는 예외 발생 시 클라이언트에게 반환할 오류 응답을 나타냅니다.
 * 예외 메시지와 HTTP 상태 코드를 포함합니다.
 */
public class ErrorResponse {

    private final String errorMessage; // 예외 메시지
    private final int statusCode; // HTTP 상태 코드

    /**
     * ErrorResponse의 생성자입니다.
     * @param errorMessage 예외 메시지
     * @param statusCode HTTP 상태 코드
     */
    public ErrorResponse(String errorMessage, int statusCode) {
        this.errorMessage = errorMessage;
        this.statusCode = statusCode;
    }

    /**
     * 예외 메시지를 반환합니다.
     * @return String 예외 메시지
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * HTTP 상태 코드를 반환합니다.
     * @return int HTTP 상태 코드
     */
    public int getStatusCode() {
        return statusCode;
    }
}
