package com.codestates.project.exception;

import org.springframework.http.HttpStatus;

/**
 * 사용자 정의 예외 클래스인 CustomException입니다.
 * RuntimeException을 상속하여 일반적인 예외가 아닌 특정 예외 상황을 나타냅니다.
 * 프로젝트에서 발생하는 다양한 예외를 구분하기 위해 ExceptionType과 함께 사용됩니다.
 */
public class CustomException extends RuntimeException {

    private final ExceptionType exceptionType; // 예외 타입을 나타내는 Enum 객체

    /**
     * CustomException의 생성자입니다.
     * @param exceptionType 예외 타입을 나타내는 Enum 객체
     */
    public CustomException(ExceptionType exceptionType) {
        super(exceptionType.getErrorMessage());
        this.exceptionType = exceptionType;
    }

    /**
     * 예외 발생 시 HTTP 상태 코드를 반환합니다.
     * @return HttpStatus HTTP 상태 코드
     */
    public HttpStatus getHttpStatus() {
        return exceptionType.getStatus();
    }

    /**
     * 예외 발생 시 HTTP 상태 코드의 정수 값을 반환합니다.
     * @return int HTTP 상태 코드의 정수 값
     */
    public int getHttpStatusCode() {
        return exceptionType.getStatus().value();
    }
}
